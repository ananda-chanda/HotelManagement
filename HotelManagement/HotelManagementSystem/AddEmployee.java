package HotelManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class AddEmployee extends JFrame implements ActionListener{
private JTextField nameTextField,ageTextField,salaryTextField,phoneTextField,nidTextField,emailTextField;
private JLabel nameLabel,ageLabel,salaryLabel,phoneLabel,nidLabel,emailLabel,genderLabel,jobLabel,addemdetailsLabel,img;
private JRadioButton maleradioButton,femaleradioButton;
private String[] jobs=new String[]{"Receptionist", "Housekeeping", "Kitchen Staff","Room Service", "Manager", "Accountant","Chef"};
private JComboBox comboBox;
private JButton add,back;
private FileWriter file;
private ImageIcon imageIcon,logo;
 public AddEmployee(){

    //creating add employee frame
    super("Add Employee");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setSize(1000,650);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing Jlabel


    //customizing namelabel
    nameLabel= new JLabel("Name");
    nameLabel.setBounds(60,80,150,27);
    nameLabel.setFont(new Font("serif", Font.PLAIN, 17));
    nameLabel.setForeground(Color.WHITE);
    this.add(nameLabel);

    //customizing agelabel
    ageLabel= new JLabel("Age");
    ageLabel.setBounds(60,130,150,27);
    ageLabel.setFont(new Font("serif", Font.PLAIN, 17));
    ageLabel.setForeground(Color.WHITE);
    this.add(ageLabel);

    //customizing genderlabel
    genderLabel= new JLabel("Gender");
    genderLabel.setBounds(60,180,150,27);
    genderLabel.setFont(new Font("serif", Font.PLAIN, 17));
    genderLabel.setForeground(Color.WHITE);
    this.add(genderLabel);

    //customizing joblabel
    jobLabel= new JLabel("Job");
    jobLabel.setBounds(60,230,150,27);
    jobLabel.setFont(new Font("serif", Font.PLAIN,17));
    jobLabel.setForeground(Color.WHITE);
    this.add(jobLabel);

    //customizing salarylabel
    salaryLabel= new JLabel("Salary");
    salaryLabel.setBounds(60,280,150,27);
    salaryLabel.setFont(new Font("serif", Font.PLAIN, 17));
    salaryLabel.setForeground(Color.WHITE);
    this.add(salaryLabel); 

    //customizing phonelabel
    phoneLabel= new JLabel("Phone");
    phoneLabel.setBounds(60,330,150,27);
    phoneLabel.setFont(new Font("serif", Font.PLAIN, 17));
    phoneLabel.setForeground(Color.WHITE);
    this.add(phoneLabel);

    //customizing nidlabel
    nidLabel= new JLabel("NID");
    nidLabel.setBounds(60,380,150,27);
    nidLabel.setFont(new Font("serif", Font.PLAIN, 17));
    nidLabel.setForeground(Color.WHITE);
    this.add(nidLabel);

    //customizing emaillabel
    emailLabel= new JLabel("Email");
    emailLabel.setBounds(60,430,150,27);
    emailLabel.setFont(new Font("serif", Font.PLAIN, 17));
    emailLabel.setForeground(Color.WHITE);
    this.add(emailLabel);

    //customizing add employee details Label
    addemdetailsLabel= new JLabel("Add Employee Details");
    addemdetailsLabel.setBounds(540,80,445,35);
    addemdetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
    addemdetailsLabel.setForeground(Color.WHITE);
    this.add(addemdetailsLabel);

    //customizing name text field
    nameTextField= new JTextField();
    nameTextField.setBounds(200,80,150,27);
    nameTextField.setBackground(new Color(16,108,115));
    nameTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    nameTextField.setForeground(Color.WHITE);
    this.add(nameTextField);

    //customizing age text field
    ageTextField= new JTextField();
    ageTextField.setBounds(200,130,150,27);
    ageTextField.setBackground(new Color(16,108,115));
    ageTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    ageTextField.setForeground(Color.WHITE);
    this.add(ageTextField);

    //customizing radio buttons
    //for male
    maleradioButton= new JRadioButton("Male");
    maleradioButton.setBounds(200,180,70,27);
    maleradioButton.setBackground(new Color(3,45,48));
    maleradioButton.setFont(new Font("Tahoma", Font.PLAIN,14));
    maleradioButton.setForeground(Color.WHITE);
    this.add(maleradioButton);

    //for female
    femaleradioButton= new JRadioButton("Female");
    femaleradioButton.setBounds(280,180,100,27);
    femaleradioButton.setBackground(new Color(3,45,48));
    femaleradioButton.setFont(new Font("Tahoma", Font.PLAIN,14));
    femaleradioButton.setForeground(Color.WHITE);
    this.add(femaleradioButton);

    //customizing jobs combobox
    comboBox=new JComboBox(jobs);
    comboBox.setBackground(new Color(16,108,115));
    comboBox.setBounds(200,230,150,30);
    comboBox.setFont(new Font("Tahoma", Font.PLAIN,14));
    comboBox.setForeground(Color.WHITE);
    this.add(comboBox);

    //customizing name text field
    salaryTextField= new JTextField();
    salaryTextField.setBounds(200,280,150,27);
    salaryTextField.setBackground(new Color(16,108,115));
    salaryTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    salaryTextField.setForeground(Color.WHITE);
    this.add(salaryTextField);

    //customizing phone text field
    phoneTextField= new JTextField();
    phoneTextField.setBounds(200,330,150,27);
    phoneTextField.setBackground(new Color(16,108,115));
    phoneTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    phoneTextField.setForeground(Color.WHITE);
    this.add(phoneTextField);

    //customizing nid textfield
    nidTextField= new JTextField();
    nidTextField.setBounds(200,380,150,27);
    nidTextField.setBackground(new Color(16,108,115));
    nidTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    nidTextField.setForeground(Color.WHITE);
    this.add(nidTextField);

    //customizing email text field
    emailTextField= new JTextField();
    emailTextField.setBounds(200,430,150,27);
    emailTextField.setBackground(new Color(16,108,115));
    emailTextField.setFont(new Font("Tahoma", Font.PLAIN,14));
    emailTextField.setForeground(Color.WHITE);
    this.add(emailTextField);

    //customizing JButton
    //customizing add button
    add= new JButton("ADD");
    add.setBounds(80,500,100,30);
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.addActionListener(this);
    this.add(add);

    back = new JButton("Back");
    back.setBounds(200,500,100,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    this.add(back);

    //add image icon
    imageIcon= new ImageIcon(("icons/addemp.png"));
    img= new JLabel(imageIcon);
    img.setBounds(550,170,300,300);
    this.add(img);

    //showing add employee frame
    this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent event) {
    String name=nameTextField.getText();
    String age=ageTextField.getText();
    String salary=salaryTextField.getText();
    String nid=nidTextField.getText();
    String job=(String)comboBox.getSelectedItem();
    String phonenum=phoneTextField.getText();
    String email=emailTextField.getText();

    if (event.getSource() == add){
        //adding all the inputs to a single variable
        String data= name  +"," + age+ ","+ salary+ ","+nid+ ","+job+ "," +phonenum+","+email+",";
        String gender = "Male";
        if (femaleradioButton.isSelected())
        gender = "Female";
        data += gender;

            
    //for empty input
    if(name.equals("")||age.equals("")||salary.equals("")||nid.equals("")||phonenum.equals("")||email.equals("")){
        JOptionPane.showMessageDialog(null,"Enter valid details to add new employee","Warning!", JOptionPane.WARNING_MESSAGE);
        }

    //for valid input
    else{
        try {
            file= new FileWriter("addemployee.txt",true);
            file.write(data);
            file.close();
            nameTextField.setText("");
            ageTextField.setText("");
            salaryTextField.setText("");
            nidTextField.setText("");
            phoneTextField.setText("");
            nidTextField.setText("");
            emailTextField.setText("");
            JOptionPane.showMessageDialog(null,"New Employee Added");
            }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid user details!", "Warning!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    else if(event.getSource()==back){
        new AdminDashBoard();
        this.setVisible(false);
    }
  }
}