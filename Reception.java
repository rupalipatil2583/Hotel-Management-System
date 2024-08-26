
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    Reception()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,20,900,600);   
        setLayout(null);
        
        b1=new JButton("New Customer Forms");
        b1.setBounds(80, 30, 200, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Rooms");
        b2.setBounds(80, 70, 200, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Deaprtments");
        b3.setBounds(80, 110, 200, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
         b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("All Employees");
        b4.setBounds(80, 150, 200, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
         b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("Customer_Info");
        b5.setBounds(80, 190, 200, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
         b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("ManagerInfo");
        b6.setBounds(80, 230, 200, 30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
         b6.addActionListener(this);
        add(b6);
        
        b7=new JButton("CheckOut");
        b7.setBounds(80, 270, 200, 30);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
         b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("Update Room Status");
        b8.setBounds(80, 310, 200, 30);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
         b8.addActionListener(this);
        add(b8);
        
        b9=new JButton("Pickup Service");
        b9.setBounds(80, 350, 200, 30);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
         b9.addActionListener(this);
        add(b9);
        
        b10=new JButton("Search Room");
        b10.setBounds(80, 390, 200, 30);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
         b10.addActionListener(this);
        add(b10);
        
        b11=new JButton("Logout");
        b11.setBounds(80, 430, 200, 30);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
         b11.addActionListener(this);
        add(b11);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        Image i2=i1.getImage().getScaledInstance(590,  560,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(300,10,590,560);
        add(img);
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            setVisible(false);
            new AddCustomer();
            
        }
       else if(e.getSource()==b2)
        {
            setVisible(false);
            new Rooms();
            
        }
        else if(e.getSource()==b3)
        {
            setVisible(false);
            new Departments();
            
        }
        else if(e.getSource()==b4)
        {
            setVisible(false);
            new Employees();
            
        }
        else if(e.getSource()==b5)
        {
            setVisible(false);
            new CustomerInfo();
            
        }
         else if(e.getSource()==b6)
        {
            setVisible(false);
            new ManagerInfo();
            
        }
        else if(e.getSource()==b10)
        {
            setVisible(false);
            new SearchRooms();
            
        }
        else if(e.getSource()==b7)
        {
            setVisible(false);
            new UpdateCheck();
            
        }
        else if(e.getSource()==b8)
        {
            setVisible(false);
            new UpdateRoom();
            
        }
         else if(e.getSource()==b9)
        {
            setVisible(false);
            new PickUpService();
            
        }
    }
}
