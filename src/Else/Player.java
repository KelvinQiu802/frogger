package Else;

import java.awt.*;

public class Player {
    private int x;
    private int y;
    private Rectangle box;
    private boolean alive = true;

    public Player() {
        x = 369;
        y = 432;
        box = new Rectangle(x, y, 30, 30);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBox() {
        return box;
    }

    public boolean isHit(Car c) {
        Rectangle s = c.getBox();
        if (s.intersects(box.getBounds())) {
            alive = false;
        }
        return s.intersects(box.getBounds());
    }

    public boolean isAlive() {
        return alive;
    }

    public void resetDestroyed() {
        alive = true;
        x = 369;
        y = 432;
        box = new Rectangle(x, y, 30, 30);
    }

    public void move(int x1, int y1) {
        Rectangle newBox = new Rectangle(x + x1, y + y1, 30, 30);
        if (FroggerGame.getScreenSize().contains(newBox.getBounds())) {
            box = newBox;
            this.x += x1;
            this.y += y1;
        }
    }

    public boolean hitEdge() {
        return (box.intersects(512, 72, 1, 390) || box.intersects(255, 72, 1, 390) || box.intersects(256, 462, 256, 1));
    }
}
