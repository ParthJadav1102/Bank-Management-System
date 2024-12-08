package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextFeild;
    JPasswordField pinTextFeild;

    Login() {
        setTitle("Login");

        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raieway", Font.BOLD, 35));
        cardNo.setBounds(120, 150, 150, 40);
        add(cardNo);

        cardTextFeild = new JTextField();
        cardTextFeild.setBounds(300, 150, 230, 30);
        cardTextFeild.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextFeild);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 35));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextFeild = new JPasswordField();
        pinTextFeild.setBounds(300, 220, 230, 30);
        pinTextFeild.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextFeild);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);



        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            Conn conn = new Conn();
            String cardno = cardTextFeild.getText();
            String pinnumber = pinTextFeild.getText();
            String query = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.st.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        } else if (e.getSource() == clear) {
            cardTextFeild.setText("");
            pinTextFeild.setText("");
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
