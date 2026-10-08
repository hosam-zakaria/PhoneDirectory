package phonedirectory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static phonedirectory.UpdateOne.phone;

public class Search extends JFrame implements ActionListener {

    // All Images in your frame Search
    private ImageIcon icon_search = new ImageIcon("assets/searching.png");
    private ImageIcon icon_back = new ImageIcon("assets/back.png");

    // All Label in your frame Search
    private JLabel Title = new JLabel("SREACH CONTACTS");
    private JLabel Message = new JLabel("Enter the contact mobile you want to search");
    private JLabel Phone = new JLabel("Mobile Number");

    // All Label in your frame Search
    private JTextField phone = new JTextBox(WIDTH);

    // All Button in your frame Search
    private JButton search = new JbuttonMM("SEARCH", icon_search);
    private JButton Exit = new JbuttonMM("BACK", icon_back);

    // Creates new form NewJFrame
    public Search() {

        // Implementation of the frame Button
        this.setTitle("Search");
        this.setSize(500, 360);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#A8B7FF"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Implementation of the all Button
        search.setBounds(25, 240, 180, 40);
        search.setBackground(Color.WHITE);
        search.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(search);
        Exit.setBounds(245, 240, 200, 40);
        Exit.setBackground(Color.WHITE);
        Exit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Exit);

        // Implementation of the all label
        Title.setBounds(145, 10, 220, 100);
        Title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Title);
        Message.setBounds(25, 100, 480, 50);
        Message.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Message);
        Phone.setBounds(25, 160, 150, 50);
        Phone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Phone);

        // Implementaion of the all Textfield
        phone.setBounds(225, 170, 220, 30);
        this.add(phone);

        // addActionlistener of the all Button
        search.addActionListener(this);
        Exit.addActionListener(this);

        // Message of the user of the all button and the label
        phone.setToolTipText("Enter your phone");
        search.setToolTipText("Click to search");
        Exit.setToolTipText("Click to Back");

        /* Create an icon the search frame */
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
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Method the action all event button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Exit) {
            this.dispose();
        } else if (e.getSource() == search) {
            if (phone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your mobile");
            } else if (phone.getText().length() < 11 || phone.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Please enter the correct number");
            } else {
                Search_Contacts search = new Search_Contacts(phone.getText());
                search.setVisible(true);
            }
        }
    }

}
