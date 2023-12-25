import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash  extends JFrame implements ActionListener {
        JButton deposit, withdrawal,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
        String pinNumber;
        public FastCash(String pinNumber){
            this.pinNumber = pinNumber;
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,800,700);
            add(image);

            JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
            text.setBounds(150,200,700,35);
            text.setFont(new Font("Raleway",Font.BOLD,20));
            text.setForeground(Color.WHITE);
            image.add(text);

            deposit = new JButton("Rs 100");
            deposit.setBounds(120,317,150,30);
            deposit.addActionListener(this);
            image.add(deposit);

            withdrawal = new JButton("Rs 500");
            withdrawal.setBounds(300,317,150,30);
            withdrawal.addActionListener(this);
            image.add(withdrawal);

            fastCash = new JButton("Rs 1000");
            fastCash.setBounds(120,350,150,30);
            fastCash.addActionListener(this);
            image.add(fastCash);

            miniStatement = new JButton("Rs 2000");
            miniStatement.setBounds(300,350,150,30);
            miniStatement.addActionListener(this);
            image.add(miniStatement);

            pinChange = new JButton("Rs 5000");
            pinChange.setBounds(120,383,150,30);
            pinChange.addActionListener(this);
            image.add(pinChange);

            balanceEnquiry = new JButton("Rs 10000");
            balanceEnquiry.setBounds(300,383,150,30);
            balanceEnquiry.addActionListener(this);
            image.add(balanceEnquiry);

            exit = new JButton("BACK");
            exit.setBounds(300,416,150,30);
            exit.addActionListener(this);
            image.add(exit);

            setSize(800,750);
            setLocation(300,0);
            setTitle("Transaction Page");
            setUndecorated(true);
            setVisible(true);
        }
        public static void main(String[] args) {

            new FastCash("");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == exit){
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            } else {
                String amount  = ((JButton) ae.getSource()).getText().substring(3);
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '" + pinNumber + "'");
                    int balance =0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','withdraw', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+ amount+ " Debited Successfully");

                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }


