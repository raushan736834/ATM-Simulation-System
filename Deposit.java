import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JButton back,deposit;
    JTextField amountTextField;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel amount = new JLabel("Enter the amount you want to Deposit");
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(150,200,300,35);
        image.add(amount);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,22));
        amountTextField.setBounds(150,250,280,20);
        image.add(amountTextField);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(300,383,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(300,416,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Deposit("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit){
            String number = amountTextField.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null,"Please, Enter the amount you want to deposit");
            }else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('" + pinNumber + "','" + date + "','deposit','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" deposited Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        }else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
}
