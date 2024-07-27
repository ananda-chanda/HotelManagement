package HotelManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame{

  private ImageIcon imageIcon,logo;
  private JLabel label;
  public Splash(){

    //creating JFrame and adding components
    super("Welcome");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setLayout(null);
    this.setSize(600,300);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //adding image to the frame
    imageIcon=new ImageIcon("icons/splash.gif");
    label=new JLabel(imageIcon);
    label.setBounds(160, 100, 265, 100);
    this.add(label);
    this.setVisible(true);
    
    //adding functionality to make the splash function sleep after 3 seconds(Using Thread class)
    try{
      Thread.sleep(2500);
      this.setVisible(false);
      new UserLogin();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}