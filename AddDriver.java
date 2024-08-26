
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nm,age,company1,model1,location1,mobile;
    JComboBox gender1,available1;
    JButton add,cancel,back;
    AddDriver()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,20,950,580);   
        setLayout(null);
        
        JLabel l1=new JLabel("Add New Driver");
        l1.setBounds(80,30,200,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l1);
        
        JLabel name=new JLabel("Name");
        name.setBounds(80,80,180,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        nm=new JTextField();
        nm.setBounds(280,80,200,30);
        add(nm);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(80,130,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l2);
        
        age=new JTextField();
        age.setBounds(280,130,200,30);
        add(age);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(80,180,100,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        String gen[]={"Male","Female"};
        gender1=new JComboBox(gen);
        gender1.setBounds(280, 180, 200, 30);
        gender1.setBackground(Color.white);
        add(gender1);
        
        JLabel mob=new JLabel("Mobile Number");
        mob.setBounds(80,230,180,30);
        mob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(mob);
        
        mobile=new JTextField();
        mobile.setBounds(280,230,200,30);
        add(mobile);
        
        JLabel company=new JLabel("Car Company");
        company.setBounds(80,280,180,30);
        company.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(company);
        
        company1=new JTextField();
        company1.setBounds(280,280,200,30);
        add(company1);
        
        JLabel model=new JLabel("Car Model");
        model.setBounds(80,330,180,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(model);
        
        model1=new JTextField();
        model1.setBounds(280,330,200,30);
        add(model1);
        
        JLabel available=new JLabel("Available");
        available.setBounds(80,380,100,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);
        
        String availableOption[]={"Available","Not Available"};
        available1=new JComboBox(availableOption);
        available1.setBounds(280, 380, 200, 30);
        available1.setBackground(Color.white);
        add(available1);
        
        JLabel loc=new JLabel("Location");
        loc.setBounds(80,430,180,30);
        loc.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(loc);
        
        location1=new JTextField();
        location1.setBounds(280,430,200,30);
        add(location1);
        
        add=new JButton("Add Driver");
        add.setBounds(80,480,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(200,480,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
        Image i2=i1.getImage().getScaledInstance(440,  550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,10,440,550);
        add(img);
        
         back=new JButton("Back");
        back.setBounds(320,480,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String nm1,age1,gender,mob,company,model,available,location;
        nm1=nm.getText();
        age1=age.getText();
        //int age2=Integer.parseInt(age1);
        gender=(String)gender1.getSelectedItem();
        mob=mobile.getText();
        
        company=company1.getText();
        model=model1.getText();
        available=(String)available1.getSelectedItem();
        location=location1.getText();
        
       
         if(e.getSource()== add)
       {
           if (nm1.isEmpty() || mob.isEmpty()|| age1.isEmpty() || gender.isEmpty() || company.isEmpty() || model.isEmpty() ||  available.isEmpty() || location.isEmpty())
                 {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                 }
           else 
           {
                        try
                 {
                     DbConnection c=new DbConnection();

                     String query="insert into Driver values ('"+nm1+"','"+age1+"','"+gender+"','"+mob+"','"+company+"','"+model+"','"+available+"','"+location+"')";

                    c.s.executeUpdate(query);

                     JOptionPane.showMessageDialog(null, "Driver Added SuccessFully");

                    setVisible(false);
                    new DashBoard();
                 }
                 catch(Exception ae)
                 {
                     ae.printStackTrace();
                 }
           }
           
       }
       else if(e.getSource()==cancel)
        {
             nm.setText("");
             age.setText("");
             company1.setText("");
             model1.setText("");
             location1.setText("");
             mobile.setText("");
             gender1.setSelectedIndex(0);
             available1.setSelectedIndex(0);
            
        }
        else
       {
           setVisible(false);
            new DashBoard();
       }
    }
    
    public static void main(String[] args)
    {
        new AddDriver();
    }
}
