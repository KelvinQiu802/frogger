package Listener;

import ucd.comp2011j.engine.MenuCommands;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuListener implements MenuCommands, KeyListener {
    private boolean newGame;
    private boolean controller;
    private boolean exit;
    private boolean score;
    private boolean menu;
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            newGame = true;
        } else if (e.getKeyChar() == '2') {
            controller = true;
        } else if (e.getKeyChar() == '3') {
            score = true;
        } else if (e.getKeyChar() == '4') {
            exit = true;
        } else if (e.getKeyChar() == '5') {
            menu = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public boolean hasPressedNewGame() {
        return newGame;
    }

    @Override
    public boolean hasPressedAboutScreen() {
        return controller;
    }

    @Override
    public boolean hasPressedHighScoreScreen() {
        return score;
    }

    @Override
    public boolean hasPressedMenu() {
        return menu;
    }

    @Override
    public boolean hasPressedExit() {
        return exit;
    }

    @Override
    public void resetKeyPresses() {
        exit = false;
        menu = false;
        score = false;
        newGame = false;
        controller = false;
    }
}
