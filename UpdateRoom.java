
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener{
    Choice cust;
    TextField rm,avail1,cstatus;
    JButton update,back,check;
    UpdateRoom()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(190,60,900,480);   
        setLayout(null);
        
        
         JLabel l1=new JLabel("UPDATE ROOM STATUS");
        l1.setBounds(80,5,300,30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        
        
         JLabel id=new JLabel("Customer Id");
        id.setBounds(40,50,100,30);
        id.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(id);
        
        cust=new Choice();
        cust.setBounds(250,50,180,30);
        add(cust);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Customer");
          while(rs.next())
          {
              cust.add(rs.getString("Number"));
          }
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
         JLabel room=new JLabel("Room No");
        room.setBounds(40,100,100,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        rm=new TextField();
        rm.setBounds(250,100,180,30);
        add(rm);
        
        JLabel avail=new JLabel("Availability");
        avail.setBounds(40,150,100,20);
        avail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(avail);
        
        avail1=new TextField();
        avail1.setBounds(250,150,180,30);
        add(avail1);
        
        JLabel chk=new JLabel("Cleaning Status");
        chk.setBounds(40,200,150,20);
        chk.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(chk);
        
        cstatus=new TextField();
        cstatus.setBounds(250,200,180,30);
        add(cstatus);
        
        
        check=new JButton("Check");
        check.setBounds(40,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBounds(160,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(280,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,  440,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(450,10,450,440);
        add(img);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new UpdateRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check)
        {
            String id=cust.getSelectedItem();
            String query="select * from Customer where Number='"+id+"'";
            try
            {
               DbConnection c=new DbConnection();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    rm.setText(rs.getString("Room_Allocated"));    
                }
                ResultSet rs2=c.s.executeQuery("select * from Room where Room_No= '"+rm.getText()+"'");
              while(rs2.next())
                {
                   String availability=rs2.getString("Available");
                   String cleanStatus=rs2.getString("Clean_Status");
                   avail1.setText(availability);
                   cstatus.setText(cleanStatus);
                }
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==update)
        {
           String number=cust.getSelectedItem();
          String avail=avail1.getText();
            String room=rm.getText();
            String status=cstatus.getText();
                    
            try{
                DbConnection conn=new DbConnection();
           
         conn.s.executeUpdate("Update Room set Available='"+avail+"',Clean_Status='"+status+"' where Room_No='"+room+"'");
            JOptionPane.showMessageDialog(null, "Data updated succesfully!!!");
            setVisible(false);
            new Reception();
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
            new Reception();
        }
    }
}
