
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox ids,gender;
    JTextField no,name,mobile,address1,depo;
    Choice croom;
    JLabel checkInTime;
    JButton add,back;
    AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,950,600);   
        setLayout(null);
        
        JLabel l1=new JLabel("New Customer Form");
        l1.setBounds(120,20,250,30);
        l1.setFont(new Font("Relway",Font.BOLD,20));
        add(l1);
        
        JLabel id=new JLabel("ID");
        id.setBounds(80,60,150,30);
        id.setFont(new Font("Relway",Font.PLAIN,17));
        add(id);
        
        String id1[]={"AdharCard","PanCard","Voter Id Card","Driving License"};
        ids=new JComboBox(id1);
        ids.setBounds(250,60,200,30);
        ids.setBackground(Color.WHITE);
        add(ids);
        
        JLabel number=new JLabel("Number");
        number.setBounds(80,110,150,30);
        number.setFont(new Font("Relway",Font.PLAIN,17));
        add(number);
        
        no=new JTextField();
        no.setBounds(250,110,200,30);
        add(no);
        
        JLabel nm=new JLabel("Name");
        nm.setBounds(80,160,150,30);
        nm.setFont(new Font("Relway",Font.PLAIN,17));
        add(nm);
        
        name=new JTextField();
        name.setBounds(250,160,200,30);
        add(name);
        
        JLabel gen=new JLabel("Gender");
        gen.setBounds(80,210,150,30);
        gen.setFont(new Font("Relway",Font.PLAIN,17));
        add(gen);
        
       String gender1[]={"Male","Female"};
        gender=new JComboBox(gender1);
        gender.setBounds(250, 210, 200, 30);
        gender.setBackground(Color.white);
        add(gender);
        
        JLabel mob=new JLabel("Mobile No.");
        mob.setBounds(80,260,150,30);
        mob.setFont(new Font("Relway",Font.PLAIN,17));
        add(mob);
        
        mobile=new JTextField();
        mobile.setBounds(250,260,200,30);
        add(mobile);
        
        JLabel address=new JLabel("Address");
        address.setBounds(80,310,150,30);
        address.setFont(new Font("Relway",Font.PLAIN,17));
        add(address);
        
        address1=new JTextField();
        address1.setBounds(250,310,200,30);
        add(address1);
        
        JLabel allocRoom=new JLabel("Allocated Room");
        allocRoom.setBounds(80,360,150,30);
        allocRoom.setFont(new Font("Relway",Font.PLAIN,17));
        add(allocRoom);
        
        croom =new Choice();
        
        try{
            DbConnection conn=new DbConnection();
            
            String query="select * from Room where Available='Available'";
            
            ResultSet rs;
            rs = conn.s.executeQuery(query);
            while(rs.next())
            {
                croom.add(rs.getString("Room_No"));
            }
              
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        croom.setBounds(250,360,200,30);
        add(croom);
        
        JLabel time=new JLabel("Check In Time");
        time.setBounds(80,410,150,30);
        time.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(time);
        
        Date date=new Date();
        checkInTime=new JLabel(""+date);
        checkInTime.setBounds(250,410,200,30);
        add(checkInTime);
        
   
        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(80,460,150,30);
        deposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(deposit);
        
        depo=new JTextField();
        depo.setBounds(250,460,200,30);
        add(depo);
                
        add=new JButton("Add");
        add.setBounds(80,510,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(200,510,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/customer.jfif"));
        Image i2=i1.getImage().getScaledInstance(500,  400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,50,350,300);
        add(img);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id,num,nm,gen,mob,address,room,ctime,deposit;
        
        id=(String)ids.getSelectedItem();
        num=no.getText();
        nm=name.getText();
        gen=(String)gender.getSelectedItem();
        mob=mobile.getText();
        address=address1.getText();
        room=croom.getSelectedItem();
        ctime=checkInTime.getText();
        deposit=depo.getText();
        
        
        
       
            if(e.getSource()==add)
            {
                if (num.isEmpty() || nm.isEmpty() || mob.isEmpty() || address.isEmpty() || deposit.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                }
                else
                {
                     try{
                    DbConnection c=new DbConnection();
            
            String query="insert into Customer values ('"+id+"','"+num+"','"+nm+"','"+gen+"','"+mob+"','"+address+"','"+room+"','"+ctime+"','"+deposit+"')";
            String query2="update Room set Available= 'Occupied' where Room_No='"+room+"'";
             c.s.executeUpdate(query);
             c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Customer Added SuccessFully");
           
           setVisible(false);
                new Reception();    
                    
                }
                catch(Exception ae)
                {
                    ae.printStackTrace();
                }
                }
               
            }
            else if(e.getSource()==back)
            {
                
                new Reception();
                setVisible(false);
            }
       
       
    }
}
