package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom extends JFrame implements ActionListener {
    private JLabel addroom,roomno,price,bedtype,image;
    private JTextField roomnoTextField,priceTextField;
    private JComboBox bedtypeComboBox;
    private JButton add,back;
    private ImageIcon imageIcon,logo;
    private FileWriter file;
    private String[] bedtypes=new String[]{"Single Bed","Double Bed"};
    public AddRoom(){

    //creating add employee frame
    super("Add Room");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setSize(1000,650);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing addroom label
    addroom= new JLabel("Add Rooms");
    addroom.setBounds(194,35,250,40);
    addroom.setFont(new Font("Tahoma", Font.BOLD,25));
    addroom.setForeground(Color.WHITE);
    this.add(addroom);

    //customizing roomno label
    roomno= new JLabel("Room Number");
    roomno.setBounds(64,160,152,22);
    roomno.setFont(new Font("Tahoma", Font.BOLD, 16));
    roomno.setForeground(Color.WHITE);
    this.add(roomno);

    //customizing price label
    price= new JLabel("Price");
    price.setBounds(64,230,152,22);
    price.setFont(new Font("Tahoma", Font.BOLD, 16));
    price.setForeground(Color.WHITE);
    this.add(price);

    //customizing bed type label
    bedtype= new JLabel("Bed Type");
    bedtype.setBounds(64,300,152,22);
    bedtype.setFont(new Font("Tahoma", Font.BOLD, 14));
    bedtype.setForeground(Color.WHITE);
    this.add(bedtype);

    //customizing roomno text field
    roomnoTextField=new JTextField();
    roomnoTextField.setBounds(200,160,156,24);
    roomnoTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
    roomnoTextField.setForeground(Color.WHITE);
    roomnoTextField.setBackground(new Color(16,108,115));
    this.add(roomnoTextField);

    //customizing price text field
    priceTextField=new JTextField();
    priceTextField.setBounds(200,230,156,24);
    priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
    priceTextField.setForeground(Color.WHITE);
    priceTextField.setBackground(new Color(16,108,115));
    this.add(priceTextField);

    //customizing  bed type combobox
    bedtypeComboBox=new JComboBox(bedtypes);
    bedtypeComboBox.setBounds(200,300,156,24);
    bedtypeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
    bedtypeComboBox.setForeground(Color.WHITE);
    bedtypeComboBox.setBackground(new Color(16,108,115));
    this.add(bedtypeComboBox);

    //customizing add button
    add= new JButton("Add");
    add.setBounds(64,400,111,33);
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.addActionListener(this);
    this.add(add);

    //customizing back button
    back= new JButton("Back");
    back.setBounds(250,400,111,33);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    this.add(back);

    //adding image
    imageIcon= new ImageIcon(("icons/roomser.png"));
    image= new JLabel(imageIcon);
    image.setBounds(550,100,300,300);
    this.add(image);

    //showing addroom frame
    this.setVisible(true);
}

  @Override
    public void actionPerformed(ActionEvent event) {
    String roomno=roomnoTextField.getText();
    String price=priceTextField.getText();
    String bedtype=(String)bedtypeComboBox.getSelectedItem();

    if (event.getSource() == add){
        //adding all the inputs to a single variable
        String data= roomno +"," +price+","+bedtype;

        //for empty input
        if(roomno.equals("")||price.equals("")||bedtype.equals("")){
            JOptionPane.showMessageDialog(null,"Enter valid details to add new employee","Warning!", JOptionPane.WARNING_MESSAGE);
        }

        //for valid input
        else{
            try {
                file= new FileWriter("addroom.txt",true);
                file.write(data);
                file.write("\n");
                file.close();
                roomnoTextField.setText("");
                priceTextField.setText("");
                JOptionPane.showMessageDialog(null,"New Room Added");
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
