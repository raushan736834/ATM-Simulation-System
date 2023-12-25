import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextfield,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignUpOne(){

        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formno= new JLabel("Application Form No. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,28));
        formno.setBounds(220,10,800,30);
        add(formno);

        JLabel personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,24));
        personalDetails.setBounds(250,60,400,30);
        add(personalDetails);

        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,110,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,110,400,30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(nameTextField);

        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,160,200,30);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setBounds(300,160,400,30);
        fnameTextfield.setFont(new Font("Raleway",Font.BOLD,16));
        add(fnameTextfield);

        JLabel dob= new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,210,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,210,400,30);
        add(dateChooser);

        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,260,200,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(300,260,100,30);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBackground(Color.WHITE);
        female.setBounds(400,260,100,30);
        add(female);

        other = new JRadioButton("OTHER");
        other.setBackground(Color.WHITE);
        other.setBounds(500,260,200,30);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        JLabel email= new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,310,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300,310,400,30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(emailTextField);

        JLabel martial= new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,360,200,30);
        add(martial);

        married = new JRadioButton("MARRIED");
        married.setBackground(Color.WHITE);
        married.setBounds(300,360,100,30);
        add(married);

        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400,360,100,30);
        add(unmarried);

        ButtonGroup martailGroup =new ButtonGroup();
        martailGroup.add(married);
        martailGroup.add(unmarried);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,410,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300,410,400,30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(addressTextField);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,460,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300,460,400,30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(cityTextField);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,510,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300,510,400,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(stateTextField);

        JLabel pin= new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,560,200,30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300,560,400,30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(600,610,100,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.GRAY);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,700);
        setLocation(350,10);
        setTitle("Sign Up Page-1");
    }

    public static void main(String[] args) {

        new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno =""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextfield.getText();
        String email = emailTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String address = addressTextField.getText();
        String gender = null;
        if(male.isSelected())
            gender= "Male";
        else if(female.isSelected())
            gender= "Female";
        else
            gender = "Other";
        String marital_status = null;
        if(married.isSelected())
            marital_status = "Married";
        else
            marital_status = "Unmarried";
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin= pinTextField.getText();

        try{
            if (name .equals("")) {
                JOptionPane.showMessageDialog(null,"Name is Required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null,"Email Address is Required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null,"Address is Required");
            } else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            } else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            } else if (pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
            }
//            else if (gender.equals("")) {
//                JOptionPane.showMessageDialog(null,"Gender is Required");
//            }
//            else if (marital.equals("")){
//                JOptionPane.showMessageDialog(null,"Marital is Required");
//            }
            else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+marital_status+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch (Exception e1){
            System.out.println(e1);
        }
    }
}
