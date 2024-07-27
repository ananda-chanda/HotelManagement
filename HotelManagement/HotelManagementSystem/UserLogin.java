package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin extends JFrame implements ActionListener{
  private JLabel username,password,image;
  private JButton login,signup,administrationlogin;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private ImageIcon imageIcon,logo;
  private FileReader file;
  private BufferedReader reader;
  public UserLogin(){

    //creating login frame
    super("Login Form");
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
    login.setBounds(40, 152, 120, 30);
    login.setFont(new Font("serif",Font.PLAIN,15));
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    this.add(login);
    login.addActionListener(this);

    //signupbutton
    signup=new JButton("Signup");
    signup.setBounds(180, 152, 120, 30);
    signup.setFont(new Font("serif",Font.PLAIN,15));
    signup.setBackground(Color.BLACK);
    signup.setForeground(Color.WHITE);
    this.add(signup);
    signup.addActionListener(this);

    //administration button
    administrationlogin=new JButton("Log in as administrative");
    administrationlogin.setBounds(80, 200, 180, 30);
    administrationlogin.setFont(new Font("serif",Font.PLAIN,15));
    administrationlogin.setBackground(Color.BLACK);
    administrationlogin.setForeground(Color.WHITE);
    this.add(administrationlogin);
    administrationlogin.addActionListener(this);

    //showing userlogin frame
    this.setVisible(true);
    
    
  }

  //adding action to the buttons
  @Override
  public void actionPerformed(ActionEvent event){

    String username=usernameField.getText();
    String pass=String.valueOf(passwordField.getPassword());
    //for user login
    if(event.getSource()==login){

      //for empty userlogin
      if(username.equals("")||pass.equals("")){
        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
      }

      //for valid userlogin
      else{
          try {
          String profilename=username;
          String profilepass=pass;
          String uname = "Username : " + username;
          String password = "Password : " + pass;
          file=new FileReader("registration.txt");
          reader = new BufferedReader(file);

          int flag = 0;
          while (reader.readLine() != null)
            flag++;
          reader.close();

          for (int i = 0; i <= flag; i++) {
          String line = Files.readAllLines(Paths.get("registration.txt")).get(i);
          if (line.equals(uname)){
          String line2 = Files.readAllLines(Paths.get("registration.txt")).get((i + 1));
          if (line2.equals(password)) {
            this.setVisible(false);
            new UserDashBoard(profilename);
            break;
            }
            }
          }
        } 
          catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",JOptionPane.WARNING_MESSAGE);
        }
      }
    }

    //for signup
    else if(event.getSource()==signup){
      this.setVisible(false);
      new UserSignup();
    }
    
    //for administration login
    else if(event.getSource()==administrationlogin){
      Administration administration=new Administration();
      administration.administration("admin", "admin");
      String uname=administration.getUsername();
      String passs=administration.getPassword();
      //for empty administrationlogin
      if(usernameField.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")){
        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
      }
      //for valid administration login
      else if(usernameField.getText().equals(uname)&&String.valueOf(passs).equals(administration.getPassword())){
        this.setVisible(false);
        new AdministrationDashboard();
      } 
    }
  }
}