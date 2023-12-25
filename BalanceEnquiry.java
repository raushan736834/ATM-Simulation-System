import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    public BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        back.setBounds(300,420,150,28);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs "+ balance);
        text.setForeground(Color.white);
        text.setBounds(130,200,400,30);
        image.add(text);

        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
    }
}
