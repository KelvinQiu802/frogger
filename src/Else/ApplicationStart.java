package Else;

import Listener.GameListener;
import Listener.MenuListener;
import Window.ControllerWindow;
import Window.GameWindow;
import Window.MainWindow;
import Window.ScoreWindow;
import ucd.comp2011j.engine.GameManager;
import ucd.comp2011j.engine.ScoreKeeper;

import javax.swing.*;

public class ApplicationStart {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("Frogger Game");
        window.setSize(FroggerGame.Screen_Width, FroggerGame.Screen_Height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setVisible(true);


        GameListener gameListener = new GameListener();
        window.addKeyListener(gameListener);

        MenuListener menuListener = new MenuListener();
        window.addKeyListener(menuListener);

        FroggerGame game = new FroggerGame(gameListener);

        GameWindow gameWindow = new GameWindow(game);
        MainWindow mainWindow = new MainWindow();
        ScoreKeeper scoreKeeper = new ScoreKeeper("scores.txt");

        GameManager mmm = new GameManager(game, window, menuListener, mainWindow, new ControllerWindow(),
                new ScoreWindow(scoreKeeper), gameWindow, scoreKeeper);

        mmm.run();
    }
}
