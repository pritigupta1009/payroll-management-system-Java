package System;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ApproveLoan extends JFrame implements ActionListener{
	
	JButton approveLoan,back;
	Choice cemployeeId;
	JTable table;
	
	ApproveLoan(){
		super("Approve Loan");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Loan WHERE Approval = 0");
            while(rs.next()) {
                cemployeeId.add(rs.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Loan WHERE Approval = 0");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        approveLoan = new JButton("Approve Loan");
        approveLoan.setBounds(20, 70, 150, 20);
        approveLoan.addActionListener(this);
        add(approveLoan);
        
        back = new JButton("Back");
        back.setBounds(200, 70, 150, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == approveLoan) {
            String query1 = "Update Loan set Approval = 1 WHERE employee_id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                //table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            table = new JTable();
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from Loan WHERE Approval = 0");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0, 100, 900, 600);
            add(jsp);
            
		}
		else {
			new EmprHome();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ApproveLoan();
	}

}
