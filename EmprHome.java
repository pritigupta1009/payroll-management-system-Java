package System;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmprHome extends JFrame implements ActionListener{
	JButton viewEmployees, approveLoan;
	
	EmprHome(){
		super("Employer Home");
		getContentPane().setBackground(Color.white);
        setLayout(null);
		
		ImageIcon i1 = new ImageIcon("payroll logo\\office.jpg");
        Image i2 = i1.getImage().getScaledInstance(1200, 632, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 632);
        add(image);
        
        JLabel heading = new JLabel("Employer Functions");
        heading.setBounds(350, 50, 800, 120);
        heading.setFont(new Font("Calibri", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        viewEmployees = new JButton("View Employees");
        viewEmployees.setBounds(300, 300, 200, 70);
        viewEmployees.addActionListener(this);
        image.add(viewEmployees);
        
        approveLoan = new JButton("ApproveLoan");
        approveLoan.setBounds(700, 300, 200, 70);
        approveLoan.addActionListener(this);
        image.add(approveLoan);
        
        setSize(1200, 632);
        setLocation(250, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewEmployees) {
        	setVisible(false);
            new ViewEmployees();
        }else {
        	setVisible(false);
        	new ApproveLoan();
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmprHome();
	}
}
