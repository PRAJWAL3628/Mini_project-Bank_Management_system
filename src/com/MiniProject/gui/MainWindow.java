package com.MiniProject.gui;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MainWindow 
{
	private JFrame frame;
	private JTextField textField;
	private Connection con;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PRAJWAL LONARI\\Pictures\\bank-removebg-preview__1_-removebg-preview.png"));
		frame.setBounds(100, 100, 1350, 762);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("BANK MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(509, 72, 500, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(1039, 239, 200, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(1039, 329, 200, 30);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("UserName :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(887, 244, 100, 20);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(887, 331, 100, 19);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Log In");
		lblNewLabel_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setBounds(983, 135, 200, 50);
		frame.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1, temp2;
				temp1 = textField.getText();
				temp2 = passwordField.getText();

				try {
					String query = "select * from login_details where username=? and password=?";
					PreparedStatement st = con.prepareStatement(query);

					st.setString(1, temp1);
					st.setString(2, temp2);

					ResultSet result = st.executeQuery();

					String tempid = "";
					String temppass = "";

					while (result.next()) {
						tempid = result.getString("username");
						temppass = result.getString("password");
//						System.out.println(tempid + temppass);
					}

					if (tempid.equals(temp1) & temppass.equals(temp2) & !temp1.isBlank() & !temp2.isBlank()) {
						SecondWindow nextWindow = new SecondWindow();
						nextWindow.setVisible(true);
//						
						frame.dispose();
					} 
					else {
						JOptionPane.showMessageDialog(frame, "Invalid Login ID", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} 
				
				catch (SQLException ex) {
					System.out.println(ex);
				}

			}
		});
		btnNewButton.setBounds(947, 424, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("UserName :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(263, 244, 100, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(263, 330, 100, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setBounds(407, 243, 200, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField_1.setBounds(407, 329, 200, 30);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String temp1=textField_1.getText();
				String temp2=passwordField_1.getText();
				
				try
				{
					PreparedStatement pst = con.prepareStatement("insert into login_details values(?,?)");
					
					pst.setString(1, temp1);
					pst.setString(2, temp2);
					
					int count1=pst.executeUpdate();
					if (count1>0) 
                    {
                    	JFrame frame = new JFrame();
						frame.setSize(200, 200);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Sign Up Successfull!!!");
                    } 
					else 
					{
                        System.out.println("Data not added");
                    }
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(330, 424, 150, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Sign Up");
		lblNewLabel_6.setForeground(new Color(25, 25, 112));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_6.setBounds(406, 145, 150, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\PRAJWAL LONARI\\Pictures\\bank-removebg-preview__1_-removebg-preview.png"));
		lblNewLabel_7.setBounds(10, -5, 252, 192);
		frame.getContentPane().add(lblNewLabel_7);
	}
	
	public void setVisible(boolean b) {
        JLabel label = new JLabel("This is the second window");
        frame.getContentPane().add(label);
        frame.setVisible(b);
    }
}
