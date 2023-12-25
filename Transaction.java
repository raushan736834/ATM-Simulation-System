import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdrawal,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinNumber;
    public Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(150,200,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(120,317,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("WITHDRAWAL");
        withdrawal.setBounds(300,317,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(120,350,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setBounds(300,350,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(120,383,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setBounds(300,383,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setBounds(300,416,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == exit){
                System.exit(0);
            } else if (ae.getSource() == deposit) {
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            } else if (ae.getSource() == withdrawal) {
                setVisible(false);
                new Withdrawal(pinNumber).setVisible(true);
            } else if (ae.getSource() == fastCash) {
                setVisible(false);
                new FastCash(pinNumber).setVisible(true);
            } else if (ae.getSource() == pinChange) {
                setVisible(false);
                new PinChange(pinNumber).setVisible(true);
            } else if (ae.getSource() == balanceEnquiry) {
                setVisible(false);
                new BalanceEnquiry(pinNumber).setVisible(true);
            } else if (ae.getSource() == miniStatement) {
                new MiniStatement(pinNumber).setVisible(true);
            }

    }
}
