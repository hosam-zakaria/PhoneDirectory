package phonedirectory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class tablePrint extends JFrame implements ActionListener {

    JTable table;
    JScrollPane Scroll;
    String data[][];
    String Address[] = {"Mobile", "First Name", "Last Name", "Jop Title", "Email"};
    JButton print = new JButton("Print all");
    ArrayList<DBTable.Einsert> Data_Table = DataBase.Main.getInsert();

    public tablePrint() {
        this.setTitle("Show all data");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        data = new String[Data_Table.size()][5];
        for (int i = 0; i < Data_Table.size(); i++) {
            data[i][0] = Data_Table.get(i).getMobile();
            data[i][1] = Data_Table.get(i).getFname();
            data[i][2] = Data_Table.get(i).getLname();
            data[i][3] = Data_Table.get(i).getJob();
            data[i][4] = Data_Table.get(i).getEmail();
        }
        table = new JTable(data, Address);
        Scroll = new JScrollPane(table);
        Scroll.setBounds(0, 100, 400, 400);
        this.add(Scroll);
        print.setBounds(130, 30, 120, 30);
        print.setForeground(Color.black);
        print.setBackground(Color.white);
        print.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.add(print);
        print.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat Header = new MessageFormat("Contacts");
        MessageFormat F = new MessageFormat("Page (1)");
        try {
            table.print(JTable.PrintMode.NORMAL, Header, F);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
