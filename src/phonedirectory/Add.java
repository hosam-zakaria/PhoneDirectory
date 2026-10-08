package phonedirectory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static phonedirectory.UpdateOne.phone;

public class Add extends JFrame implements ActionListener {

    // all Images in your frame add
    private ImageIcon icon_add = new ImageIcon("assets/adding.png");
    private ImageIcon icon_back = new ImageIcon("assets/back.png");

    // all Label in your frame add
    private JLabel Title = new JLabel("ADD CONTACTS");
    private JLabel Fname = new JLabel("First Name");
    private JLabel Lname = new JLabel("Last Name");
    private JLabel Phone = new JLabel("Mobile Number");
    private JLabel Job = new JLabel("Job Title");
    private JLabel Email = new JLabel("Email");

    // all textfield in your frame add
    private JTextField fname = new JTextBox(50);
    private JTextField lname = new JTextBox(WIDTH);
    private JTextField phone = new JTextBox(WIDTH);
    private JTextField job = new JTextBox(WIDTH);
    private JTextField email = new JTextBox(WIDTH);

    // all Button in your add
    private JButton Add = new JbuttonMM("ADD", icon_add);
    private JButton Exit = new JbuttonMM("BACK", icon_back);

    // Creates new frame NewJFrame
    public Add() {

        // Implementation of the frame add
        this.setTitle("ADD");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#A8B7FF"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Implementation of the all Button
        Add.setBounds(45, 380, 155, 40);
        Add.setBackground(Color.white);
        Add.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Add);
        Exit.setBounds(265, 380, 155, 40);
        Exit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Exit.setBackground(Color.white);
        this.add(Exit);

        // Implementation of the all Label
        Title.setBounds(150, 10, 200, 100);
        Title.setForeground(Color.BLACK);
        Title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Title);
        Fname.setBounds(50, 110, 150, 50);
        Fname.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Fname);
        Lname.setBounds(50, 160, 150, 50);
        Lname.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Lname);
        Phone.setBounds(50, 210, 150, 50);
        Phone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Phone);
        Email.setBounds(50, 310, 150, 50);
        Email.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Email);
        Job.setBounds(50, 260, 150, 50);
        Job.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Job);

        // Implementation of the all textfield
        fname.setBounds(220, 120, 200, 30);
        this.add(fname);
        lname.setBounds(220, 170, 200, 30);
        this.add(lname);
        phone.setBounds(220, 220, 200, 30);
        this.add(phone);
        job.setBounds(220, 270, 200, 30);
        this.add(job);
        email.setBounds(220, 320, 200, 30);
        this.add(email);

        // addActionlistener of the all Button
        Add.addActionListener(this);
        Exit.addActionListener(this);
        fname.setToolTipText("Enter your first name");
        lname.setToolTipText("Enter your last name");
        email.setToolTipText("Enter your email");

        // Message of the user of the all button and the label
        job.setToolTipText("Enter your job");
        phone.setToolTipText("Enter you phone");
        Add.setToolTipText("Click to Add");
        Exit.setToolTipText("Click to Back");

        /* Create an icon the add frame */
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

        } else if (e.getSource() == Add) {
            try {
                if (fname.getText().isEmpty() || lname.getText().isEmpty() || job.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Plaese complate your information");
                } else if (phone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your phone number");
                } else if (phone.getText().length() < 11 || phone.getText().length() > 11) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct number");
                } else {
                    DataBase.Main.DateBase(phone.getText(), fname.getText(), lname.getText(), job.getText(), email.getText());
                }

            } catch (SQLException exxٍِ) {
                JOptionPane.showMessageDialog(null, exxٍِ.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
