import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNumber;
    public MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Mini-Statement");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);



        try {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from login where pinNumber ='"+pinNumber+"'");
            while (rs.next()) {
                card.setText("Card Number: "+ rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" +rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet resultSet = c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (resultSet.next()) {
                mini.setText(mini.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +resultSet.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") +"<br><br><html>");
                if (resultSet.getString("type").equals("deposit")){
                    bal += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    bal -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            balance.setText("Your Current Account balance is Rs "+ bal);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        mini.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
