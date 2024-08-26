

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;
public class PickUpService extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice car;
    
    PickUpService()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,850,580);   
        setLayout(null);
        
        JLabel l1=new JLabel("PICKUP SERVICE");
        l1.setBounds(350,5,300,30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(l1);
        
        JLabel l2=new JLabel("Type of Car");
        l2.setBounds(10,60,100,30);
        add(l2);
        
        
        car=new Choice();
        try{
            DbConnection c=new DbConnection();
            String query ="select *from Driver";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                car.add(rs.getString("Car_Company"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        car.setBackground(Color.WHITE);
        car.setBounds(130, 70, 100, 20);
        add(car);
        
        
        
        JLabel ll1=new JLabel("Name");
        ll1.setBounds(10,130,90,20);
         ll1.setBackground(Color.LIGHT_GRAY);
      ll1.setOpaque(true);
        add(ll1);
        
        JLabel ll2=new JLabel("Age   ");
        ll2.setBounds(100,130,90,20);
        ll2.setBackground(Color.LIGHT_GRAY);
      ll2.setOpaque(true);
        add(ll2);
        
         JLabel l3=new JLabel("Gender");
        l3.setBounds(190,130,90,20);
        l3.setBackground(Color.LIGHT_GRAY);
      l3.setOpaque(true);
        add(l3);
        
         JLabel l4=new JLabel(" Mobile  ");
        l4.setBounds(280,130,90,20);
        l4.setBackground(Color.LIGHT_GRAY);
      l4.setOpaque(true);
        add(l4);
        
        JLabel l5=new JLabel("Brand");
        l5.setBounds(370,130,90,20);
        l5.setBackground(Color.LIGHT_GRAY);
      l5.setOpaque(true);
        add(l5);
        
        JLabel l6=new JLabel("Model");
        l6.setBounds(460,130,80,20);
        l6.setBackground(Color.LIGHT_GRAY);
      l6.setOpaque(true);
        add(l6);
        
        JLabel l7=new JLabel("Available");
        l7.setBounds(540,130,80,20);
        l7.setBackground(Color.LIGHT_GRAY);
      l7.setOpaque(true);
        add(l7);
        
        JLabel l8=new JLabel("Location");
        l8.setBounds(620,130,90,20);
        l8.setBackground(Color.LIGHT_GRAY);
      l8.setOpaque(true);
        add(l8);
        
        table=new JTable();
        table.setBounds(10,150,700,300);
        add(table);
        /*
        try{
            DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Driver");
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        */
        back=new JButton("Back");
        back.setBounds(40,480,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        submit=new JButton("Submit");
        submit.setBounds(160,480,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        setVisible (true);
        
    }
            
            public static void main(String[] args)
            {
                new PickUpService();
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            try
            {
                String carbrand=(String)car.getSelectedItem();
                String query="select * from Driver where Car_Company='"+carbrand+"' ";
                
                DbConnection c=new DbConnection();
                ResultSet rs;
               
                rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }
}
