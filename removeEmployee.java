package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class removeEmployee extends JFrame implements ActionListener{
	JTextField tfuserid;
	
	removeEmployee(){
		super("Remove Employee");
		getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Remove Employee Detail");
        heading.setBounds(180, 20, 500, 60);
        heading.setFont(new Font("Calibri", Font.ITALIC, 25));
        add(heading);
        
        JLabel lbluserid = new JLabel("Userid");
        lbluserid.setBounds(40, 100, 150, 30);
        add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(100, 100, 150, 30);
        add(tfuserid);
        
        JButton Submit = new JButton("Submit");
        Submit.setBounds(350, 100, 150, 30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        add(Submit);
        
        setSize(600, 200);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String id = tfuserid.getText();
		
		try {
			Conn c = new Conn();
			String query = "DELETE FROM employee WHERE employee_id = '"+id+"'";
	        c.s.executeUpdate(query);
	        JOptionPane.showMessageDialog(null, "Row deleted successfully");
            setVisible(false);
            new PiHome();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new removeEmployee();
	}
}
