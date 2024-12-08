package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, miniStatement, pinchange, fastcash, balanceEnquiry, back;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawl Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE );
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry = new JButton("Rs 10,000");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else  {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();

            try {
                ResultSet rs = c.st.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(e.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into values('"+pinnumber+"', '"+date+"','withdrawl','"+amount+"')";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " has been successfully deposited");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }
}
