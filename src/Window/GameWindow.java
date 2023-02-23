package Window;

import Else.Car;
import Else.FroggerGame;
import Else.Player;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {
    private FroggerGame game;

    public GameWindow(FroggerGame game) {
        this.game = game;
    }

    private void drawPlayer(Graphics2D gc, Player p) {
        int x = p.getX();
        int y = p.getY();
        gc.setColor(Color.GREEN);
        gc.fillRect(x, y, 30, 30);
    }

    private void drawCar(Graphics2D gc, Car c) {
        int x = c.getX();
        int y = c.getY();
        gc.setColor(Color.ORANGE);
        gc.fillRect(x, y, 30, 30);
    }

    private void drawRoad(Graphics2D gc) {
        gc.setColor(Color.GRAY);
        gc.fillRect(256, 72, 256, 30);
        gc.fillRect(256, 222, 256, 30);
        gc.fillRect(256, 432, 256, 30);
    }

    private void drawEdge(Graphics2D gc) {
        gc.setColor(Color.BLACK);
        gc.fillRect(512, 72, 256, 440);
        gc.fillRect(0, 72, 256, 440);

        gc.setColor(Color.BLUE);
        gc.fillRect(254, 70, 260, 2);
        gc.fillRect(254, 462, 260, 2);
        gc.fillRect(254, 72, 2, 390);
        gc.fillRect(512, 72, 2, 390);
    }

    private void drawString(Graphics g, String text, Rectangle rect, int size) {
        Graphics2D g2d = (Graphics2D) g.create();

        Font font = new Font("Arial", Font.BOLD, size);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics();
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        g2d.setColor(Color.PINK);
        g2d.drawString(text, x, y);

    }

    public void paintComponent(Graphics g) {
        if (game != null) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, FroggerGame.Screen_Width, FroggerGame.Screen_Height);
            g.setColor(Color.PINK);
            g.drawString("Lives:" + game.getLives(), 0, 20);
            g.drawString("Score:" + game.getPlayerScore(), FroggerGame.Screen_Width - 200, 20);

            drawRoad(g2);
            drawPlayer(g2, game.getPlayer());

            for (Car car :
                    game.getCar()) {
                drawCar(g2, car);
            }

            drawEdge(g2);

            if (game.isPaused() && !game.isGameOver()) {
                g.setColor(Color.PINK);
                drawString(g, "Press 'P' to continue", new Rectangle(20, 200, 150, 40), 18);
            } else if (game.isGameOver()) {
                g.setColor(Color.PINK);
                drawString(g, "Game over ", new Rectangle(20, 260, 150, 40), 18);
            }


        }
    }
}
