import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {
    JButton back,withdraw;
    JTextField withdrawTextField;
    String pinNumber;
    Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel amount = new JLabel("Enter the amount you want to Withdraw");
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(150,200,300,35);
        image.add(amount);

        withdrawTextField = new JTextField();
        withdrawTextField.setFont(new Font("Raleway",Font.BOLD,22));
        withdrawTextField.setBounds(150,250,280,20);
        image.add(withdrawTextField);

         withdraw= new JButton("WITHDRAW");
        withdraw.setBounds(300,383,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        new Withdrawal("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw){
            String number = withdrawTextField.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null,"Please, Enter the amount you want to withdraw");
            }else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('" + pinNumber + "','" + date + "','withdraw','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" withdraw Successfully");
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

