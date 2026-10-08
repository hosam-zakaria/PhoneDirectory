package phonedirectory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static phonedirectory.UpdateOne.phone;

public class UpdateTwo extends JFrame implements ActionListener {

    // All Images in your frame updateTwo
    private ImageIcon icon_update = new ImageIcon("assets/updateing.png");
    private ImageIcon icon_back = new ImageIcon("assets/back.png");

    // All Label in your frame updateTwo
    private JLabel Title = new JLabel("UPDATE CONTACTS");
    private JLabel Fname = new JLabel("First Name");
    private JLabel Lname = new JLabel("Last Name");
    private JLabel Phone = new JLabel("Mobile Number");
    private JLabel Job = new JLabel("Job Title");
    private JLabel Email = new JLabel("Email");

    Search_Contacts search = new Search_Contacts(UpdateOne.phone.getText());
    // All Textfield in your frame updateTwo
    private JTextField fname = new JTextBox(search.data[0][1], WIDTH);
    private JTextField lname = new JTextBox(search.data[0][2], WIDTH);
    private JTextField phone = new JTextBox(search.data[0][0], WIDTH);
    private JTextField job = new JTextBox(search.data[0][3], WIDTH);
    private JTextField email = new JTextBox(search.data[0][4], WIDTH);

    // All Button in your frame updateTwo
    private JButton update = new JbuttonMM("UPDATE", icon_update);
    private JButton Exit = new JbuttonMM("BACK", icon_back);

    // Creates new form NewJFrame
    public UpdateTwo() {

        // Implementation of the frame updateTwo
        this.setTitle("UPDATE");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#A8B7FF"));

        // Implementation of the all Button
        update.setBounds(50, 380, 150, 40);
        update.setBackground(Color.WHITE);
        update.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(update);
        Exit.setBounds(270, 380, 150, 40);
        Exit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Exit.setBackground(Color.WHITE);
        this.add(Exit);

        // Implementation of the all Label
        Title.setBounds(135, 10, 200, 100);
        Title.setForeground(Color.BLACK);
        Title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Title);
        Fname.setBounds(50, 110, 150, 50);
        Fname.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Lname.setBounds(50, 160, 150, 50);
        Lname.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Lname);
        phone.setBounds(220, 220, 200, 30);
        this.add(phone);
        Job.setBounds(50, 260, 150, 50);
        Job.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Job);
        Email.setBounds(50, 310, 150, 50);
        Email.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Email);

        // Implementation of the all Textfield
        this.add(Fname);
        fname.setBounds(220, 120, 200, 30);
        this.add(fname);
        lname.setBounds(220, 170, 200, 30);
        this.add(lname);
        Phone.setBounds(50, 210, 150, 50);
        Phone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Phone);
        job.setBounds(220, 270, 200, 30);
        this.add(job);
        email.setBounds(220, 320, 200, 30);
        this.add(email);

        // addActionlistener of the all Button
        update.addActionListener(this);
        Exit.addActionListener(this);

        // Message of the user of the all button and the label
        fname.setToolTipText("Enter your first name");
        lname.setToolTipText("Enter your last name");
        email.setToolTipText("Enter your email");
        job.setToolTipText("Enter your job");
        phone.setToolTipText("Enter you phone");
        update.setToolTipText("Click to update");
        Exit.setToolTipText("Clik to Back");

        /* Create an icon the UpdateTwo frame */
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
            UpdateOne update = new UpdateOne();
        } else if (e.getSource() == update) {
            try {
                try {
                    if (fname.getText().isEmpty() || lname.getText().isEmpty() || job.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please complate your information");
                    } else if (phone.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter your phone");
                    } else if (phone.getText().length() < 11 || phone.getText().length() > 11) {
                        JOptionPane.showMessageDialog(null, "Please enter the correct number");
                    } else {
                        DataBase.Main.DateBase_update(phone.getText(), fname.getText(), lname.getText(), job.getText(), email.getText());
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

}
