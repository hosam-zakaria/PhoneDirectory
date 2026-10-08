package phonedirectory;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JbuttonM extends JButton {

    public JbuttonM(String name, ImageIcon icon) {
        super(name, icon);
        this.setOpaque(false);
    }

    public JbuttonM(String name) {
        super(name);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.decode("#A8B7FF"));
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 50);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 50);
    }

}
