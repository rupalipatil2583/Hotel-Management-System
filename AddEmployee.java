
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField nm1,age1,phone1,Email1,Sal1,add;
    JRadioButton  male,female;
    JComboBox cb;
    JButton submit,back;
    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,20,950,600);   //for frame
        setLayout(null);
        
        JLabel nm=new JLabel("Name");
        nm.setBounds(40,30,100,30);
        nm.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(nm);
        
        nm1=new JTextField();
        nm1.setBounds(170,30,200,30);
        add(nm1);
        
        JLabel age=new JLabel("Age");
        age.setBounds(40,80,100,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
       age1=new JTextField();
        age1.setBounds(170,80,200,30);
        add(age1);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(40,130,100,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
         male=new JRadioButton("Male");
        male.setBounds(170,130,100,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(270,130,150,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(female);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel Job=new JLabel("Job");
        Job.setBounds(40,180,100,30);
        Job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Job);
        
       String hotel_jobs[] = {
    "Front Desk Clerk","Housekeeping Staff","Porter", "Maintenance Staff","cheif","Waiter","Room service","kitchen staff",
    "Manager","Event Coordinator","Security Staff","Accountant"
       };

         cb=new JComboBox(hotel_jobs);
        cb.setBounds(170, 180, 200, 30);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel phone=new JLabel("Phone");
        phone.setBounds(40,230,100,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);
        
        phone1=new JTextField();
        phone1.setBounds(170,230,200,30);
        add(phone1);
        
        JLabel Email=new JLabel("Email");
        Email.setBounds(40,280,100,30);
        Email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Email);
        
        Email1=new JTextField();
        Email1.setBounds(170,280,200,30);
        add(Email1);
        
        JLabel Sal=new JLabel("Salary");
        Sal.setBounds(40,330,100,30);
        Sal.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Sal);
        
        Sal1=new JTextField();
        Sal1.setBounds(170,330,200,30);
        add(Sal1);
        
        JLabel address=new JLabel("Address");
        address.setBounds(40,380,100,30);
        address.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(address);
        
        add=new JTextField();
        add.setBounds(170,380,200,30);
        add(add);
        
        submit=new JButton("Submit");
        submit.setBounds(40,430,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(160,430,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/staff.jpg"));
        JLabel img=new JLabel(i1);
        img.setBounds(400,30,500,500);
        add(img);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            
            String name,age,phone,email,sal,address;
        name=nm1.getText();
        age=age1.getText();
        phone=phone1.getText();
        email=Email1.getText();
        sal=Sal1.getText();
        address=add.getText();
        
        String gender=null;
        
        
        if(male.isSelected())
        {
            gender="Male";
            
        }
        else
        {
            gender="female";
        }
        
        String job=(String)cb.getSelectedItem();
        if (name.isEmpty() || phone.isEmpty() || sal.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                }
        else
        {
                    try{
                   DbConnection c= new DbConnection();
                   String query = "insert into Employee values('" + name + "', '" + age + "','" + gender + "','" + job + "','" + phone + "','" + email + "','" + sal + "','" + address + "')";

                   c.s.executeUpdate(query);

                   JOptionPane.showMessageDialog(null, "Employee Added SuccessFully");

                   setVisible(false);
                        }
                catch(Exception ae)
                {
                    ae.printStackTrace();
                }
        }
            
        }
        else
        {
            setVisible(false);
            new DashBoard();
        }
        
    }
}
