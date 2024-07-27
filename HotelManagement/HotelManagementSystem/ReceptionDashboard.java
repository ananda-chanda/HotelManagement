package HotelManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ReceptionDashboard extends JFrame implements ActionListener {
  private JButton room,alleminfo,cusinfo,searchroom,logout,back,roomdelete,roomupdate,employeedelete,employeeupdate,search,checkout,ssearch;
  private JComboBox choice;
  private JTable sroomtable,roomtable,employeetable,customertable;
  private FileReader roomfile,employeefile,customerfile,sroomfile;
  private BufferedReader roomreader,employeereader,customerreader,sroomreader;
  private DefaultTableModel roommodel,employeemodel,customermodel,sroommodel;
  private JPanel roompanel,employeepanel,searchpanel,customerpanel;
  private JLabel cnameLabel,croomLabel,cpriceLabel,cbedtypeLabel,roomLabel,priceLabel,bedtypLabel,searchLabel,sroomLabel,sroomnoLabel,spriceLabel,sbedtypLabel,nameLabel,ageLabel,genderLabel,jobLabel,salaryLabel,phoneLabel,nidLabel,emailLabel;
  private String[] choices=new String[]{"Single Bed","Double Bed"};
  private String sroomno,sbedtype,sprice;
  private ImageIcon logo;
  public ReceptionDashboard(){
    //creating admin dashboard frame
    super("Reception Dashboard");
    logo=new ImageIcon("icons/hotel.png");
    this.setIconImage(logo.getImage());
    this.setSize(1000,650);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(3,45,48));

    //customizing button
    //for room button
    room= new JButton("Room");
    room.setBounds(30,40,200,30);
    room.setBackground(Color.BLACK);
    room.setForeground(Color.WHITE);
    this.add(room);
    room.addActionListener(this);
    roompanel= new JPanel();//roompanel
    roompanel.setBounds(310,40,600,550);
    roompanel.setBackground(new Color(3,45,48));
    roompanel.setLayout(null);
    this.add(roompanel);
    roompanel.setVisible(false);
    roomtable= new JTable();//roomtable
    roomtable.setBounds(20,50,560,350);
    roomtable.setBackground(new Color(3,45,48));
    roomtable.setForeground(Color.WHITE);
    roompanel.add(roomtable);
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
    roompanel.add(roomLabel);
    priceLabel= new JLabel("Price");
    priceLabel.setBounds(280,15,80,19);
    priceLabel.setForeground(Color.WHITE);
    priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    roompanel.add(priceLabel);
    bedtypLabel= new JLabel("Bed Type");
    bedtypLabel.setBounds(450,15,80,19);
    bedtypLabel.setForeground(Color.WHITE);
    bedtypLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    roompanel.add(bedtypLabel);

    //for all employee info button
    alleminfo= new JButton("All Employee Info");
    alleminfo.setBounds(30,120,200,30);
    alleminfo.setBackground(Color.BLACK);
    alleminfo.setForeground(Color.WHITE);
    this.add(alleminfo);
    alleminfo.addActionListener(this);
    employeepanel= new JPanel();//employee panel
    employeepanel.setBounds(235,15,750,580);
    employeepanel.setBackground(new Color(3,45,48));
    employeepanel.setLayout(null);
    this.add(employeepanel);
    employeepanel.setVisible(false);
    employeetable= new JTable();//roomtable
    employeetable.setBounds(25,50,700,420);
    employeetable.setBackground(new Color(3,45,48));
    employeetable.setForeground(Color.WHITE);
    employeepanel.add(employeetable);
      try {
          employeefile=new FileReader("addemployee.txt");
          employeereader= new BufferedReader(employeefile);
          String[] columnsName = {"","","","","","","",""};
          employeemodel = (DefaultTableModel)employeetable.getModel();
          employeemodel.setColumnIdentifiers(columnsName);

          //get lines from txt file
          Object[] employeetableLines =employeereader.lines().toArray();
          
          //extratct data from lines
          //set data to jtable model
          for(int i = 0; i < employeetableLines.length; i++)
          {
              String line = employeetableLines[i].toString().trim();
              String[] edataRow = line.split(",");
              employeemodel.addRow(edataRow);
          }  
      } 
          catch (Exception ex) {
            System.out.println(ex);
      } 
    nameLabel= new JLabel("Name");
    nameLabel.setBounds(45,15,50,16);
    nameLabel.setForeground(Color.WHITE);
    nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    employeepanel.add(nameLabel);
    ageLabel= new JLabel("Age");
    ageLabel.setBounds(140,15,50,17);
    ageLabel.setForeground(Color.WHITE);
    ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    employeepanel.add(ageLabel);
    salaryLabel= new JLabel("Salary");
    salaryLabel.setBounds(220,15,50,16);
    salaryLabel.setForeground(Color.WHITE);
    salaryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    employeepanel.add(salaryLabel);
    nidLabel= new JLabel("NID");
    nidLabel.setBounds(310,15,50,16);
    nidLabel.setForeground(Color.WHITE);
    nidLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    employeepanel.add(nidLabel);
    jobLabel= new JLabel("Job");
    jobLabel.setBounds(400,15,50,16);
    jobLabel.setForeground(Color.WHITE);
    jobLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    employeepanel.add(jobLabel);
    phoneLabel= new JLabel("Phone");
    phoneLabel.setBounds(490,15,50,16);
    phoneLabel.setForeground(Color.WHITE);
    phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    employeepanel.add(phoneLabel);
    emailLabel= new JLabel("Email");
    emailLabel.setBounds(570,15,50,16);
    emailLabel.setForeground(Color.WHITE);
    emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    employeepanel.add(emailLabel);
    genderLabel= new JLabel("Gender");
    genderLabel.setBounds(655,15,50,16);
    genderLabel.setForeground(Color.WHITE);
    genderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    employeepanel.add(genderLabel);

    //for customer info button
    cusinfo= new JButton("Customer Info");
    cusinfo.setBounds(30,200,200,30);
    cusinfo.setBackground(Color.BLACK);
    cusinfo.setForeground(Color.WHITE);
    this.add(cusinfo);
    cusinfo.addActionListener(this);
    customerpanel= new JPanel();//customerpanel
    customerpanel.setBounds(310,40,600,550);
    customerpanel.setBackground(new Color(3,45,48));
    customerpanel.setLayout(null);
    this.add(customerpanel);
    customerpanel.setVisible(false);
    customertable= new JTable();//customer table
    customertable.setBounds(20,50,560,350);
    customertable.setBackground(new Color(3,45,48));
    customertable.setForeground(Color.WHITE);
    customerpanel.add(customertable);
      try {
          customerfile=new FileReader("checkin.txt");
          customerreader= new BufferedReader(customerfile);
          String[] ccolumnsName = {"","","",""};
          customermodel = (DefaultTableModel)customertable.getModel();
          customermodel.setColumnIdentifiers(ccolumnsName);

          //get lines from txt file
          Object[] customertableLines =customerreader.lines().toArray();
          
          //extratct data from lines
          //set data to jtable model
          for(int i = 0; i < customertableLines.length; i++)
          {
              String line = customertableLines[i].toString().trim();
              String[] cdataRow = line.split(",");
              customermodel.addRow(cdataRow);
          }  
      } 
          catch (Exception ex) {
            System.out.println(ex);
      } 
    cnameLabel= new JLabel("Name");
    cnameLabel.setBounds(70,15,80,19);
    cnameLabel.setForeground(Color.WHITE);
    cnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    customerpanel.add(cnameLabel);
    croomLabel= new JLabel("Room No.");
    croomLabel.setBounds(200,15,80,19);
    croomLabel.setForeground(Color.WHITE);
    croomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    customerpanel.add(croomLabel);
    cpriceLabel= new JLabel("Price");
    cpriceLabel.setBounds(350,15,80,19);
    cpriceLabel.setForeground(Color.WHITE);
    cpriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    customerpanel.add(cpriceLabel);
    cbedtypeLabel= new JLabel("Bed Type");
    cbedtypeLabel.setBounds(480,15,80,19);
    cbedtypeLabel.setForeground(Color.WHITE);
    cbedtypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    customerpanel.add(cbedtypeLabel);

    //for search button
    searchroom= new JButton("Room Search");
    searchroom.setBounds(30,280,200,30);
    searchroom.setBackground(Color.BLACK);
    searchroom.setForeground(Color.WHITE);
    this.add(searchroom);
    searchroom.addActionListener(this);
    searchpanel= new JPanel();
    searchpanel.setBackground(new Color(3,45,48));
    searchpanel.setBounds(310,20,600,550);
    searchpanel.setLayout(null);
    this.add(searchpanel);
    searchLabel = new JLabel("Search For Room");
    searchLabel.setBounds(250,0,186,31);
    searchLabel.setForeground(Color.WHITE);
    searchLabel.setFont(new Font("Tahoma", Font.BOLD,20));
    searchpanel.add(searchLabel);
    sroomLabel= new JLabel("Room Bed Type:");
    sroomLabel.setBounds(50,60,150,20);
    sroomLabel.setForeground(Color.WHITE);
    sroomLabel.setFont(new Font("Tahoma", Font.BOLD,15));
    searchpanel.add(sroomLabel);
    sroomnoLabel= new JLabel("Room No.");
    sroomnoLabel.setBounds(80,120,150,20);
    sroomnoLabel.setForeground(Color.WHITE);
    sroomnoLabel.setFont(new Font("Tahoma", Font.BOLD,14));
    searchpanel.add(sroomnoLabel);
    spriceLabel= new JLabel("Price");
    spriceLabel.setBounds(280,120,150,20);
    spriceLabel.setForeground(Color.WHITE);
    spriceLabel.setFont(new Font("Tahoma", Font.BOLD,14));
    searchpanel.add(spriceLabel);
    sbedtypLabel= new JLabel("Bed Type");
    sbedtypLabel.setBounds(450,120,150,20);
    sbedtypLabel.setForeground(Color.WHITE);
    sbedtypLabel.setFont(new Font("Tahoma", Font.BOLD,14));
    searchpanel.add(sbedtypLabel);
    choice=new JComboBox(choices);
    choice.setBounds(200,60,156,24);
    choice.setFont(new Font("Tahoma", Font.PLAIN, 14));
    choice.setForeground(Color.WHITE);
    choice.setBackground(new Color(16,108,115));
    searchpanel.add(choice);
    sroomtable= new JTable();//search roomtable
    sroomtable.setBounds(20,160,560,300);
    sroomtable.setBackground(new Color(3,45,48));
    sroomtable.setForeground(Color.WHITE);
    searchpanel.add(sroomtable);
      try {
          sroomfile=new FileReader("addroom.txt");
          sroomreader= new BufferedReader(sroomfile);
          String[] srcolumnsName = {"","",""};
          sroommodel = (DefaultTableModel)sroomtable.getModel();
          sroommodel.setColumnIdentifiers(srcolumnsName);

          //get lines from txt file
          Object[] sroomtableLines =sroomreader.lines().toArray();
          
          //extratct data from lines
          //set data to jtable model
          for(int i = 0; i < sroomtableLines.length; i++)
          {
              String line = sroomtableLines[i].toString().trim();
              String[] srdataRow = line.split(",");
              sroommodel.addRow(srdataRow);
          }  
      } 
          catch (Exception ex) {
            System.out.println(ex);
      } 
    searchpanel.setVisible(false);

    //for logout button
    logout= new JButton("Logout");
    logout.setBounds(30,510,95,30);
    logout.setBackground(Color.BLACK);
    logout.setForeground(Color.WHITE);
    this.add(logout);
    logout.addActionListener(this);

    //for back button
    back = new JButton("Back");
    back.setBounds(135,510,95,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    this.add(back);
    back.addActionListener(this);

    //for roomdelete button
    roomdelete= new JButton("Delete");
    roomdelete.setBackground(Color.BLACK);
    roomdelete.setForeground(Color.WHITE);
    roomdelete.setBounds(400,470,95,30);
    roompanel.add(roomdelete);
    roomdelete.addActionListener(this);

    //for roomupdate button
    roomupdate= new JButton("Update");
    roomupdate.setBackground(Color.BLACK);
    roomupdate.setForeground(Color.WHITE);
    roomupdate.setBounds(130,470,95,30);
    roompanel.add(roomupdate);
    roomupdate.addActionListener(this);

    //for employeedelete button
    employeedelete= new JButton("Delete");
    employeedelete.setBackground(Color.BLACK);
    employeedelete.setForeground(Color.WHITE);
    employeedelete.setBounds(460,498,95,30);
    employeepanel.add(employeedelete);
    employeedelete.addActionListener(this);

    //for employeeupdate button
    employeeupdate= new JButton("Update");
    employeeupdate.setBackground(Color.BLACK);
    employeeupdate.setForeground(Color.WHITE);
    employeeupdate.setBounds(170,498,95,30);
    employeepanel.add(employeeupdate);
    employeeupdate.addActionListener(this);

    //for checkout button
    checkout= new JButton("Checkout");
    checkout.setBackground(Color.BLACK);
    checkout.setForeground(Color.WHITE);
    checkout.setBounds(270,470,95,30);
    customerpanel.add(checkout);
    checkout.addActionListener(this);

    //for ssearch button
    ssearch= new JButton("Search");
    ssearch.setBounds(200,490,95,30);
    ssearch.setBackground(Color.BLACK);
    ssearch.setForeground(Color.WHITE);
    searchpanel.add(ssearch);
    ssearch.addActionListener(this);

    //showing reception dashboard
    this.setVisible(true);

    }
      
    @Override
    public void actionPerformed(ActionEvent event){
      if(event.getSource()==room){
        roompanel.setVisible(true);
        employeepanel.setVisible(false);
        customerpanel.setVisible(false);
        searchpanel.setVisible(false);
      }
      else if(event.getSource()==alleminfo){
        employeepanel.setVisible(true);
        roompanel.setVisible(false);
        customerpanel.setVisible(false);
        searchpanel.setVisible(false);
      }
      else if(event.getSource()==cusinfo){
        customerpanel.setVisible(true);
        roompanel.setVisible(false);
        employeepanel.setVisible(false);
        searchpanel.setVisible(false);
      }
      else if(event.getSource()==searchroom){
        searchpanel.setVisible(true);
        customerpanel.setVisible(false);
        roompanel.setVisible(false);
        employeepanel.setVisible(false);
        // Clear the rows from sroommodel
        sroommodel.setRowCount(0);
    }
      else if(event.getSource()==logout){
        new UserLogin();
        this.setVisible(false);
      }
      //to delete rowdata
      else if (event.getSource()==roomdelete) {
        int selectedRow = roomtable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                roommodel.removeRow(selectedRow);
                // Update the file after deletion
                try {
                  FileWriter writer = new FileWriter("addroom.txt");
                  for (int i = 0; i < roommodel.getRowCount(); i++) {
                      StringBuilder row = new StringBuilder();
                      for (int j = 0; j < roommodel.getColumnCount(); j++) {
                          row.append(roommodel.getValueAt(i, j));
                          if (j < roommodel.getColumnCount() - 1) {
                              row.append(",");
                          }
                      }
                      writer.write(row.toString() + "\n");
                  }
                  writer.close();
              } catch (Exception ex) {
                  System.out.println(ex);
              }
                JOptionPane.showMessageDialog(this, "Information deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      else if (event.getSource()==roomupdate) {
        int selectedRow = roomtable.getSelectedRow();
        if (selectedRow != -1) {
            String updatedRoomNumber = JOptionPane.showInputDialog(null, "Enter updated room number:");
            String updatedPrice = JOptionPane.showInputDialog(null, "Enter updated price:");
            String updatedBedType = JOptionPane.showInputDialog(null, "Enter updated bed type:");
            roommodel.setValueAt(updatedRoomNumber, selectedRow, 0);
            roommodel.setValueAt(updatedPrice, selectedRow, 1);
            roommodel.setValueAt(updatedBedType, selectedRow, 2);
            try {
                FileWriter writer = new FileWriter("addroom.txt");
                for (int i = 0; i < roommodel.getRowCount(); i++) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < roommodel.getColumnCount(); j++) {
                        row.append(roommodel.getValueAt(i, j));
                        if (j < roommodel.getColumnCount() - 1) {
                            row.append(",");
                        }
                    }
                    writer.write(row.toString() + "\n");
                }
                writer.close();
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
            
            JOptionPane.showMessageDialog(this, "Information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
       else if (event.getSource() == employeedelete) {
        int selectedRow = employeetable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                employeemodel.removeRow(selectedRow);
                // Update the file after deletion
                try {
                  FileWriter writer = new FileWriter("addemployee.txt");
                  for (int i = 0; i < employeemodel.getRowCount(); i++) {
                      StringBuilder row = new StringBuilder();
                      for (int j = 0; j < employeemodel.getColumnCount(); j++) {
                          row.append(employeemodel.getValueAt(i, j));
                          if (j < employeemodel.getColumnCount() - 1) {
                              row.append(",");
                          }
                      }
                      writer.write(row.toString() + "\n");
                  }
                  writer.close();
              } 
                catch (Exception ex) {
                  System.out.println(ex);
              }
                JOptionPane.showMessageDialog(this, "Information deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      else if (event.getSource() == employeeupdate) {
        int selectedRow = employeetable.getSelectedRow();
        if (selectedRow != -1) {
            String updatedname = JOptionPane.showInputDialog( "Enter updated name:");
            String updatedage = JOptionPane.showInputDialog( "Enter updated age:");
            String updatedsalary = JOptionPane.showInputDialog( "Enter updated salary:");
            String updatednid= JOptionPane.showInputDialog( "Enter updated nid:");
            String updatedjob = JOptionPane.showInputDialog( "Enter updated job:");
            String updatedmobile = JOptionPane.showInputDialog("Enter updated mobile:");
            String updatedemail = JOptionPane.showInputDialog( "Enter updated email:");
            String updatedgender = JOptionPane.showInputDialog("Enter updated gender:");
            employeemodel.setValueAt(updatedname, selectedRow, 0);
            employeemodel.setValueAt(updatedage, selectedRow, 1);
            employeemodel.setValueAt(updatedsalary, selectedRow, 2);
            employeemodel.setValueAt(updatednid, selectedRow, 3);
            employeemodel.setValueAt(updatedjob, selectedRow, 4);
            employeemodel.setValueAt(updatedmobile, selectedRow, 5);
            employeemodel.setValueAt(updatedemail, selectedRow, 6);
            employeemodel.setValueAt(updatedgender, selectedRow, 7);
            try {
                FileWriter writer = new FileWriter("addemployee.txt");
                for (int i = 0; i < employeemodel.getRowCount(); i++) {
                    StringBuilder erow = new StringBuilder();
                    for (int j = 0; j < employeemodel.getColumnCount(); j++) {
                        erow.append(employeemodel.getValueAt(i, j));
                        if (j < employeemodel.getColumnCount() - 1) {
                            erow.append(",");
                        }
                    }
                    writer.write(erow.toString() + "\n");
                }
                writer.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            JOptionPane.showMessageDialog(this, "Information updated successfully.", "Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
          }

    //to checkout customer
      else if (event.getSource() == checkout) {
        int selectedRow = customertable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure that this customer wants to checkout?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                customermodel.removeRow(selectedRow);
                // Update the file after deletion
                try {
                  FileWriter writer = new FileWriter("checkin.txt");
                  for (int i = 0; i < customermodel.getRowCount(); i++) {
                      StringBuilder row = new StringBuilder();
                      for (int j = 0; j < customermodel.getColumnCount(); j++) {
                          row.append(customermodel.getValueAt(i, j));
                          if (j < customermodel.getColumnCount() - 1) {
                              row.append(",");
                          }
                      }
                      writer.write(row.toString() + "\n");
                  }
                  writer.close();
              } catch (Exception ex) {
                  System.out.println(ex);
              }
                JOptionPane.showMessageDialog(this, "Customer checked out successfully.", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "Please select a customer to complete checkout operaation.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    else if(event.getSource()==ssearch){
        String selectedBedType=(String)choice.getSelectedItem();

        sroommodel.setRowCount(0);
        //new table for filtered search
        for (int i = 0; i < roommodel.getRowCount(); i++) {
            sbedtype=(String)roommodel.getValueAt(i, 2);
            if (selectedBedType.equals(sbedtype)) {
                sroomno=(String) roommodel.getValueAt(i, 0);
                sprice=(String) roommodel.getValueAt(i, 1);
                sroommodel.addRow(new String[]{sroomno, sprice, sbedtype});
            }
      }
    }
 
    else if(event.getSource()==back){
      new AdministrationDashboard();
      this.setVisible(false);
    }
 }
      
    public static void main(String[] args) {
        new ReceptionDashboard();
    }
}