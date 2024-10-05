package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddLoginCredentials extends JFrame implements ActionListener{
    
	JTextField tfusername, tfpassword;
	JButton InsertLoginCredentials,back;
	
	AddLoginCredentials(){
		super("Insert Employee Login Credentials");
		getContentPane().setBackground(Color.white);
	    setLayout(null);
		
		ImageIcon i1 = new ImageIcon("payroll logo\\LoginCred.jpg");
	    Image i2 = i1.getImage().getScaledInstance(612, 409, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(0, 0, 612, 409);
	    add(image);
	    
	    JLabel heading = new JLabel("Insert Employee User Id Credentials");
        heading.setBounds(120, 20, 400, 120);
        heading.setFont(new Font("Calibri", Font.PLAIN, 26));
        heading.setForeground(Color.BLACK);
        image.add(heading);
	    
	    JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(200, 130, 200, 40);
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(280, 130, 100, 30);
        image.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(200, 180, 200, 40);
        image.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(280, 180, 100, 30);
        image.add(tfpassword);
       
        InsertLoginCredentials = new JButton("Add Employee Information");
        InsertLoginCredentials.setBounds(200, 240, 200, 30);
        InsertLoginCredentials.addActionListener(this);
        image.add(InsertLoginCredentials);
        
        back = new JButton("Back");
        back.setBounds(200, 300, 200, 30);
        back.addActionListener(this);
        add(back);
        
        setSize(612, 409);
        setLocation(250, 100);
        setVisible(true);
	}
	 public void actionPerformed(ActionEvent ae) {
		 
		 if(ae.getSource() == InsertLoginCredentials) {
		 		try {
		            String username = tfusername.getText();
		            String password = tfpassword.getText();
		            
		            Conn c = new Conn();
		            String query = "insert into Userlogin values('"+username+"','"+password+"')";
		            c.s.executeUpdate(query);
		            setVisible(false);
	                new AddEmployeeDetails();
		       } 
		            catch (Exception e) {
		            e.printStackTrace();
		        }
		 }
		 else {
			 setVisible(false);
             new PiHome();
		 }
		 	
	 }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new AddLoginCredentials();
		}
}
