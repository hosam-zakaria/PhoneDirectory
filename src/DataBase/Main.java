package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import DBTable.Einsert;
import javax.swing.JOptionPane;

public class Main {

    // method to connect between java and database
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return DriverManager.getConnection("jdbc:sqlite:WorkHard.db");
    }

    // method insert to data in the application
    public static void DateBase(String Mobile, String Fname, String Lname, String Job, String Email) throws SQLException, ClassNotFoundException {
        try (
                Connection connect = connect(); PreparedStatement prepare = connect.prepareStatement("insert into Contact values (?,?,?,?,?)");) {
            prepare.setString(1, Mobile);
            prepare.setString(2, Fname);
            prepare.setString(3, Lname);
            prepare.setString(4, Job);
            prepare.setString(5, Email);
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Sccessfully added");
        } catch (SQLException e) {
            if (e.getMessage().equals("[SQLITE_CONSTRAINT]  Abort due to constraint violation (constraint failed)")) {
                JOptionPane.showMessageDialog(null, "Please enter the correct e-mail & & must include @ && .com");
            } else if (e.getMessage().equals("[SQLITE_CONSTRAINT]  Abort due to constraint violation (column Mobile is not unique)")) {
                JOptionPane.showMessageDialog(null, "This Mobile already exists!");
            } else if (e.getMessage().equals("[SQLITE_CONSTRAINT]  Abort due to constraint violation (column Email is not unique)")) {
                JOptionPane.showMessageDialog(null, "This email already exists!");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    // method count number contacts 
    public static int getCount() {

        try (
                Connection conect = connect(); PreparedStatement select = conect.prepareStatement("select count(Mobile) from Contact");) {
            ResultSet result = select.executeQuery();
            while (result.next()) {
                int count = result.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }

    // method show all data
    public static ArrayList<Einsert> getInsert() {
        ArrayList<Einsert> Values = new ArrayList<>();
        try (
                Connection conect = connect(); PreparedStatement select = conect.prepareStatement("select * from Contact");) {
            ResultSet result = select.executeQuery();
            while (result.next()) {
                Values.add(new Einsert(result.getString("Mobile"), result.getString("First_Name"), result.getString("Last_Name"), result.getString("JobTitle"), result.getString("Email")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Values;
    }

    // method show data by the mobile phone
    public static ArrayList<Einsert> getContact(String phone) {
        ArrayList<Einsert> Values = new ArrayList<>();
        try (
                Connection conect = connect(); PreparedStatement select = conect.prepareStatement("select * from Contact where Mobile = ?");) {
            select.setString(1, phone);
            ResultSet result = select.executeQuery();
            while (result.next()) {
                Values.add(new Einsert(result.getString("Mobile"), result.getString("First_Name"), result.getString("Last_Name"), result.getString("JobTitle"), result.getString("Email")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Values;
    }

    // method update data by the mobile phone
    public static void DateBase_update(String Mobile, String Fname, String Lname, String Job, String Email) throws SQLException, ClassNotFoundException {
        try (
                Connection connect = connect(); PreparedStatement prepare = connect.prepareStatement("update Contact set First_Name = ? , Last_Name = ? , JobTitle = ? , Email = ? where Mobile = ?");) {
            prepare.setString(1, Fname);
            prepare.setString(2, Lname);
            prepare.setString(3, Job);
            prepare.setString(4, Email);
            prepare.setString(5, Mobile);
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Successfully updated");
        } catch (SQLException e) {
            if (e.getMessage().equals("[SQLITE_CONSTRAINT]  Abort due to constraint violation (constraint failed)")) {
                JOptionPane.showMessageDialog(null, "Please enter the correct e-mail & & must include @ && .com");
            } else if (e.getMessage().equals("[SQLITE_CONSTRAINT]  Abort due to constraint violation (column Email is not unique)")) {
                JOptionPane.showMessageDialog(null, "This email already exists!");
            }
            System.out.println(e.getMessage());
        }
    }

    // method delete data by the mobile phone
    public static void DateBase(String Moblie) {
        try (
                Connection connect = connect(); PreparedStatement prepare = connect.prepareStatement("delete from Contact where Mobile = ?");) {
            prepare.setString(1, Moblie);
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Sccessfully deleted");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
