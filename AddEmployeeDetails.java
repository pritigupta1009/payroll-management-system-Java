package System;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployeeDetails extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add, back;
    
    AddEmployeeDetails() {
    	super("Add Employee Details");

    	getContentPane().setBackground(Color.white);
        setLayout(null);
		
		ImageIcon i1 = new ImageIcon("payroll logo\\addemp.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel heading = new JLabel("Add Employee Detail");
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(250, 200, 150, 30);
        image.add(dcdob);
        
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
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(650, 300, 150, 30);
        image.add(cbeducation);
        
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
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(250, 400, 150, 30);
        lblempId.setFont(new Font("Calibri", Font.PLAIN, 20));
        image.add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            //String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            Date dobDate = dcdob.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dob = dateFormat.format(dobDate);
            String age = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+empId+"','"+name+"', '"+fname+"', '"+dob+"', '"+age+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"',0)";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new PiHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new PiHome();
        }
    }

    public static void main(String[] args) {
        new AddEmployeeDetails();
    }
}