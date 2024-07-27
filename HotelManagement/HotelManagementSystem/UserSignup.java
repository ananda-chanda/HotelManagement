package HotelManagementSystem;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class UserSignup extends JFrame implements ActionListener{
  private JLabel name,mobileno,nid,gender,dateofbirth,address,password;
  private JTextField nameField,mobilenoField,nidField;
  private JPasswordField passwordField;
  private JTextArea addressArea;
  private JRadioButton male,female;
  private ButtonGroup genderGroup;
  private JComboBox day,month,year;
  private JCheckBox termscCheckBox;
  private JButton submit,back;
  private FileWriter file;
  private ImageIcon logo;
  private String days[]
        = { "1", "2", "3", "4", "5","6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
        = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private String years[]
        = { "1991","1992","1993","1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019","2020", "2021", "2022",
            "2023" };

  public UserSignup(){

    //creating signup frame
    super("Registration Form");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setLayout(null);
    this.setSize(500,650);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing JLabels-------
    //for name
    name=new JLabel("Name");
    name.setBounds(60,40, 150, 30);
    name.setFont(new Font("Tahoma",Font.PLAIN,16));
    name.setForeground(Color.WHITE);
    this.add(name);

    //for mobileno
    mobileno=new JLabel("Mobile No.");
    mobileno.setBounds(60,90, 150, 30);
    mobileno.setFont(new Font("Tahoma",Font.PLAIN,16));
    mobileno.setForeground(Color.WHITE);
    this.add(mobileno);

    //for nid
    nid=new JLabel("NID");
    nid.setBounds(60,140, 150, 30);
    nid.setFont(new Font("Tahoma",Font.PLAIN,16));
    nid.setForeground(Color.WHITE);
    this.add(nid);

    //for gender
    gender=new JLabel("Gender");
    gender.setBounds(60,190, 150, 30);
    gender.setFont(new Font("Tahoma",Font.PLAIN,16));
    gender.setForeground(Color.WHITE);
    this.add(gender);

    //for dateofbirth
    dateofbirth=new JLabel("Date OF Birth");
    dateofbirth.setBounds(60,240, 150, 30);
    dateofbirth.setFont(new Font("Tahoma",Font.PLAIN,16));
    dateofbirth.setForeground(Color.WHITE);
    this.add(dateofbirth);

    //for address
    address=new JLabel("Address");
    address.setBounds(60,340, 150, 30);
    address.setFont(new Font("Tahoma",Font.PLAIN,16));
    address.setForeground(Color.WHITE);
    this.add(address);

    //for password
    password=new JLabel("Password");
    password.setBounds(60,410, 150, 30);
    password.setFont(new Font("Tahoma",Font.PLAIN,16));
    password.setForeground(Color.WHITE);
    this.add(password);

    //customizing JTextFields
    //for nameField
    nameField=new JTextField();
    nameField.setBounds(230,40,190,30);
    nameField.setForeground(Color.WHITE);
    nameField.setFont(new Font("Tahoma", Font.PLAIN,15));
    nameField.setBackground(new Color(26,104,110));
    this.add(nameField);

    //for mobilenoTextField
    mobilenoField=new JTextField();
    mobilenoField.setBounds(230,90,190,30);
    mobilenoField.setForeground(Color.WHITE);
    mobilenoField.setFont(new Font("Tahoma", Font.PLAIN,15));
    mobilenoField.setBackground(new Color(26,104,110));
    this.add(mobilenoField);

    //for nidTextField
    nidField=new JTextField();
    nidField.setBounds(230,140,190,30);
    nidField.setForeground(Color.WHITE);
    nidField.setFont(new Font("Tahoma", Font.PLAIN,15));
    nidField.setBackground(new Color(26,104,110));
    this.add(nidField);

    //adding JRadioButton
    //for male
    male=new JRadioButton("Male");
    male.setBounds(230, 190, 90, 30);
    male.setForeground(Color.WHITE);
    male.setFont(new Font("Tahoma", Font.PLAIN,15));
    male.setBackground(new Color(26,104,110));
    male.setSelected(true);
    this.add(male);

    //for female
    female=new JRadioButton("Female");
    female.setBounds(330, 190, 90, 30);
    female.setForeground(Color.WHITE);
    female.setFont(new Font("Tahoma", Font.PLAIN,15));
    female.setBackground(new Color(26,104,110));
    this.add(female);

    //adding to the ButtonGroup
    genderGroup=new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);

    //customizing dateofbirth
    //for day
    day = new JComboBox(days);
    day.setBounds(230, 240, 50, 30);
    day.setForeground(Color.WHITE);
    day.setBackground(new Color(26,104,110));
    day.setFont(new Font("Arial", Font.PLAIN, 15));
    this.add(day);

    //for month
    month = new JComboBox(months);
    month.setBounds(280, 240, 55, 30);
    month.setForeground(Color.WHITE);
    month.setBackground(new Color(26,104,110));
    month.setFont(new Font("Arial", Font.PLAIN, 15));
    this.add(month);
    
    //for year
    year = new JComboBox(years);
    year.setBounds(335, 240, 85, 30);
    year.setForeground(Color.WHITE);
    year.setBackground(new Color(26,104,110));
    year.setFont(new Font("Arial", Font.PLAIN, 15));;
    this.add(year);

    //customizing address area
    addressArea=new JTextArea();
    addressArea.setBounds(230,290,190,100);
    addressArea.setForeground(Color.WHITE);
    addressArea.setFont(new Font("Tahoma", Font.PLAIN,15));
    addressArea.setBackground(new Color(26,104,110));
    this.add(addressArea);

    //customizing JPasswordField
    passwordField=new JPasswordField();
    passwordField.setBounds(230,410,190,30);
    passwordField.setForeground(Color.WHITE);
    passwordField.setFont(new Font("Tahoma", Font.PLAIN,15));
    passwordField.setBackground(new Color(26,104,110));
    this.add(passwordField);

    //customizing termsCheckBox
    termscCheckBox = new JCheckBox("Accept Terms And Conditions.");
    termscCheckBox.setFont(new Font("Arial", Font.PLAIN, 11));
    termscCheckBox.setBounds(150, 480, 180, 20);
    termscCheckBox.setBackground(new Color(26,104,110));
    termscCheckBox.setForeground(Color.WHITE);
    this.add(termscCheckBox);

    //customizing submit button
    submit=new JButton("Submit");
    submit.setBounds(150, 530, 80, 30);
    submit.setFont(new Font("serif",Font.PLAIN,15));
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    this.add(submit);
    submit.addActionListener(this);

    //customizing back button
    back=new JButton("Back");
    back.setBounds(250, 530, 80, 30);
    back.setFont(new Font("serif",Font.PLAIN,15));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    this.add(back);
    back.addActionListener(this);
    
    //showing the JFrame
    this.setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent event) {
    
      if(event.getSource()==submit){
        String name= nameField.getText();
        String password= String.valueOf(passwordField.getPassword());
        String mobileno=mobilenoField.getText();
        String nid=nidField.getText();
        String dob=(String)day.getSelectedItem()+ "/" + (String)month.getSelectedItem()+ "/" + 
          (String)year.getSelectedItem();
        String address=addressArea.getText();

        //if the termsCheckBox is checked
        if(termscCheckBox.isSelected()){

          //adding all the inputs to a single variable
          String data= "Username : "+name+"\n" + "Password : " +password+ "\n"+ "Mobile : "+ mobileno+ "\n" + "NID : " + nid+ "\n";
          String gender = "Male";
          if (female.isSelected())
          gender = "Female";
          data += "Gender : " + gender + "\n";
  
          data+= "Date Of Birth : "+ dob +"\n";
          data += "Address : " + address  + "\n";

          //for empty input
          if(name.equals("")||mobileno.equals("")||password.equals("")||nid.equals("")||address.equals("")){
            JOptionPane.showMessageDialog(null,"Enter valid details to complete registration","Warning!", JOptionPane.WARNING_MESSAGE);
          }

          //for invalid input
          else if(name.equals("admin") || password.equals("admin")){
            JOptionPane.showMessageDialog(null,"Error","Warning!", JOptionPane.WARNING_MESSAGE);
          }
          else if(name.equals("manager") || password.equals("admin")){
            JOptionPane.showMessageDialog(null,"Error","Warning!", JOptionPane.WARNING_MESSAGE);
          }

          //for valid input
          else{
            try {
              file= new FileWriter("registration.txt",true);
              file.write(data);
              file.write("-----------------------" + "\n");
              file.write("-----------------------" + "\n");
              file.close();
              this.setVisible(false);
              new UserLogin();
            }
            catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Invalid user details!", "Warning!",JOptionPane.WARNING_MESSAGE);
            }
          }
          }

        //if the termsCheckBox is not checked
        else{
          JOptionPane.showMessageDialog(null, "Please check terms and conditions", "Warning!", JOptionPane.WARNING_MESSAGE); 
        }  
    }
      else{
        this.setVisible(false);
        new UserLogin();
      }
    }
}