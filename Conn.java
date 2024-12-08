package bank.management.system;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public class Conn {

    Connection con;
    Statement st;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
