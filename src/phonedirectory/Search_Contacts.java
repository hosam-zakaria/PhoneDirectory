package phonedirectory;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Search_Contacts extends JFrame {

    JTable table;
    JScrollPane Scroll;
    String data[][] = new String[100][5];
    String Address[] = {"Mobile", "First Name", "Last Name", "Jop Title", "Email"};

    public Search_Contacts(String Search) {
        ArrayList<DBTable.Einsert> Data_Table = DataBase.Main.getContact(Search);
        this.setTitle("Show all data");
        this.setSize(1000, 100);
//        this.setVisible(true);
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
        Scroll.setBounds(0, 0, 1000, 400);
        this.add(Scroll);
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
}
