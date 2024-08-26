
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem()
    {
        setSize(1200,600);
        setLocation(50,50);
        setLayout(null);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        
        JLabel img=new JLabel(i1);
        img.setBounds(0,0,1200,600);
        add(img);
         
        JLabel txt=new JLabel("HOTEL SWARAJ");
        txt.setBounds(20,430,750,70);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("serif",Font.PLAIN,60) );
        img.add(txt);
        
        JButton b=new JButton("Next");
        b.setBounds(1000, 450, 100, 45);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);
        b.addActionListener(this);
        b.setFont(new Font("serif",Font.PLAIN,18) );
        img.add(b);
        
        setVisible(true);
        
        
        //deeper functionality
        while(true)
        {
            txt.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            txt.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
                    {
                        e.printStackTrace();
                    }
        }
    }
    
    
    public static void main(String[] args) {
       new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
        new Login();
    }

    
     
    
}
