package System;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewSalary extends JFrame implements ActionListener{
	
	JTextField tfuserid;
	JTable table;
	JButton View, back;
	
	ViewSalary(){
		super("View Employee Details");
		getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbluserid = new JLabel("USER ID");
        lbluserid.setBounds(40, 20, 150, 20);
        add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(140, 20, 150, 20);
        add(tfuserid);
        
        View = new JButton("VIEW");
        View.setBounds(20, 70, 150, 20);
        View.addActionListener(this);
        add(View);
        
        back = new JButton("Back");
        back.setBounds(200, 70, 150, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 420);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == View) {
			table = new JTable();
			String id = tfuserid.getText();
			String query = "select * from Salary where employee_id = '"+id+"'";
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
		new ViewSalary();
	}

}
