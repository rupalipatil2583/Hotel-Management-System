
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;

public class Employees extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Employees()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,950,580);   
        setLayout(null);
        
        JLabel t1=new JLabel("EMPLOYEE RECORDS");
        t1.setFont(new Font("Tahoma",Font.BOLD,25));
        t1.setHorizontalTextPosition(JLabel.CENTER);
        t1.setBounds(320,10,300,20);
        add(t1);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(10,40,110,20);
         l1.setBackground(Color.LIGHT_GRAY);
       l1.setOpaque(true);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(120,40,110,20);
        l2.setBackground(Color.LIGHT_GRAY);
        l2.setOpaque(true);
        add(l2);
        
         JLabel l3=new JLabel("Gender");
        l3.setBounds(230,40,110,20);
        l3.setBackground(Color.LIGHT_GRAY);
      l3.setOpaque(true);
        add(l3);
        
         JLabel l4=new JLabel("Job");
        l4.setBounds(340,40,110,20);
        l4.setBackground(Color.LIGHT_GRAY);
      l4.setOpaque(true);
        add(l4);
        
        JLabel l5=new JLabel("Phone");
        l5.setBounds(450,40,110,20);
        l5.setBackground(Color.LIGHT_GRAY);
      l5.setOpaque(true);
        add(l5);
        
        JLabel l6=new JLabel("Email");
        l6.setBounds(560,40,110,20);
        l6.setBackground(Color.LIGHT_GRAY);
      l6.setOpaque(true);
        add(l6);
        
        JLabel l7=new JLabel("Salary");
        l7.setBounds(670,40,110,20);
        l7.setBackground(Color.LIGHT_GRAY);
      l7.setOpaque(true);
        add(l7);
        
        JLabel l8=new JLabel("Address");
        l8.setBounds(780,40,140,20);
        l8.setBackground(Color.LIGHT_GRAY);
      l8.setOpaque(true);
        add(l8);
        
        table=new JTable();
        table.setBounds(10,70,900,400);
        add(table);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Employee");
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
        new Employees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Reception();
    }
}
