package HotelManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserDashBoard extends JFrame implements ActionListener{
  private JButton checkin,checkout,logout,profile,pback,cback,update,cadd;
  private JLabel cinimageLabel,coutimageLabel,bgimage,information,roomLabel,priceLabel,bedtypeLabel;
  private JTextArea profileArea;
  private ImageIcon cinimageIcon,bgimageIcon,logo;
  private String data,data1,name,profilename,profilepassword,password,mobileno,nid,gender,dob,address,profilemobileno,profilenid,profilegender,profiledob,profileaddress;
  private BufferedReader reader1,reader2,roomreader;
  private FileReader filer1,filer2,roomfile;
  private JPanel profilepanel,checkinpanel;
  private FileWriter filew;
  private JTable roomtable;
  private DefaultTableModel roommodel;
  public UserDashBoard(String uname){
  //creating user dashboard frame
  super(uname+" DashBoard");
  logo=new ImageIcon("icons/hotel.png");
  this.setIconImage(logo.getImage());
  this.setLayout(null);
  this.setSize(1000,650);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setResizable(false);
  this.getContentPane().setBackground(new Color(3,45,48));
  name="Username : "+uname;
  try{
  filer1=new FileReader("registration.txt");
  reader1= new BufferedReader(filer1);

    int flag = 0;
    while (reader1.readLine() != null)
      flag++;
    reader1.close();

    for (int i = 0; i <= flag; i++) {
    String name1= Files.readAllLines(Paths.get("registration.txt")).get(i);
    if (name1.equals(name)){
      password= Files.readAllLines(Paths.get("registration.txt")).get((i + 1));
      mobileno=Files.readAllLines(Paths.get("registration.txt")).get((i + 2));
      nid=Files.readAllLines(Paths.get("registration.txt")).get((i + 3));
      gender=Files.readAllLines(Paths.get("registration.txt")).get((i + 4));
      dob=Files.readAllLines(Paths.get("registration.txt")).get((i + 5));
      address=Files.readAllLines(Paths.get("registration.txt")).get((i + 6));
      break;
      }
    }
  }
  catch(Exception e){
    System.out.println(e);
  }

  profilename="Username : "+uname;
  profilepassword=password;
  profilemobileno=mobileno;
  profilenid=nid;
  profilegender=gender;
  profiledob=dob;
  profileaddress=address;

  //for profile
  profile=new JButton(uname);
  profile.setBounds(700,20,150,30);
  profile.setFont(new Font("Tahoma", Font.BOLD,15));
  profile.setBackground(new Color(255,98,0));
  profile.setForeground(Color.WHITE);
  profile.addActionListener(this);
  this.add(profile);
  profilepanel= new JPanel();
  profilepanel.setBackground(new Color(3,45,48));
  profilepanel.setBounds(250,25,450,570);
  profilepanel.setLayout(null);
  this.add(profilepanel);
  information= new JLabel("Profile Information");
  information.setBounds(120,11,220,31);
  information.setForeground(Color.WHITE);
  information.setFont(new Font("Tahoma", Font.BOLD,22));
  profilepanel.add(information);
  profileArea=new JTextArea();
  profileArea.setBounds(50,60,350,400);
  profileArea.setForeground(Color.WHITE);
  profileArea.setFont(new Font("Tahoma", Font.PLAIN,18));
  profileArea.setBackground(new Color(3,45,48));
  profileArea.setText(profilename+"\n"+profilepassword+"\n"+profilemobileno+"\n"+profilenid+"\n"+profilegender+"\n"+profiledob+"\n"+profileaddress+"\n");
  profileArea.setEditable(false);
  profilepanel.add(profileArea);

  profilepanel.setVisible(false);

  data=profileArea.getText();
  data1=uname;
  //customizing button
  //for checkin button
  checkin= new JButton("Check In");
  checkin.setBounds(420,400,140, 30);
  checkin.setFont(new Font("Tahoma", Font.BOLD,15));
  checkin.setBackground(new Color(255,98,0));
  checkin.setForeground(Color.WHITE);
  checkin.addActionListener(this);
  this.add(checkin);
  checkinpanel= new JPanel();//checkin panel
  checkinpanel.setBounds(190,40,600,550);
  checkinpanel.setBackground(new Color(3,45,48));
  checkinpanel.setLayout(null);
  this.add(checkinpanel);
  roomtable= new JTable();//roomtable
  roomtable.setBounds(20,50,560,350);
  roomtable.setBackground(new Color(30,45,48));
  roomtable.setForeground(Color.WHITE);
  checkinpanel.add(roomtable);
  try {
      roomfile=new FileReader("addroom.txt");
      roomreader= new BufferedReader(roomfile);
      String[] rcolumnsName = {"","",""};
      roommodel = (DefaultTableModel)roomtable.getModel();
      roommodel.setColumnIdentifiers(rcolumnsName);

      //get lines from txt file
      Object[] roomtableLines =roomreader.lines().toArray();
      
      //extratct data from lines
      //set data to jtable model
      for(int i = 0; i < roomtableLines.length; i++)
      {
          String line = roomtableLines[i].toString().trim();
          String[] rdataRow = line.split(",");
          roommodel.addRow(rdataRow);
      }  
  } 
      catch (Exception ex) {
        System.out.println(ex);
  } 
  roomLabel= new JLabel("Room No.");
  roomLabel.setBounds(80,15,80,19);
  roomLabel.setForeground(Color.WHITE);
  roomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
  checkinpanel.add(roomLabel);
  priceLabel= new JLabel("Price");
  priceLabel.setBounds(280,15,80,19);
  priceLabel.setForeground(Color.WHITE);
  priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
  checkinpanel.add(priceLabel);
  bedtypeLabel= new JLabel("Bed Type");
  bedtypeLabel.setBounds(450,15,80,19);
  bedtypeLabel.setForeground(Color.WHITE);
  bedtypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
  checkinpanel.add(bedtypeLabel);

  checkinpanel.setVisible(false);

  //for checkin imageicon
  cinimageIcon= new ImageIcon("icons/checkin.png");
  cinimageLabel= new JLabel(cinimageIcon);
  cinimageLabel.setBounds(450,300,85,85);
  this.add(cinimageLabel);

  //for logout
  logout= new JButton("Log Out");
  logout.setBounds(870,20,100,30);
  logout.setFont(new Font("Tahoma", Font.BOLD,15));
  logout.setBackground(new Color(255,98,0));
  logout.setForeground(Color.WHITE);
  logout.addActionListener(this);
  this.add(logout);

  //for profile back
  pback= new JButton("Back");
  pback.setBounds(180,500,100,30);
  pback.setFont(new Font("Tahoma", Font.BOLD,15));
  pback.setBackground(Color.BLACK);
  pback.setForeground(Color.WHITE);
  pback.addActionListener(this);
  profilepanel.add(pback);
  pback.setVisible(false);

  //for checkin back
  cback= new JButton("Back");
  cback.setBounds(350,470,120,30);
  cback.setFont(new Font("Tahoma", Font.BOLD,15));
  cback.setBackground(Color.BLACK);
  cback.setForeground(Color.WHITE);
  cback.addActionListener(this);
  checkinpanel.add(cback);

  //for checkin add
  cadd= new JButton("Check In");
  cadd.setBounds(120,470,120,30);
  cadd.setFont(new Font("Tahoma", Font.BOLD,15));
  cadd.setBackground(Color.BLACK);
  cadd.setForeground(Color.WHITE);
  cadd.addActionListener(this);
  checkinpanel.add(cadd);
  
  // //for update
  // update= new JButton("Update");
  // update.setBounds(100,500,100,30);
  // update.setFont(new Font("Tahoma", Font.BOLD,15));
  // update.setBackground(Color.BLACK);
  // update.setForeground(Color.WHITE);
  // update.addActionListener(this);
  // profilepanel.add(update);
  // update.setVisible(false);

  //for background image
  bgimageIcon = new ImageIcon("icons/Dashboard.gif");
  bgimage=new JLabel(bgimageIcon);
  bgimage.setSize(1107,654);
  this.add(bgimage);

  //showing administration JFrame
  this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
      if(event.getSource()==profile){
        profilepanel.setVisible(true);
        pback.setVisible(true);
        checkin.setVisible(false);
        cinimageLabel.setVisible(false);
        logout.setVisible(false);
        profile.setVisible(false);
        checkinpanel.setVisible(false);
      }
      else if(event.getSource()==pback){
        profilepanel.setVisible(false);
        checkin.setVisible(true);
        cinimageLabel.setVisible(true);
        profile.setVisible(true);
        logout.setVisible(true);
      }
      else if(event.getSource()==cback){
        profilepanel.setVisible(false);
        checkin.setVisible(true);
        cinimageLabel.setVisible(true);
        profile.setVisible(true);
        logout.setVisible(true);
        checkinpanel.setVisible(false);
      }
  //     else if(event.getSource()==update){
  //       String data=profileArea.getText();
  //       try{
  //         filer2=new FileReader("registration.txt");
  //         reader2=new BufferedReader(filer2);
  //         StringBuilder newcontent=new StringBuilder();
  //         int flag = 0;
  //         while (reader2.readLine() != null)
  //           flag++;
  //         reader2.close();
  //         for (int i = 0; i <= flag; i++) {
  //           String name2= Files.readAllLines(Paths.get("registration.txt")).get(i);
  //           if (name2.equals(name)){
  //           newcontent.replace(flag, i, name2);
  //       }
  //   }
  //             // filew= new FileWriter("registration.txt",true);
  //             // filew.write(data);
  //             // filew.write("\n"+"-----------------------" + "\n");
  //             // filew.write("-----------------------" + "\n");
  //             // filew.close();
  //  }
  //       catch(Exception e){
  //         System.out.println(e);
  //     }
  //   }
  else if(event.getSource()==checkin){
        checkinpanel.setVisible(true);
        profilepanel.setVisible(false);
        checkin.setVisible(false);
        cinimageLabel.setVisible(false);
        profile.setVisible(false);
        logout.setVisible(false);
  }
  else if (event.getSource() == cadd) {
        int selectedRow = roomtable.getSelectedRow();
        if (selectedRow !=-1) {
            String selectedRoom = roommodel.getValueAt(selectedRow, 0).toString();
            String selectedPrice = roommodel.getValueAt(selectedRow, 1).toString();
            String selectedBedType = roommodel.getValueAt(selectedRow, 2).toString();

            data1+=","+selectedRoom + "," + selectedPrice + "," + selectedBedType;

            try {
                filew= new FileWriter("checkin.txt", true); // You can change the filename
                filew.write(data1+ "\n");
                filew.close();
                JOptionPane.showMessageDialog(null, "Check In successful!");
            } 
            catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error during Check In.");
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "Please select a room to Check In.");
        }
    }
    else if(event.getSource()==logout){
        this.setVisible(false);
        new UserLogin();
  }
}
}