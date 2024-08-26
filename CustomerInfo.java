
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,980,580);   
        setLayout(null);
        
        JLabel t1=new JLabel("CUSTOMER RECORDS");
        t1.setFont(new Font("Tahoma",Font.BOLD,25));
        t1.setHorizontalTextPosition(JLabel.CENTER);
        t1.setBounds(320,10,300,20);
        add(t1);
        
        JLabel l1=new JLabel("Id");
        l1.setBounds(10,40,100,20);
         l1.setBackground(Color.LIGHT_GRAY);
       l1.setOpaque(true);
        add(l1);
        
        JLabel l2=new JLabel("Number");
        l2.setBounds(110,40,100,20);
        l2.setBackground(Color.LIGHT_GRAY);
        l2.setOpaque(true);
        add(l2);
        
         JLabel l3=new JLabel("Name");
        l3.setBounds(210,40,100,20);
        l3.setBackground(Color.LIGHT_GRAY);
      l3.setOpaque(true);
        add(l3);
        
         JLabel l4=new JLabel("Gender");
        l4.setBounds(310,40,100,20);
        l4.setBackground(Color.LIGHT_GRAY);
      l4.setOpaque(true);
        add(l4);
        
        JLabel l5=new JLabel("Mobile");
        l5.setBounds(410,40,100,20);
        l5.setBackground(Color.LIGHT_GRAY);
      l5.setOpaque(true);
        add(l5);
        
        JLabel l6=new JLabel("Address");
        l6.setBounds(510,40,100,20);
        l6.setBackground(Color.LIGHT_GRAY);
      l6.setOpaque(true);
        add(l6);
        
        JLabel l7=new JLabel("Room_Allocated");
        l7.setBounds(610,40,110,20);
        l7.setBackground(Color.LIGHT_GRAY);
      l7.setOpaque(true);
        add(l7);
        
        JLabel l8=new JLabel("CheckInTime");
        l8.setBounds(720,40,100,20);
        l8.setBackground(Color.LIGHT_GRAY);
      l8.setOpaque(true);
        add(l8);
        
        JLabel l9=new JLabel("Deposit");
        l9.setBounds(820,40,100,20);
        l9.setBackground(Color.LIGHT_GRAY);
      l9.setOpaque(true);
        add(l9);
        
        table=new JTable();
        table.setBounds(10,70,900,400);
        add(table);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Customer");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(40,480,70,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        setVisible (true);
    }
    
    public static void main(String[] args)
    {
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Reception();
    }
}
