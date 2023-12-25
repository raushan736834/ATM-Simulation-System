import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("CARD No.");
        cardno.setBounds(120,150,200,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setBounds(120,220,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(300,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);


        clear = new JButton("Clear");
        clear.setBounds(450,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(300,330,250,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);

        add(signUp);


        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (e.getSource() == login){
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"'and pinNumber ='"+pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if (e.getSource() == signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
}
