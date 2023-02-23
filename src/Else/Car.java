package Else;

import java.awt.*;

public class Car {
    private int x;
    private int y;
    private Rectangle box;
    private boolean direction;  // true 向右， false 向左
    private boolean alive = true;


    public Car(int x, int y, boolean direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        box = new Rectangle(x, y, 30, 30);

    }

    public void move(double speed) {
        if (direction == true) {
            x = x + (int) speed;
        } else {
            x = x - (int) speed;
        }
        box.setLocation(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getDirection() {
        return direction;
    }

    public Rectangle getBox() {
        return box;
    }

    public boolean isAlive() {
        return alive;
    }

    public void destroy() {
        alive = false;
    }
}
