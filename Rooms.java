
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;
public class Rooms extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Rooms()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,1000,580);   
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,  540,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(450,0,600,540);
        add(img);
        
        JLabel l1=new JLabel("Room No     ");
        l1.setBounds(10,10,100,20);
         l1.setBackground(Color.LIGHT_GRAY);
      l1.setOpaque(true);
        add(l1);
        
        JLabel l2=new JLabel("Availability   ");
        l2.setBounds(110,10,100,20);
        l2.setBackground(Color.LIGHT_GRAY);
      l2.setOpaque(true);
        add(l2);
        
         JLabel l3=new JLabel("CleanStatus");
        l3.setBounds(210,10,100,20);
        l3.setBackground(Color.LIGHT_GRAY);
      l3.setOpaque(true);
        add(l3);
        
         JLabel l4=new JLabel(" Bed-Type  ");
        l4.setBounds(310,10,100,20);
        l4.setBackground(Color.LIGHT_GRAY);
      l4.setOpaque(true);
        add(l4);
        
        JLabel l5=new JLabel("Price");
        l5.setBounds(410,10,100,20);
        l5.setBackground(Color.LIGHT_GRAY);
      l5.setOpaque(true);
        add(l5);
        
        table=new JTable();
        table.setBounds(10,30,500,400);
        add(table);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Room");
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
        setVisible (true);
        
    }
            
            public static void main(String[] args)
            {
                new Rooms();
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
