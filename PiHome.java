package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiHome extends JFrame implements ActionListener{
	JButton addDetails,viewEmployees,removeEmployees,generateSalary,checkAttendance;
	
	public PiHome() {
		
    	super("Payroll Incharge Home");

		getContentPane().setBackground(Color.white);
        setLayout(null);
		
		ImageIcon i1 = new ImageIcon("payroll logo\\office.jpg");
        Image i2 = i1.getImage().getScaledInstance(1200, 632, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 632);
        add(image);
        
        JLabel heading = new JLabel("Payroll Incharge Functions");
        heading.setBounds(300, 50, 800, 120);
        heading.setFont(new Font("Calibri", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        addDetails = new JButton("Add Employee Details");
        addDetails.setBounds(200, 300, 200, 70);
        addDetails.addActionListener(this);
        image.add(addDetails);
        
        checkAttendance = new JButton("Check Attendance");
        checkAttendance.setBounds(500, 300, 200, 70);
        checkAttendance.addActionListener(this);
        image.add(checkAttendance);
        
        viewEmployees = new JButton("View Employees");
        viewEmployees.setBounds(800, 300, 200, 70);
        viewEmployees.addActionListener(this);
        image.add(viewEmployees);
        
        removeEmployees = new JButton("Remove Employee");
        removeEmployees.setBounds(350, 450, 200, 70);
        removeEmployees.addActionListener(this);
        image.add(removeEmployees);
        
        generateSalary = new JButton("Generate Salary");
        generateSalary.setBounds(650, 450, 200, 70);
        generateSalary.addActionListener(this);
        image.add(generateSalary);
        
        setSize(1200, 632);
        setLocation(250, 100);
        setVisible(true);
	}
	
	 public void actionPerformed(ActionEvent ae) {
	        setVisible(false);
	        if (ae.getSource() == addDetails) {
	            new AddLoginCredentials();
	        } else if(ae.getSource() == checkAttendance){
	            new CheckAttendance();
	        }else if(ae.getSource() == viewEmployees){
	            new ViewEmployees();
	        }else if(ae.getSource() == removeEmployees){
	            new removeEmployee();
	        }
	        else {
	        	new GenerateSalary();
	        }
	        
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PiHome();
	}
	
}
