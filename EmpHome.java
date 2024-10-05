package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EmpHome extends JFrame implements ActionListener{
	
	JButton viewDetails,viewSalary,attendance,applyLoan,viewLoanStatus;
	
	public EmpHome(){
		
    	super("Employee Home");

		
		getContentPane().setBackground(Color.white);
        setLayout(null);
		
		ImageIcon i1 = new ImageIcon("payroll logo\\office.jpg");
        Image i2 = i1.getImage().getScaledInstance(1200, 632, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 632);
        add(image);
        
        
		JLabel heading = new JLabel("Employee Functions");
        heading.setBounds(350, 50, 600, 60);
        heading.setFont(new Font("Calibri", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        viewDetails = new JButton("View Employee Details");
        viewDetails.setBounds(200, 300, 200, 70);
        viewDetails.addActionListener(this);
        image.add(viewDetails);
        
        viewSalary = new JButton("View Salary");
        viewSalary.setBounds(500, 300, 200, 70);
        viewSalary.addActionListener(this);
        image.add(viewSalary);
        
        attendance = new JButton("Give Attendance");
        attendance.setBounds(800, 300, 200, 70);
        attendance.addActionListener(this);
        image.add(attendance);
        
        applyLoan = new JButton("Apply Loan");
        applyLoan.setBounds(350, 450, 200, 70);
        applyLoan.addActionListener(this);
        image.add(applyLoan);
        
        viewLoanStatus = new JButton("Check Loan Status");
        viewLoanStatus.setBounds(650, 450, 200, 70);
        viewLoanStatus.addActionListener(this);
        image.add(viewLoanStatus);
        
        setSize(1200, 632);
        setLocation(250, 100);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewDetails) {
            setVisible(false);
            new ViewOwnDetails();
        } else if (ae.getSource() == viewSalary){
            setVisible(false);
            new ViewSalary();
        }
        else if (ae.getSource() == viewLoanStatus){
            setVisible(false);
            new ViewLoanStatus();
        }
        else if (ae.getSource() == attendance){
            setVisible(false);
            new AddAttendance();
        }
        else {
        	setVisible(false);
        	new ApplyLoan();
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmpHome();
	}

}
