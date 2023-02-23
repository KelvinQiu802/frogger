package Window;

import ucd.comp2011j.engine.Score;
import ucd.comp2011j.engine.ScoreKeeper;
import Else.FroggerGame;

import javax.swing.*;
import java.awt.*;

public class ScoreWindow extends JPanel {
    private ScoreKeeper scoreKeeper;

    public ScoreWindow(ScoreKeeper sc) {
        this.scoreKeeper = sc;
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
        g.fillRect(0, 0, FroggerGame.Screen_Width, FroggerGame.Screen_Height);
        drawString(g, "Frogger Ranking List !!!", new Rectangle(0, 0, FroggerGame.Screen_Width, FroggerGame.Screen_Height / 8),
                36);
        g.setColor(Color.PINK);
        Score[] scores = scoreKeeper.getScores();
        g.setFont(new Font("Arial", Font.BOLD, 24));
        for (int i = 0; i < scores.length; i++) {
            Score score = scores[i];
            g.drawString(score.getName(), 2 * FroggerGame.Screen_Width / 6, 96 + i * 32);
            g.drawString("" + score.getScore(), 4 * FroggerGame.Screen_Width / 6, 96 + i * 32);
        }
        drawString(g, "Press '5' to return to the Main Menu", new Rectangle(0, 416, FroggerGame.Screen_Width, 96), 24);
    }
}
