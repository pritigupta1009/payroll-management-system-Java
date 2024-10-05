package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class GenerateSalary extends JFrame implements ActionListener{
	
	JButton genearateSalary,back;
	Choice cemployeeId;
	
	GenerateSalary(){
		super("Generate Salary");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\Salary.jpeg");
        Image i2 = i1.getImage().getScaledInstance(609, 403, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 609, 403);
        add(image);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        image.add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        image.add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        genearateSalary = new JButton("Generate Salary");
        genearateSalary.setBounds(200, 240, 200, 30);
        genearateSalary.addActionListener(this);
        image.add(genearateSalary);
        
        back = new JButton("Back");
        back.setBounds(200, 300, 200, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(609, 403);
        setLocation(300, 100);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == genearateSalary) {
			String empId = cemployeeId.getSelectedItem();
			String employeeName = "";
			String age = "";
			try {
				Conn c = new Conn();
				String query1 =  "select employee_name from employee where employee_id = '"+empId+"'";
				ResultSet rs1 = c.s.executeQuery(query1);
				if(rs1.next()) {
					employeeName = rs1.getString("employee_name");
					//System.out.println(employeeName);

				}
			}
			catch(Exception e) {
	            e.printStackTrace();
	        }
			try {
				Conn c = new Conn();
				String query2 =  "select Age from employee where employee_id = '"+empId+"'";
				ResultSet rs2 = c.s.executeQuery(query2);
				if(rs2.next()) {
					age = rs2.getString("Age");
				}
				//System.out.println(age);
			}
			catch(Exception e) {
	            e.printStackTrace();
	        }
			int att = 1;
			try {
				Conn c = new Conn();
				String query3 =  "select Attendance from employee where employee_id = '"+empId+"'";
				ResultSet rs3 = c.s.executeQuery(query3);
				if(rs3.next()) {
					att = Integer.parseInt(rs3.getString("Attendance"));
				}
				//System.out.println(age);
			}
			catch(Exception e) {
	            e.printStackTrace();
	        }
			
			double basic = att * 5000;

	        double hra = 0.50 * basic;  // 50% of basic
	        double da = 0.42 * basic;   // 42% of basic
	        double pda = 3000;
	        double uniformallowance = 3000;
	        double convenience = 3000;
	        double specialallowance = 0.33 * basic; // 33% of basic
	        double grossSalary = basic + hra + da + pda + specialallowance + uniformallowance + convenience;

	        //calculating income tax
	        double itax=0.0;
	        double pf = 0.12 * basic; // 12% of basic
	        int age1 = Integer.parseInt(age);
	        if(age1>=60)
	        {
	            if((grossSalary*12) <= 250000)
	                itax = 0;
	            else if((grossSalary*12)>250000 && (grossSalary*12)<=500000)
	                itax = 0.05 *grossSalary;
	            else if((grossSalary*12)>500000 && (grossSalary*12)<=1000000)
	                itax = (0.20 *grossSalary) + 2500;
	            else if((grossSalary*12) > 1000000)
	                itax = (0.30 * grossSalary) + 11250;
	        }
	        else if(Integer.parseInt(age)>=18 && Integer.parseInt(age)<50)
	        {
	            if((grossSalary*12) <= 250000)
	                itax = 0;
	            else if((grossSalary*12)>250000 && (grossSalary*12)<=500000)
	                itax = (0.05 * grossSalary);
	            else if((grossSalary*12)>500000 && (grossSalary*12)<=750000)
	                itax = (0.10 * grossSalary) + 1250;
	            else if((grossSalary*12)>750000 && (grossSalary*12)<=1000000)
	                itax = (0.15 * grossSalary) + 3750;
	            else if((grossSalary*12)>1000000 && (grossSalary*12)<=1250000)
	                itax = (0.20 * grossSalary) + 7500;
	            else if((grossSalary*12)>1250000 && (grossSalary*12)<=1500000)
	                itax = (0.25 * grossSalary) + 12500;
	            else if((grossSalary*12)>1500000)
	                itax = (0.30 * grossSalary) + 18750;
	        }

	        double netSalary = grossSalary - itax - pf;
	        try {
	            Conn c = new Conn();
	            String query3 = "insert into Salary values('"+empId+"','"+employeeName+"', '"+age1+"', '"+basic+"', '"+hra+"', '"+da+"', '"+pda+"','"+uniformallowance+"','"+convenience+"', '"+specialallowance+"', '"+itax+"', '"+pf+"', '"+grossSalary+"', '"+netSalary+"')";
	            c.s.executeUpdate(query3);
	            JOptionPane.showMessageDialog(null, "Details added successfully");
	            setVisible(false);
	            new PiHome();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		else {
			setVisible(false);
            new PiHome();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenerateSalary();
	}

}
