package Window;

import javax.swing.*;
import java.awt.*;

import Else.FroggerGame;

public class MainWindow extends JPanel {
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

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, FroggerGame.Screen_Width, FroggerGame.Screen_Height);
        g.setColor(Color.PINK);
        drawString(g,"Welcome to Frogger !!!",new Rectangle(FroggerGame.Screen_Width, FroggerGame.Screen_Height / 6), 36);
        drawString(g,"Start a new game please press '1'",new Rectangle(FroggerGame.Screen_Width, 2 * FroggerGame.Screen_Height / 6), 18);
        drawString(g,"See the controls press '2'",new Rectangle(FroggerGame.Screen_Width, 3 * FroggerGame.Screen_Height / 6), 18);
        drawString(g,"See the high score press '3'",new Rectangle(FroggerGame.Screen_Width, 4 * FroggerGame.Screen_Height / 6), 18);
        drawString(g,"EXIT press '4'",new Rectangle(FroggerGame.Screen_Width, 5 * FroggerGame.Screen_Height / 6), 18);
    }
}
