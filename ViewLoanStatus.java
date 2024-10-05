package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class ViewLoanStatus extends JFrame implements ActionListener{
	
	JButton Submit, back;
	JTextField tfuserid;
	
	ViewLoanStatus(){
		super("Check Loan Status");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\Loan1.jpg");
        Image i2 = i1.getImage().getScaledInstance(728, 455, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 728, 455);
        add(image);
        
        JLabel lbluserid = new JLabel("USER ID");
        lbluserid.setBounds(250, 120, 100, 30);
        image.add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(350, 120, 100, 30);
        image.add(tfuserid);
        
        Submit = new JButton("Check Loan Status");
        Submit.setBounds(250, 200, 200, 30);
        Submit.addActionListener(this);
        image.add(Submit);
        
        back = new JButton("Back");
        back.setBounds(250, 300, 200, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(728, 455);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == Submit) {
			int att = 0;
			try {
	            Conn c = new Conn();
	            String query1 = "select Approval from Loan WHERE employee_id = '"+tfuserid.getText()+"'";
	            ResultSet rs = c.s.executeQuery(query1);
	            if(rs.next()) {
	                att = Integer.parseInt(rs.getString("Approval"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			if(att == 1) {
				JOptionPane.showMessageDialog(null, "Loan Request Accepted");
	            setVisible(false);
	            new EmpHome();
			}
			else {
				JOptionPane.showMessageDialog(null, "Loan Not Granted ");
	            setVisible(false);
	            new EmpHome();
			}
		}
		else {
			setVisible(false);
            new EmpHome();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewLoanStatus();
	}

}
