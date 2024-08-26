
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice cust;
    TextField rm,nm1,checkin,paid,A_pending;
    JButton update,back,check;
    UpdateCheck()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,40,900,480);   
        setLayout(null);
        
        
        JLabel l1=new JLabel("UPDATE CHECK");
        l1.setBounds(350,5,300,30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        
        
         JLabel id=new JLabel("Customer Id");
        id.setBounds(40,40,100,30);
        id.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(id);
        
        cust=new Choice();
        cust.setBounds(200,40,180,30);
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
        room.setBounds(40,90,100,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        rm=new TextField();
        rm.setBounds(200,90,180,30);
        add(rm);
        
        JLabel nm=new JLabel("Name");
        nm.setBounds(40,140,100,20);
        nm.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(nm);
        
        nm1=new TextField();
        nm1.setBounds(200,140,180,30);
        add(nm1);
        
        JLabel chk=new JLabel("CheckinTime");
        chk.setBounds(40,180,100,20);
        chk.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(chk);
        
        checkin=new TextField();
        checkin.setBounds(200,180,180,30);
        add(checkin);
        
        JLabel amt=new JLabel("Amount Paid");
        amt.setBounds(40,220,100,20);
        amt.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(amt);
        
        paid=new TextField();
        paid.setBounds(200,220,180,30);
        add(paid);
        
        JLabel pending=new JLabel("Pending Amount");
        pending.setBounds(40,260,150,20);
        pending.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(pending);
        
        A_pending=new TextField();
        A_pending.setBounds(200,260,180,30);
        add(A_pending);
        
        
        
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
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/check.png"));
        Image i2=i1.getImage().getScaledInstance(300,  300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(450,50,300,300);
        add(img);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new UpdateCheck();
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
                    nm1.setText(rs.getString("Name"));
                    checkin.setText(rs.getString("CheckInTime"));
                    paid.setText(rs.getString("Deposit"));
                }
              ResultSet rs2=c.s.executeQuery("select * from Room where Room_No= '"+rm.getText()+"'");
              while(rs2.next())
                {
                   String price=rs2.getString("Price");
                   int pending=Integer.parseInt(price)-Integer.parseInt(paid.getText());
                   
                    A_pending.setText(""+pending);
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
            String name=nm1.getText();
            String room=rm.getText();
            String amt=paid.getText();
            String checkin1=checkin.getText();
            try{
                 DbConnection conn=new DbConnection();
           
         conn.s.executeUpdate("Update Customer set Room_Allocated='"+room+"',Name='"+name+"',Deposit='"+amt+"',CheckInTime='"+checkin1+"' where Number='"+number+"'");
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
