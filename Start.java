package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener{
	
	JButton emp,pI,empr;
    
    public Start() {
    	super("Pay - Pay!");
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Payroll Management System");
        heading.setBounds(250, 30, 1200, 60);
        heading.setFont(new Font("Calibri", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\payroll logo.png");
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 100, 500, 500);
        add(image);
        
        emp = new JButton("Employee");
        emp.setBounds(750, 250, 200, 70);
        emp.setBackground(Color.darkGray);
        emp.setForeground(Color.WHITE);
        emp.addActionListener(this);
//        image.
        add(emp);
        
        pI = new JButton("Payroll Incharge");
        pI.setBounds(750, 350, 200, 70);
        pI.setBackground(Color.darkGray);
        pI.setForeground(Color.WHITE);
        pI.addActionListener(this);
//        image.
        add(pI);
        
        empr = new JButton("Employer");
        empr.setBounds(750, 450, 200, 70);
        empr.setBackground(Color.darkGray);
        empr.setForeground(Color.WHITE);
        empr.addActionListener(this);
//        image.
        add(empr);
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        heading.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        if(ae.getSource() == emp) {
        	new Login();//for employee
        }
        else if(ae.getSource() == pI) {
        	new PayrollLogin();//for payrollIncharge
        }
        else {
        	new emprLogin();//for employer
        }
    }
    
    public static void main(String args[]) {
        new Start();
    }
}
