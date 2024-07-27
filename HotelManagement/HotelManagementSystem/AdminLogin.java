package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame implements ActionListener{
  private JLabel username,password,image;
  private JButton login,back;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private ImageIcon imageIcon,logo;
  public AdminLogin(){

    //creating login frame
    super("Admin Login Form");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setLayout(null);
    this.setSize(600,300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing JLabels-------
    //For Username
    username=new JLabel("Username");
    username.setBounds(40, 32, 100, 30);
    username.setFont(new Font("Tahoma",Font.PLAIN,16));
    username.setForeground(Color.WHITE);
    this.add(username);

    //For Password
    password=new JLabel("Password");
    password.setBounds(40, 82, 100, 30);
    password.setFont(new Font("Tahoma",Font.PLAIN,16));
    password.setForeground(Color.WHITE);
    this.add(password);

    //customizing Jtextfield
    usernameField=new JTextField();
    usernameField.setBounds(150,32,150,30);
    usernameField.setForeground(Color.WHITE);
    usernameField.setFont(new Font("Tahoma", Font.PLAIN,15));
    usernameField.setBackground(new Color(26,104,110));
    this.add(usernameField);

    //customizing JPasswordField
    passwordField = new JPasswordField();
    passwordField.setBounds(150,82,150,30);
    passwordField.setForeground(Color.WHITE);
    passwordField.setBackground(new Color(26,104,110));
    this.add(passwordField);

    //adding image to the login page
    imageIcon=new ImageIcon("icons/login.png");
    image=new JLabel(imageIcon);
    image.setBounds(340, 32, 200, 200);
    this.add(image);
    
    //adding buttons
    //login button
    login=new JButton("Login");
    login.setBounds(40,180, 100, 30);
    login.setFont(new Font("serif",Font.PLAIN,15));
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    this.add(login);
    login.addActionListener(this);

    //for backbutton
    //adding buttons
    //login button
    back=new JButton("Back");
    back.setBounds(200, 180, 100, 30);
    back.setFont(new Font("serif",Font.PLAIN,15));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    this.add(back);
    back.addActionListener(this);

    //showing userlogin frame
    this.setVisible(true);
    
    
  }

  //adding action to the buttons
  @Override
  public void actionPerformed(ActionEvent event){
    String username=usernameField.getText();
    String pass=String.valueOf(passwordField.getPassword());
    Admin admin=new Admin();
    admin.admin("anand", "anand");
    String uname=admin.getUsername();
    String passs=admin.getPassword();
    //for user login
    if(event.getSource()==login){

      //for empty adminlogin
      if(username.equals("")||pass.equals("")){
        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
      }

      //for invalid adminlogin
      else if(username.equals(uname)!=true ||pass.equals(passs)!=true){
         JOptionPane.showMessageDialog(null, "Invalid username and password", "Warning!",JOptionPane.WARNING_MESSAGE);
      }

      //for valid adminlogin
      else if(username.equals(uname)&&pass.equals(passs)){
          new AdminDashBoard();
          this.setVisible(false);
      }
  }
  else if(event.getSource()==back){
    new AdministrationDashboard();
    this.setVisible(false);
  }
  }
}