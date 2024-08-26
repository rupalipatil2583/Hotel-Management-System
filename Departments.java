
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;
public class Departments extends JFrame implements ActionListener{
    JTable table; 
    JButton back;
    Departments()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,1000,580);   
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/departments.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,  500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(450,0,500,500);
        add(img);
        
        JLabel l1=new JLabel("Department   ");
        l1.setBounds(10,10,250,20);
         l1.setBackground(Color.LIGHT_GRAY);
      l1.setOpaque(true);
        add(l1);
        
        JLabel l2=new JLabel("Budget   ");
        l2.setBounds(260,10,200,20);
        l2.setBackground(Color.LIGHT_GRAY);
      l2.setOpaque(true);
        add(l2);
        
        table=new JTable();
        table.setBounds(10,30,500,400);
        add(table);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Department");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(40,450,70,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Departments();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
