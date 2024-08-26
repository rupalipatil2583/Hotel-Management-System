
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
 import java.awt.event.*;
public class DashBoard extends JFrame implements ActionListener{
    
    DashBoard()
    {
        setBounds(50,20,1200,600);   //for frame
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first2.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,  600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1200,600);
        add(img);
        
        JLabel text=new JLabel("SWARAJ GROUP WELCOMES YOU");
        text.setBounds(290,40,700,40);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        img.add(text);
        
        
        //menu
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1200,20);
        img.add(mb);
        
        JMenu hotel=new JMenu("Hotel");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception=new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.GREEN);
        mb.add(admin);
        
        JMenuItem addEmp=new JMenuItem("+New Employee");
        addEmp.addActionListener(this);
        admin.add(addEmp);
        
        JMenuItem addrooms=new JMenuItem("+Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem add_drivers=new JMenuItem("+Drivers");
        add_drivers.addActionListener(this);
        admin.add(add_drivers);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
       new DashBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("+New Employee"))
        {
            new AddEmployee();
        }
        else if(e.getActionCommand().equals("+Rooms"))
        {
            new AddRooms();
        }
        else if(e.getActionCommand().equals("+Drivers"))
        {
            new AddDriver();
        }
        else if(e.getActionCommand().equals("Reception"))
        {
            new Reception();
        }
    }
}
