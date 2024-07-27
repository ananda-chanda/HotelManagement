package HotelManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashBoard extends JFrame implements ActionListener{
  private JButton addEmployee,addRoom,logout,back;
  private ImageIcon eimageIcon,rimageIcon,logo;
  private JLabel eimage,rimage;
  public AdminDashBoard(){

    //creating admin dashboard frame
    super("Admin Dashboard");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setSize(1000,650);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing JButtons
    //for addEmployee
    addEmployee = new JButton( "Add Employee");
    addEmployee.setBounds(280,180,200,30);
    addEmployee.setBackground(Color.WHITE);
    addEmployee.setForeground(Color.BLACK);
    addEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
    addEmployee.addActionListener(this);
    this.add(addEmployee);

    //for addRoom
    addRoom = new JButton( "Add Room");
    addRoom.setBounds(280,330,200,30);
    addRoom.setBackground(Color.WHITE);
    addRoom.setForeground(Color.BLACK);
    addRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
    addRoom.addActionListener(this);
    this.add(addRoom);

    //for logout
    logout = new JButton( "Logout");
    logout.setBounds(435,525,95,30);
    logout.setBackground(Color.BLACK);
    logout.setForeground(Color.WHITE);
    logout.setFont(new Font("Tahoma", Font.BOLD, 15));
    logout.addActionListener(this);
    this.add(logout);

    //for employee imageicon
    eimageIcon= new ImageIcon("icons/employees.png");
    eimage = new JLabel(eimageIcon);
    eimage.setBounds(150,155,85,85);
    this.add(eimage);

    //for room imageicon
    rimageIcon = new ImageIcon("icons/room.png");
    rimage=new JLabel(rimageIcon);
    rimage.setBounds(150,305,85,85);
    this.add(rimage);

    //showing the Jframe;
    this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == addEmployee){
           new AddEmployee();
           this.setVisible(false);
        } 
        else if (event.getSource() == addRoom) {
           new AddRoom();
           this.setVisible(false);
        }
        else if (event.getSource() == logout){
           new AdministrationDashboard();
           this.setVisible(false);
        } 
        else if (event.getSource() == back) {
          new AdministrationDashboard();
        }
        }
  }