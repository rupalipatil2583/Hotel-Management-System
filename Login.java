
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
     JTextField un;
     JPasswordField ps;
     JButton login,cancel;
    Login()
    {
        setBounds(370,200,600,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user=new JLabel("Username");
        user.setBounds(40, 25, 100, 40);
        add(user);
        un=new JTextField();
        un.setBounds(160,30,200,30);
        add(un);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40, 80, 100, 40);
        ps=new JPasswordField();
        ps.setBounds(160,90,200,30);
        add(pass);
        add(ps);
        
        login=new JButton("Login");
        login.setBounds(40,140,70,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(130,140,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(360,10,200,200);
        
        add(img);
        
        
        setVisible(true);
    }
    
    
    public static void main(String args[])
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            String user=un.getText();
            String pass=ps.getText();
            try
            {
                DbConnection c=new DbConnection();
                String query="select *from login where username= '"+user+"' and password= '"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new DashBoard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username and password");
                    setVisible(false);
                }
                
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==cancel)
        {
            setVisible(false);
        }
    }
}
