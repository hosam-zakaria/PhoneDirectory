package phonedirectory;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

public class Jbutton extends JButton {

    public Jbutton(String name) {
        super(name);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 50);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 50);
    }

}
