
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener  {
    JTextField rn,prices;
    JComboBox cb,cb2,cb3;
    JButton add,cancel,back;
    AddRooms()
    {
         getContentPane().setBackground(Color.WHITE);
        setBounds(200,20,900,480);   
        setLayout(null);
        
        JLabel l1=new JLabel("Add New Room");
        l1.setBounds(80,30,200,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l1);
        
        JLabel rno=new JLabel("Room No");
        rno.setBounds(80,80,180,30);
        rno.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rno);
        
        rn=new JTextField();
        rn.setBounds(280,80,200,30);
        add(rn);
        
        JLabel l2=new JLabel("Available");
        l2.setBounds(80,130,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l2);
        
        String availableOption[]={"Available","Occupied"};
        cb=new JComboBox(availableOption);
        cb.setBounds(280, 130, 200, 30);
        cb.setBackground(Color.white);
        add(cb);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(80,180,180,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l3);
        
        String cleanOption[]={"Cleaned","Dirty"};
        cb2=new JComboBox(cleanOption);
        cb2.setBounds(280,180,200,30);
        cb2.setBackground(Color.white);
        add(cb2);
        
        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(80,230,180,30);
        bed.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(bed);
        
        String bedtype[]={"Single","Double"};
        cb3=new JComboBox(bedtype);
        cb3.setBounds(280,230,200,30);
        cb3.setBackground(Color.white);
        add(cb3);
        
        JLabel price=new JLabel("Price");
        price.setBounds(80,280,180,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(price);
        
        prices=new JTextField();
        prices.setBounds(280,280,200,30);
        add(prices);
        
        add=new JButton("Add Room");
        add.setBounds(80,330,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(200,330,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
         back=new JButton("Back");
        back.setBounds(320,330,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2=i1.getImage().getScaledInstance(390,  450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,0,390,450);
        add(img);
        
        setVisible(true);
        
        
    }
    
    public static void main(String[] args)
    {
        new AddRooms();
    }

    @Override
  
public void actionPerformed(ActionEvent e) {
    String rno, available, clean_status, bed, price;
    rno = rn.getText();
    available = (String) cb.getSelectedItem();
    clean_status = (String) cb2.getSelectedItem();
    bed = (String) cb3.getSelectedItem();
    price = prices.getText();

    if (e.getSource() == add) {
        if (rno.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Room number and price cannot be empty");
            return;
        }

        int rn1;
        int price1;
        try {
            rn1 = Integer.parseInt(rno);
            price1 = Integer.parseInt(price);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for room number and price");
            return;
        }

        try {
            DbConnection c = new DbConnection();
            String query = "insert into Room values ('" + rn1 + "','" + available + "','" + clean_status + "','" + bed + "','" + price1 + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Room Added Successfully");
            setVisible(false);  // Hides the frame after adding a room
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    } else if (e.getSource() == cancel) {
        // Clear all fields instead of hiding the frame
        rn.setText("");
        prices.setText("");
        cb.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        cb3.setSelectedIndex(0);
    }
    else
    {
         setVisible(false);
            new DashBoard();
    }
}

}
