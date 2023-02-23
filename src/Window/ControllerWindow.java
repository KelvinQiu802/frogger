package Window;

import javax.swing.*;
import Else.FroggerGame;

import java.awt.*;

public class ControllerWindow extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, FroggerGame.Screen_Width, FroggerGame.Screen_Height);
        g.setColor(Color.PINK);
        drawString(g, "Frogger Controls", new Rectangle(0, 0, FroggerGame.Screen_Width, 64), 36);
        g.drawString("Move Left", 1 * FroggerGame.Screen_Width / 6, 96 + 0 * 32);
        g.drawString("Press ←", 4 * FroggerGame.Screen_Width / 6, 96 + 0 * 32);
        g.drawString("Move Right", 1 * FroggerGame.Screen_Width / 6, 96 + 1 * 32);
        g.drawString("Press →", 4 * FroggerGame.Screen_Width / 6, 96 + 1 * 32);
        g.drawString("Move Up", 1 * FroggerGame.Screen_Width / 6, 96 + 2 * 32);
        g.drawString("Press ↑", 4 * FroggerGame.Screen_Width / 6, 96 + 2 * 32);
        g.drawString("Move Down", 1 * FroggerGame.Screen_Width / 6, 96 + 3 * 32);
        g.drawString("Press ↓", 4 * FroggerGame.Screen_Width / 6, 96 + 3 * 32);
        drawString(g, "Press '5' to return to the Main Menu", new Rectangle(0, 416, FroggerGame.Screen_Width, 96), 24);
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
}
