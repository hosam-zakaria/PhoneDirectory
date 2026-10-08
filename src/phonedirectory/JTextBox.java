package phonedirectory;

import javax.swing.*;
import java.awt.*;

public class JTextBox extends JTextField {

    public JTextBox(String a,int size) {
        super(a , size);
        this.setOpaque(false);
    }
    public JTextBox(int size) {
        super(size);
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
