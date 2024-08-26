

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;    //used for fetching data in table  (library rs2xml.jar used)
import java.sql.*;
public class SearchRooms extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox c;
    JCheckBox ch;
    SearchRooms()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,700,580);   
        setLayout(null);
        
        JLabel l1=new JLabel("SEARCH ROOM");
        l1.setBounds(280,20,270,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        l1.setForeground(Color.RED);
        add(l1);
        
        JLabel l2=new JLabel("Bed Type");
        l2.setBounds(10,60,100,30);
        add(l2);
        
        String beds[]={"Single","Double"};
        c=new JComboBox(beds);
        c.setBackground(Color.WHITE);
        c.setBounds(130, 60, 150, 30);
        add(c);
        
         ch=new JCheckBox("Display Available Only");
         ch.setBackground(Color.WHITE);
         ch.setBounds(10,110,200,20);
         add(ch);
         
         
        
        
        JLabel ll1=new JLabel("Room No");
        ll1.setBounds(10,150,100,20);
         ll1.setBackground(Color.LIGHT_GRAY);
      ll1.setOpaque(true);
        add(ll1);
        
        JLabel ll2=new JLabel("Availability   ");
        ll2.setBounds(110,150,100,20);
        ll2.setBackground(Color.LIGHT_GRAY);
      ll2.setOpaque(true);
        add(ll2);
        
         JLabel l3=new JLabel("CleanStatus");
        l3.setBounds(210,150,100,20);
        l3.setBackground(Color.LIGHT_GRAY);
      l3.setOpaque(true);
        add(l3);
        
         JLabel l4=new JLabel(" Bed-Type  ");
        l4.setBounds(310,150,100,20);
        l4.setBackground(Color.LIGHT_GRAY);
      l4.setOpaque(true);
        add(l4);
        
        JLabel l5=new JLabel("Price");
        l5.setBounds(410,150,100,20);
        l5.setBackground(Color.LIGHT_GRAY);
      l5.setOpaque(true);
        add(l5);
        
        table=new JTable();
        table.setBounds(10,170,500,300);
        add(table);
        
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
                new SearchRooms();
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            try
            {
                String bed=(String)c.getSelectedItem();
                String query="select * from Room where Bed_Type='"+bed+"' ";
                String query1="select * from Room where Available='Available' AND Bed_Type='"+bed+"' ";
                
                DbConnection c=new DbConnection();
                ResultSet rs;
                if(ch.isSelected())
                {
                    rs=c.s.executeQuery(query1);
                    
                }
                else
                {
                    rs=c.s.executeQuery(query);
                    
                }
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
