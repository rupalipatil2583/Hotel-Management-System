
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener{
    Choice cust;
    JLabel roomNo,checkin,checkout;
    JButton back,checkout1;

   /* public CheckOut(Choice cust, JButton back) throws HeadlessException {
        this.cust = cust;
        this.back = back;
    }*/
    CheckOut()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,70,950,450);   
        setLayout(null);
        
        JLabel l1=new JLabel("CHECKOUT");
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setBounds(70,20,200,30);
        l1.setForeground(Color.RED);
        add(l1);
        
        JLabel id=new JLabel("Customer Id");
        id.setBounds(40,70,100,30);
        id.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(id);
        
        cust=new Choice();
        cust.setBounds(250,70,180,30);
        add(cust);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,  20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(450,70,20,20);
        add(img);
        
        
         JLabel room=new JLabel("Room No");
        room.setBounds(40,110,100,30);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        roomNo=new JLabel();
        roomNo.setBounds(250,110,100,20);
        roomNo.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(roomNo);
        
        JLabel chk=new JLabel("CheckinTime");
        chk.setBounds(40,160,100,30);
        chk.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(chk);
        
       checkin=new JLabel();
        checkin.setBounds(250,160,180,30);
        add(checkin);
        
        JLabel chkout=new JLabel("CheckoutTime");
        chkout.setBounds(40,210,120,20);
        chkout.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(chkout);
        
         java.util.Date date=new java.util.Date();
       checkout=new JLabel(""+date);
        checkout.setBounds(250,210,180,30);
        add(checkout);
        
        back=new JButton("Back");
        back.setBounds(40,260,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        checkout1=new JButton("CheckOut");
        checkout1.setBounds(200,260,100,30);
        checkout1.setBackground(Color.BLACK);
        checkout1.setForeground(Color.WHITE);
        checkout1.addActionListener(this);
        add(checkout1);
       
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jfif"));
        Image i22=i11.getImage().getScaledInstance(400,  270,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel img1=new JLabel(i33);
        img1.setBounds(480,70,400,270);
        add(img1);
        
        try{
           DbConnection conn=new DbConnection();
           
           ResultSet rs=conn.s.executeQuery("select * from Customer");
          while(rs.next())
          {
              cust.add(rs.getString("Number"));
              roomNo.setText(rs.getString("Room_Allocated"));
              checkin.setText(rs.getString("CheckInTime"));
          }
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        setVisible(true);
       
    }
    
    public static void main(String args[])
    {
        new CheckOut();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==checkout1)
                {
                    String num=cust.getSelectedItem();
                    String query="delete from Customer where Number='"+num+"'";
                   String query2="update Room set Available='Available' where Room_No='"+roomNo.getText()+"'";
                   try{
                       DbConnection conn=new DbConnection();
                    conn.s.executeUpdate(query);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Checkout Done.");
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
