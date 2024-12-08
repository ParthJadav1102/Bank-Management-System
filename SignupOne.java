package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {


    long random;
    JTextField nametextfield, fnametextfield, emailaddressfield, addressfield, cityfield, statefield, pincodefield;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;


    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No:" + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetail = new JLabel("Page 1: Personal Details");
        personDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetail.setBounds(290, 80, 400, 30);
        add(personDetail);

        JLabel name = new JLabel("name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        //name text field
        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        nametextfield.setBounds(300, 140, 400, 30);
        add(nametextfield);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        //father text field
        fnametextfield = new JTextField();
        fnametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametextfield.setBounds(300, 190, 400, 30);
        add(fnametextfield);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 400, 30);
        add(dob);

        dateChooser= new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailaddressfield = new JTextField();
        emailaddressfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailaddressfield.setBounds(300, 340, 400, 30);
        add(emailaddressfield);

        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address= new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressfield = new JTextField();
        addressfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addressfield.setBounds(300, 440, 400, 30);
        add(addressfield);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityfield = new JTextField();
        cityfield.setFont(new Font("Raleway", Font.BOLD, 14));
        cityfield.setBounds(300, 490, 400, 30);
        add(cityfield);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        statefield = new JTextField();
        statefield.setFont(new Font("Raleway", Font.BOLD, 14));
        statefield.setBounds(300, 540, 400, 30);
        add(statefield);

        JLabel pincode= new JLabel("Pin code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodefield = new JTextField();
        pincodefield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodefield.setBounds(300, 590, 400, 30);
        add(pincodefield);

        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660,80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailaddressfield.getText();
        String marital = null;
        if(married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if(other.isSelected()) {
            marital = "Other";
        }

        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin = pincodefield.getText();

        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+state+"', '"+pin+"', '"+address+"', '"+city+"')";
                c.st.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SignupOne();
    }

}
