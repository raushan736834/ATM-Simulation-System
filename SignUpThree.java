import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton saving,fixed,current,recurring_Deposit;
    JCheckBox atm, internet, mobile, emailSms, cheque, eStatement, declaration;

    JButton finish, cancel ;
    String formno;

    public SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel heading = new JLabel("Page 3: Account Details");
        heading.setBounds(220,10,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,28));
        add(heading);

        JLabel accType = new JLabel("Account Type");
        accType.setBounds(70,80,200,30);
        accType.setFont(new Font("Raleway",Font.BOLD,22));
        add(accType);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(70,120,200,20);
        saving.setBackground(Color.WHITE);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(330,120,200,20);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setBounds(70,150,200,20);
        current.setBackground(Color.WHITE);
        add(current);

        recurring_Deposit = new JRadioButton("Recurring Deposit Account");
        recurring_Deposit.setBounds(330,150,200,20);
        recurring_Deposit.setBackground(Color.WHITE);
        add(recurring_Deposit);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(current);
        accountGroup.add(saving);
        accountGroup.add(recurring_Deposit);
        accountGroup.add(fixed);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Raleway",Font.BOLD,22));
        cardNo.setBounds(70,200,200,30);
        add(cardNo);

        JLabel cardDetail = new JLabel("This is Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(70,220,400,30);
        add(cardDetail);

        JLabel number = new JLabel("XXXX - XXXX - XXXX - 4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,200,400,30);
        add(number);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(70,270,100,30);
        add(pin);

        JLabel pinDetail = new JLabel("This is Your 4 Digit PIN Number");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(70,290,400,30);
        add(pinDetail);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,270,400,30);
        add(pnumber);

        JLabel service = new JLabel("Services Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(70,340,400,30);
        add(service);

        atm = new JCheckBox("ATM Card");
        atm.setBackground(Color.WHITE);
        setFont(new Font("Raleway", Font.BOLD, 16));
        atm.setBounds(70,370,200,30);
        add(atm);

        internet = new JCheckBox("Internet Banking");
        internet.setBackground(Color.WHITE);
        setFont(new Font("Raleway", Font.BOLD, 16));
        internet.setBounds(330,370,200,30);
        add(internet);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.WHITE);
        mobile.setBounds(70,400,200,30);
        setFont(new Font("Raleway", Font.BOLD, 16));
        add(mobile);

        emailSms = new JCheckBox("Email & SMS Alert");
        emailSms.setBackground(Color.WHITE);
        emailSms.setBounds(330,400,200,30);
        setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailSms);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBackground(Color.WHITE);
        cheque.setBounds(70,430,200,30);
        setFont(new Font("Raleway", Font.BOLD, 16));
        add(cheque);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(330,430,200,30);
        add(eStatement);

        declaration = new JCheckBox("I hearby declaration the above entered deatails are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(70,480,600,30);
        add(declaration);

        finish = new JButton("Submit");
        finish.setBackground(Color.BLACK);
        finish.setForeground(Color.WHITE);
        finish.setFont(new Font("Raleway",Font.BOLD,14));
        finish.setBounds(220,530,100,30);
        finish.addActionListener(this);
        add(finish);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(380,530,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(850,780);
        setLocation(320,0);
        setTitle("Sign Up Page-3");

    }
    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == finish){
            String accountType = null;
            if (saving.isSelected()){
                accountType = "Saving Account";
            } else if (fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (recurring_Deposit.isSelected()) {
                accountType =  "Recurring Deposit account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L ) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L ) + 1000L);

            String facility ="";
            if (atm.isSelected()) {
                facility = facility + " ATM Card";
            } else if (internet.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (mobile.isSelected()) {
                facility =  facility + " Mobile Banking";
            } else if (emailSms.isSelected()) {
                facility =  facility + " Email & SMS Alert";
            } else if (cheque.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (eStatement.isSelected()) {
                facility = facility + " E-Statement";
            }

            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);


                    JOptionPane.showMessageDialog(null, "Card Number "+ cardNumber + "\n Pin: " + pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }

            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if (e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
