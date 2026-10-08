package phonedirectory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class UpdateOne extends JFrame implements ActionListener {

    // All Images in your frame updateOne
    private ImageIcon icon_update = new ImageIcon("assets/updateing.png");
    private ImageIcon icon_show = new ImageIcon("assets/show.png");
    private ImageIcon icon_back = new ImageIcon("assets/back.png");

    // All Label in your frame updateOne
    private JLabel Title = new JLabel("UPDATE CONTACTS");
    private JLabel Message = new JLabel("Enter the contact mobile you want to update");
    private JLabel Phone = new JLabel("Mobile Number");

    // All Textfield in your frame updateOne
    public static JTextField phone = new JTextBox(WIDTH);

    // All Button in your frame updateOne
    private JButton update = new JbuttonMM("UPDATE", icon_update);
    private JButton Exit = new JbuttonMM("BACK", icon_back);
    private JButton show = new JbuttonMM("SHOW", icon_show);

    // Creates new form NewJFrame
    public UpdateOne() {

        // Implementation of the frame updateOne
        this.setTitle("Search");
        this.setSize(500, 360);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#A8B7FF"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Implementation of the all Button
        update.setBounds(25, 240, 130, 40);
        update.setBackground(Color.WHITE);
        update.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(update);
        show.setBounds(180, 240, 120, 40);
        show.setBackground(Color.WHITE);
        show.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(show);
        Exit.setBounds(325, 240, 120, 40);
        Exit.setBackground(Color.WHITE);
        Exit.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(Exit);

        // Implementation of the all Label
        Title.setBounds(150, 10, 220, 100);
        Title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Title);
        Message.setBounds(25, 100, 480, 50);
        Message.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Message);
        Phone.setBounds(25, 160, 150, 50);
        Phone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Phone);

        // Implementation of the all TextFiedl
        phone.setBounds(225, 170, 220, 30);
        this.add(phone);

        // addActionlistener of the all Button
        update.addActionListener(this);
        Exit.addActionListener(this);
        show.addActionListener(this);

        // Message of the user of the all button and the label
        phone.setToolTipText("Enter your phone");
        Exit.setToolTipText("Click to Back");
        show.setToolTipText("Click to show the number data you want to update");
        update.setToolTipText("Click to update");

        /* Create an icon the updateOne frame */
        Image icon_main;
        try {
            File assetFile = new File("assets/main.png");
            if (assetFile.exists()) {
                icon_main = ImageIO.read(assetFile);
            } else {
                icon_main = ImageIO.read(getClass().getResource("main.png"));
            }
            this.setIconImage(icon_main);
        } catch (IOException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method the action all event button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Exit) {
            this.dispose();
        } else if (e.getSource() == update) {
            if (phone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your phone");
            } else if (phone.getText().length() < 11 || phone.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Please enter the correct number");
            } else {
                UpdateTwo updatetwo = new UpdateTwo();
                this.dispose();
            }

        } else if (e.getSource() == show) {
            if (phone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your phone");
            } else if (phone.getText().length() < 11 || phone.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Please enter the correct number");
            } else {
                Search_Contacts search = new Search_Contacts(phone.getText());
                search.setVisible(true);
            }
        }
    }

}
