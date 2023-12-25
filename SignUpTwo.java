import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField aadharTextField,panTextField;
    JComboBox religionCombo,categoryCombo,occupationCombo,incomeCombo,eductionCombo;
    JRadioButton yesCitizen,noCitizen,yesAcc,noAcc;
    String formno;
    public SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel heading = new JLabel("Page 2: Additional Details");
        heading.setBounds(220,10,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,28));
        add(heading);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(80,70,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionCombo = new JComboBox<String>(valReligion);
        religionCombo.setBounds(300,70,400,30);
        religionCombo.setBackground(Color.WHITE);
        add(religionCombo);

        JLabel category = new JLabel("Category:");
        category.setBounds(80,110,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        categoryCombo = new JComboBox<String>(valCategory);
        categoryCombo.setBounds(300,110,400,30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setBounds(80,150,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);

        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Up to 10,00,000"};
        incomeCombo = new JComboBox<String>(valIncome);
        incomeCombo.setBounds(300,150,400,30);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);

        JLabel educational = new JLabel("Educational");
        educational .setBounds(80,190,200,30);
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(80,210,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);

        String valEducation[] = {"Non-Graduate","Graduation","Post Graduation","Doctrate","Other"};
        eductionCombo = new JComboBox<String>(valEducation);
        eductionCombo.setBounds(300,210,400,30);
        eductionCombo.setBackground(Color.WHITE);
        add(eductionCombo);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(80,250,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);

        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupationCombo = new JComboBox<String>(valOccupation);
        occupationCombo.setBounds(300,250,400,30);
        occupationCombo.setBackground(Color.WHITE);
        add(occupationCombo);

        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(80,290,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        add(pan);

        panTextField = new JTextField();
        panTextField.setBounds(300,290,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(80,330,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(300,330,400,30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadharTextField);

        JLabel sCitizen = new JLabel("Senior Citizen:");
        sCitizen.setBounds(80,370,200,30);
        sCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        add(sCitizen);

        yesCitizen = new JRadioButton("Yes");
        yesCitizen.setBounds(300,370,100,30);
        yesCitizen.setBackground(Color.WHITE);
        add(yesCitizen);

        noCitizen = new JRadioButton("No");
        noCitizen.setBounds(400,370,100,30);
        noCitizen.setBackground(Color.WHITE);
        add(noCitizen);

        ButtonGroup citizenGroup =new ButtonGroup();
        citizenGroup.add(noCitizen);
        citizenGroup.add(yesCitizen);

        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setBounds(80,410,210,30);
        existingAcc.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingAcc);

        yesAcc = new JRadioButton("Yes");
        yesAcc.setBounds(300,410,100,30);
        yesAcc.setBackground(Color.WHITE);
        add(yesAcc);

        noAcc = new JRadioButton("No");
        noAcc.setBounds(400,410,100,30);
        noAcc.setBackground(Color.WHITE);
        add(noAcc);

        ButtonGroup accGroup =new ButtonGroup();
        accGroup.add(noAcc);
        accGroup.add(yesAcc);

        JButton next = new JButton("Next");
        next.setBounds(600,460,100,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.GRAY);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,600);
        setLocation(320,50);
        setTitle("Sign Up Page-2");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) religionCombo.getSelectedItem();
        String category = (String) categoryCombo.getSelectedItem();
        String occupation = (String) occupationCombo.getSelectedItem();
        String income = (String) incomeCombo.getSelectedItem();
        String education = (String) eductionCombo.getSelectedItem();
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();
        String senior = null;
        if (yesCitizen.isSelected()) {
            senior = "Yes" ;
        } else {
            senior="No";
        }
        String accountExist = null;
        if (yesCitizen.isSelected()) {
            accountExist = "Yes" ;
        } else {
            accountExist="No";
        }
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+occupation+"','"+income+"','"+education+"','"+aadhar+"','"+pan+"','"+senior+"','"+accountExist+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
