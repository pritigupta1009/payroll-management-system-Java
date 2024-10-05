package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApplyLoan extends JFrame implements ActionListener{
	
	JButton Submit, back;
	JTextField tfloan, tfuserid;
	
	ApplyLoan(){
		super("Apply Loan");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("payroll logo\\Loan.jpg");
        Image i2 = i1.getImage().getScaledInstance(728, 455, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 728, 455);
        add(image);
        
        JLabel lbluserid = new JLabel("USER ID");
        lbluserid.setBounds(250, 80, 100, 30);
        image.add(lbluserid);
        
        tfuserid = new JTextField();
        tfuserid.setBounds(350, 80, 100, 30);
        image.add(tfuserid);
        
        JLabel loanlbl = new JLabel("Loan Amount");
        loanlbl.setBounds(250, 140, 100, 30);
        image.add(loanlbl);
        
        tfloan = new JTextField();
        tfloan.setBounds(350, 140, 100, 30);
        image.add(tfloan);
        
        Submit = new JButton("Request Loan");
        Submit.setBounds(250, 240, 200, 30);
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
			String empId = tfuserid.getText();
			double loan = Double.parseDouble(tfloan.getText());
			int Approval = 0;
			try {
	            Conn c = new Conn();
	            String query3 = "insert into Loan values('"+empId+"','"+loan+"', '"+Approval+"')";
	            c.s.executeUpdate(query3);
	            JOptionPane.showMessageDialog(null, "Details added successfully");
	            setVisible(false);
	            new EmpHome();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		else {
			setVisible(false);
            new EmpHome();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ApplyLoan();
	}
}

