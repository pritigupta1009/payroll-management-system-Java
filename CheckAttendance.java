package System;

import java.util.Random;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CheckAttendance extends JFrame implements ActionListener{
    
	JButton Update,back;
	JTextField tfuserid;
    Choice cemployeeId;
	JTable table;
	
	CheckAttendance(){
		super("Increment Attendance Details");
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
            ResultSet rs = c.s.executeQuery("select * from Attendance WHERE Approval = 1");
            while(rs.next()) {
                cemployeeId.add(rs.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Attendance");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        

        Update = new JButton("Update Attendance");
        Update.setBounds(20, 70, 150, 20);
        Update.addActionListener(this);
        add(Update);
        
        back = new JButton("Back");
        back.setBounds(200, 70, 150, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 420);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == Update) {
			int att = 0;
			try {
	            Conn c = new Conn();
	            String query1 = "select Attendance from employee WHERE employee_id = '"+cemployeeId.getSelectedItem()+"'";
	            ResultSet rs = c.s.executeQuery(query1);
	            if(rs.next()) {
	                att = Integer.parseInt(rs.getString("Attendance"));
//	                System.out.println(att);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			int newAtt = att+1;
			String query2 = "Update employee set Attendance = '"+newAtt+"' WHERE employee_id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String query1 = "Update Attendance set Approval = 0 WHERE employee_id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Attendance Incremented");
            setVisible(false);
            new PiHome();
		}
		else {
			setVisible(false);
            new PiHome();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckAttendance();
	}

}
