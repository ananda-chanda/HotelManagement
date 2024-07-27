package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdministrationDashboard extends JFrame implements ActionListener{
    private JButton admin,reception,back;
    private ImageIcon rimageIcon,bimageIcon,bgimageIcon,logo;
    private JLabel rimage,bimage,bgimage;

    public AdministrationDashboard(){
    //creation administration dashboard frame
    super("Administration Dashboard");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setLayout(null);
    this.setSize(1000,650);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //customizing button
    //for reception button
    reception = new JButton("Reception");
    reception.setBounds(210,300,140, 30);
    reception.setFont(new Font("Tahoma", Font.BOLD,15));
    reception.setBackground(new Color(255,98,0));
    reception.setForeground(Color.WHITE);
    reception.addActionListener(this);
    this.add(reception);

    //for admin
    admin = new JButton("Admin");
    admin.setBounds(630,300,140,30);
    admin.setFont(new Font("Tahoma", Font.BOLD,15));
    admin.setBackground(new Color(255,98,0));
    admin.setForeground(Color.WHITE);
    admin.addActionListener(this);
    this.add(admin);

    //for back
    back = new JButton("Back");
    back.setBounds(430,480,120,30);
    back.setFont(new Font("Tahoma", Font.BOLD,15));
    back.setBackground(new Color(255,98,0));
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    this.add(back);

    //for reception imageicon
    rimageIcon= new ImageIcon("icons/Reception.png");
    rimage = new JLabel(rimageIcon);
    rimage.setBounds(240,200,85,85);
    this.add(rimage);

    //for admin imageicon
    bimageIcon = new ImageIcon("icons/boss.png");
    bimage=new JLabel(bimageIcon);
    bimage.setBounds(655,200,85,85);
    this.add(bimage);

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
        if (event.getSource()==reception){
            new ReceptionDashboard();
            this.setVisible(false);
        }else if(event.getSource()==admin) {
            new AdminLogin();
            this.setVisible(false);
        }
        else if(event.getSource()==back){
          new UserLogin();
          this.setVisible(false);
        }
    }
}