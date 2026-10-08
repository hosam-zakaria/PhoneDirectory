package phonedirectory;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Phone extends JFrame implements ActionListener {
    // all Images in your frame main
    private ImageIcon icon = new ImageIcon("assets/Untitled(1).png");
    private ImageIcon icon_add = new ImageIcon("assets/add.png");
    private ImageIcon icon_delete = new ImageIcon("assets/delete.png");
    private ImageIcon icon_search = new ImageIcon("assets/search.png");
    private ImageIcon icon_print = new ImageIcon("assets/print.png");
    private ImageIcon icon_update = new ImageIcon("assets/update.png");
    private ImageIcon icon_exit = new ImageIcon("assets/exit.png");
    private ImageIcon icon_main = new ImageIcon("assets/icon_main.png");
    private ImageIcon icon_sound = new ImageIcon("assets/sound.png");
    private ImageIcon icon_show = new ImageIcon("assets/show.png");
    private ImageIcon icon_email = new ImageIcon("assets/email.png");
    private ImageIcon icon_about = new ImageIcon("assets/about.png");
    
    // all Label in your frame main
    private JLabel Subject = new JLabel("Contacts");
    private JLabel Count = new JLabel();
    private JLabel Panel1 = new JLabel(icon_main);
    
    // all Button in your frame main
    private JButton Add = new JbuttonM("Add", icon_add);
    private JButton Delete = new JbuttonM("Delete", icon_delete);
    private JButton Search = new JbuttonM("Search", icon_search);
    private JButton Print = new JbuttonM("Print All", icon_print);
    private JButton Update = new JbuttonM("Update", icon_update);
    private JButton Quit = new JbuttonM("Quit", icon_exit);
    private JButton sound = new JbuttonM("Sound", icon_sound);
    private JButton Show_all = new JbuttonM("Show all", icon_show);
    private JButton show_email = new JbuttonM("email", icon_email);
    private JButton about = new JbuttonM("About", icon_about);
    
    // 
    private String count = String.valueOf(DataBase.Main.getCount());
    
    // Creates new form NewJFrame
    public Phone() {
        // Implementation of the main destination 
        this.setTitle("Contacts");
        this.setSize(500, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.decode("#CCCCCC"));
        
        // Implementation of the all Button
        this.add(Panel1);
        Add.setBounds(50, 110, 160, 50);
        Add.setForeground(Color.black);
        Add.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Add.setBackground(Color.decode("#A8B7FF"));
        this.add(Add);
        Search.setBounds(50, 180, 160, 50);
        Search.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Search.setForeground(Color.black);
        Search.setBackground(Color.decode("#A8B7FF"));
        this.add(Search);
        Update.setBounds(50, 250, 160, 50);
        Update.setBackground(Color.decode("#A8B7FF"));
        Update.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Update.setForeground(Color.BLACK);
        this.add(Update);
        sound.setBounds(260, 320, 160, 50);
        sound.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        sound.setBackground(Color.decode("#A8B7FF"));
        this.add(sound);
        Show_all.setBounds(260, 250, 160, 50);
        Show_all.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Show_all.setBackground(Color.decode("#A8B7FF"));
        this.add(Show_all);
        Delete.setBounds(50, 320, 160, 50);
        Delete.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Delete.setForeground(Color.BLACK);
        Delete.setBackground(Color.decode("#A8B7FF"));
        this.add(Delete);
        Print.setBounds(50, 390, 160, 50);
        Print.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Print.setForeground(Color.BLACK);
        Print.setBackground(Color.decode("#A8B7FF"));
        this.add(Print);
        show_email.setBounds(260, 390, 160, 50);
        show_email.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        show_email.setBackground(Color.decode("#A8B7FF"));
        show_email.setForeground(Color.BLACK);
        this.add(show_email);
        Quit.setBounds(50, 460, 160, 50);
        Quit.setBackground(Color.decode("#A8B7FF"));
        Quit.setForeground(Color.BLACK);
        Quit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(Quit);
        about.setBounds(260, 460, 160, 50);
        about.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        about.setForeground(Color.BLACK);
        about.setBackground(Color.decode("#A8B7FF"));
        this.add(about);
        
        // Implementation of the all Label
        Subject.setBounds(150, 25, 150, 50);
        Subject.setFont(new Font("Comic Sans MS", Font.TYPE1_FONT, 35));
        Subject.setForeground(Color.black);
        this.add(Subject);
        Count.setBounds(75, 507, 350, 50);
        Count.setFont(new Font("Comic Sans MS", Font.TYPE1_FONT, 25));
        Count.setText("number phone directory : " + count);
        this.add(Count);
        Panel1.setBounds(260, 107, 160, 125);
        
        // addActionlistener of the all Button
        Add.addActionListener(this);
        Delete.addActionListener(this);
        Print.addActionListener(this);
        Search.addActionListener(this);
        Update.addActionListener(this);
        Quit.addActionListener(this);
        sound.addActionListener(this);
        Show_all.addActionListener(this);
        show_email.addActionListener(this);
        about.addActionListener(this);
        
        // Message of the user of the all button and the label
        Add.setToolTipText("Enter the add page");
        Delete.setToolTipText("Enter the delete page");
        Print.setToolTipText("Enter the print page");
        Search.setToolTipText("Enter the search page");
        Update.setToolTipText("Enter the update page");
        Quit.setToolTipText("Exit the program");
        sound.setToolTipText("Play audioُ");
        Show_all.setToolTipText("Show all data");
        show_email.setToolTipText("Open Email");
        about.setToolTipText("Show information");
        
        /* Create an icon the main frame */
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
        if (e.getSource() == Quit) {
            int reuslt = JOptionPane.showConfirmDialog(null, "Are You Sure Quit", "Quit", JOptionPane.YES_NO_OPTION);
            if (reuslt == 0) {
                System.exit(0);
            }
        } else if (e.getSource() == Add) {
            Add add = new Add();
        } else if (e.getSource() == Delete) {
            Delete delete = new Delete();
        } else if (e.getSource() == Search) {
            Search search = new Search();
        } else if (e.getSource() == Update) {
            UpdateOne update = new UpdateOne();
        } else if (e.getSource() == sound) {
            try {
                Desktop.getDesktop().open(new File("utomp3.mp3"));
            } catch (IOException ex) {
                Logger.getLogger(Phone.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (e.getSource() == Print) {
            tablePrint printAll = new tablePrint();
        } else if (e.getSource() == about) {
            About aBout = new About();
        } else if (e.getSource() == Show_all) {
            Table table = new Table();
        } else if (e.getSource() == show_email) {
            try {
                Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/mu/mp/437/#co"));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Phone.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
