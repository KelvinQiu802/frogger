package Else;

import Listener.GameListener;
import ucd.comp2011j.engine.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class FroggerGame implements Game {
    public static final int Screen_Width = 768;
    public static final int Screen_Height = 512;
    public static final Rectangle Screen_Size = new Rectangle(0, 0, Screen_Width, Screen_Height);
    private int playerLives;
    private int playerScore;
    private boolean pause = true;
    private GameListener listener;
    private Player player;
    private static final int totalLevels = 5;
    private int currentLevel = 0;
    private ArrayList<Car> carArrayList = new ArrayList<>();
    private int playerSpeed = 2;
    private int farDis = 432;
    private Level[] level;

    public FroggerGame(GameListener listener) {
        this.listener = listener;
        startNewGame();
    }

    @Override
    public int getPlayerScore() {
        return playerScore;
    }

    @Override
    public int getLives() {
        return playerLives;
    }

    public static Rectangle getScreenSize() {
        return new Rectangle(Screen_Size);
    }

    @Override
    public void updateGame() {
        if (!isPaused()) {
            if (player.hitEdge()) {
                player.resetDestroyed();
            }
            moveCar();
            movePlayer();
            for (Car car : carArrayList
            ) {
                player.isHit(car);

            }
            if (!player.isAlive()) {
                playerLives--;
            }
        }

        calculateScore();
    }

    public void moveCar() {
        for (Car car :
                carArrayList) {
            car.move(currentLevel + 1);
        }
    }

    @Override
    public boolean isPaused() {
        return pause;
    }

    @Override
    public void checkForPause() {
        if (listener.isPause()) {
            pause = !pause;
            listener.resetPause();
        }
    }

    @Override
    public void startNewGame() {
        level = new Level[5];
        level[0] = new Level(1, this);
        level[1] = new Level(2, this);
        level[2] = new Level(3, this);
        level[3] = new Level(4, this);
        level[4] = new Level(5, this);
        currentLevel = 0;
        playerLives = 3;
        playerScore = 0;
        player = new Player();
        Timer timer = new Timer();
        TimerTask addCar = new TimerTask() {
            @Override
            public void run() {
                carArrayList.add(new Car(226, 312, true));
                carArrayList.add(new Car(512, 132, false));
            }
        };

        timer.scheduleAtFixedRate(addCar, 0, 5000 / (currentLevel + 1));
    }


    @Override
    public boolean isLevelFinished() {
        if (currentLevel < totalLevels) {
            if (player.getY() == 72) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    @Override
    public void resetDestroyedPlayer() {
        player.resetDestroyed();
    }

    @Override
    public void moveToNextLevel() {
        pause = true;
        currentLevel++;
        player.resetDestroyed();
        carArrayList = new ArrayList<Car>();
        farDis = 432;

    }

    @Override
    public boolean isGameOver() {
        return !(playerLives > 0 && currentLevel <= totalLevels);
    }

    @Override
    public int getScreenWidth() {
        return Screen_Width;
    }

    @Override
    public int getScreenHeight() {
        return Screen_Height;
    }

    public Player getPlayer() {
        return player;
    }

    public void movePlayer() {
        if (listener.isUp()) {
            player.move(0, -1 * playerSpeed);
        } else if (listener.isDown()) {
            player.move(0, playerSpeed);
        } else if (listener.isRight()) {
            player.move(playerSpeed, 0);
        } else if (listener.isLeft()) {
            player.move(-1 * playerSpeed, 0);
        }
    }

    public int calculateScore() {
        if (player.getY() < farDis) {
            farDis = player.getY();
        }
        playerScore = ((432 - farDis) / 30) * 10 + (currentLevel * 170);
        return playerScore;
    }

    public ArrayList<Car> getCar() {
        return carArrayList;
    }
}
