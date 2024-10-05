package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class AddAttendance extends JFrame implements ActionListener{
	
	JButton giveAttendance,back,Submit;
	JTextField tfuserid, tfuniqueid;
	String empId;
	JLabel image;
	AddAttendance(){
		super("Give Attendance");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\att1.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 700, 520);
        add(image);
        
        JLabel lbluserid = new JLabel("USER ID");
        lbluserid.setBounds(250, 60, 100, 30);
        image.add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(350, 60, 100, 30);
        image.add(tfuserid);
        
        JLabel lbluniqueid = new JLabel("UniqueId");
        lbluniqueid.setBounds(250, 200, 100, 30);
        image.add(lbluniqueid);
        
        tfuniqueid = new JTextField();
        tfuniqueid.setBounds(350, 200, 100, 30);
        image.add(tfuniqueid);
        
        giveAttendance = new JButton("AddAttendance");
        giveAttendance.setBounds(250, 120, 200, 30);
        giveAttendance.addActionListener(this);
        image.add(giveAttendance);
        
        back = new JButton("Back");
        back.setBounds(250, 400, 200, 30);
        back.addActionListener(this);
        image.add(back);

        
        
        setSize(700, 520);
        setLocation(300, 100);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == giveAttendance) {
			Random ran = new Random();
		    int number = ran.nextInt(999999);
		    empId = tfuserid.getText();
		    try {
	            Conn c = new Conn();
	            String query3 = "insert into Attendance values('"+empId+"', '"+number+"',0)";
	            c.s.executeUpdate(query3);
	            JOptionPane.showMessageDialog(null, "Details added successfully");
	            //setVisible(false);
	            //new EmpHome();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		   
	        
	        Submit = new JButton("Submit Unique Id");
	        Submit.setBounds(250, 260, 200, 30);
	        Submit.addActionListener(this);
	        image.add(Submit);
		}
		else if(ae.getSource() == Submit) {
			String inputUniqueid = tfuniqueid.getText();
			int in = Integer.parseInt(inputUniqueid);
			int outUniqueId = 0;
			try {
	            Conn c = new Conn();
	            String query1 = "select OTP from Attendance WHERE employee_id = '"+empId+"'";
	            ResultSet rs = c.s.executeQuery(query1);
	            if(rs.next()) {
	                outUniqueId = Integer.parseInt(rs.getString("OTP"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			if(in == outUniqueId) {
				String query1 = "Update Attendance set Approval = 1 WHERE employee_id = '"+empId+"'";
	            try {
	                Conn c = new Conn();
	                c.s.executeUpdate(query1);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Unique Id");
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
		new AddAttendance();
	}
}
