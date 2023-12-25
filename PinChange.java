import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JButton back,change;
    JPasswordField pinTextField,rePinTextField;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(200,200,300,35);
        image.add(text);

        JLabel pinText = new JLabel("New Pin");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(120,240,100,20);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(280,240,150,20);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pinTextField);

        JLabel rePinText = new JLabel("Re-Enter Your Pin");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        rePinText.setBounds(120,275,200,20);
        image.add(rePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setBounds(280,275,150,20);
        rePinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(rePinTextField);

        change = new JButton("CHANGE");
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setBounds(300,386,150,28);
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        back.setBounds(300,420,150,28);
        image.add(back);



        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String npin = pinTextField.getText();
                String repin = rePinTextField.getText();

                if (!npin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (repin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn c = new Conn();

                String query1 = "update bank set pinNumber ='" + repin + "' where pinNumber = '" + pinNumber + "'";
                String query2 = "update login set pinNumber ='" + repin + "' where pinNumber = '" + pinNumber + "'";
                String query3 = "update signupthree set pinNumber ='" + repin + "' where pinNumber = '" + pinNumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(repin).setVisible(true);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        } else if (e.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
}
