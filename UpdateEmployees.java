package System;

import java.awt.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
import java.sql.*;

public class UpdateEmployees extends JFrame implements ActionListener{
    
    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation, tfname, tfdob;
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    UpdateEmployees(String empId) {
    	super("Update Employee Details");
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\addemp.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 600, 60);
        heading.setFont(new Font("Calibri", Font.ITALIC, 25));
        image.add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(100, 150, 150, 30);
        labelname.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 150, 150, 30);
        image.add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(450, 150, 150, 30);
        labelfname.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(650, 150, 150, 30);
        image.add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(100, 200, 150, 30);
        labeldob.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labeldob);
        
        tfdob = new JTextField();
        tfdob.setBounds(250, 200, 150, 30);
        image.add(tfdob);
        
        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(450, 200, 150, 30);
        labelAge.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelAge);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(650, 200, 150, 30);
        image.add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(100, 250, 150, 30);
        labeladdress.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250, 250, 150, 30);
        image.add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(450, 250, 150, 30);
        labelphone.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        image.add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(100, 300, 150, 30);
        labelemail.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250, 300, 150, 30);
        image.add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(450, 300, 150, 30);
        labeleducation.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(650, 300, 150, 30);
        image.add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(100, 350, 150, 30);
        labeldesignation.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(250, 350, 150, 30);
        image.add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(450, 350, 150, 30);
        labelaadhar.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(650, 350, 150, 30);
        image.add(tfaadhar);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(100, 400, 150, 30);
        labelempId.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(250, 400, 150, 30);
        lblempId.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(lblempId);
        
//        try {
//            Conn c = new Conn();
//            String query = "select * from employee where employee_id = '"+empId+"'";
//            ResultSet rs = c.s.executeQuery(query);
//            while(rs.next()) {
//                tfname.setText(rs.getString("name"));
//                tffname.setText(rs.getString("fname"));
//                tfdob.setText(rs.getString("dob"));
//                tfaddress.setText(rs.getString("address"));
//                tfsalary.setText(rs.getString("Age"));
//                tfphone.setText(rs.getString("phone"));
//                tfemail.setText(rs.getString("email"));
//                tfeducation.setText(rs.getString("education"));
//                tfaadhar.setText(rs.getString("aadhar"));
//                lblempId.setText(rs.getString("empId"));
//                tfdesignation.setText(rs.getString("designation"));
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = tffname.getText();
            String age = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set fathers_name = '"+fname+"', Age = '"+age+"', address = '"+address+"', phone_number = '"+phone+"', email_id =  '"+email+"', highest_education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new PiHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployees();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployees("");
    }
}
