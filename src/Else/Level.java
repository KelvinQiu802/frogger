package Else;

public class Level {
    private double speed;
    private FroggerGame game;

    public Level(double s, FroggerGame g) {
        game = g;
        speed = s;
    }

    public double getSpeed() {
        return speed;
    }
}
