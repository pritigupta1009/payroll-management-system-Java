package System;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewOwnDetails extends JFrame implements ActionListener{
	
	JTextField tfuserid, tfpassword;
	JTable table;
	JButton login, back;
	
	ViewOwnDetails(){
		
		super("View Employee Details");
		getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbluserid = new JLabel("Userid");
        lbluserid.setBounds(40, 20, 100, 30);
        add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(150, 20, 150, 30);
        add(tfuserid);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(350, 45, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        back = new JButton("Back");
        back.setBounds(550, 45, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        
        
        setSize(900, 420);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == login) {
			table = new JTable();
			String id = tfuserid.getText();
			String password = tfpassword.getText();
			String query = "select * from employee where employee_id = '"+id+"'";
			try {
	            Conn c = new Conn();
	            ResultSet rs = c.s.executeQuery(query);
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			JScrollPane jsp = new JScrollPane(table);
	        jsp.setBounds(0, 100, 900, 600);
	        add(jsp);
	        JOptionPane.showMessageDialog(null, "Press Ok to go back to Home page");
            setVisible(false);
            new EmpHome();
		}else {
			setVisible(false);
            new EmpHome();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewOwnDetails();
	}

}
