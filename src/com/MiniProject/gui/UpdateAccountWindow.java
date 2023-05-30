package com.MiniProject.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateAccountWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Connection con;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAccountWindow window = new UpdateAccountWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public UpdateAccountWindow() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		frame = new JFrame();
		frame.setBounds(100, 100, 1346, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Update Account Section");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(664, 89, 400, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account No :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(686, 200, 150, 30);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(846, 200, 200, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
				
		JButton btnNewButton = new JButton("Age");
		btnNewButton.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                	int temp=Integer.parseInt(textField.getText());
                	
                	
                	JLabel lblNewLabel_2 = new JLabel("New Age :");
                	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
                	lblNewLabel_2.setBounds(369, 389, 100, 30);
                	frame.getContentPane().add(lblNewLabel_2);
                	
                	textField_2 = new JTextField();
                	textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
                	textField_2.setBounds(479, 390, 150, 30);
                	frame.getContentPane().add(textField_2);
                	textField_2.setColumns(10);
            		
            		
            		JButton btnNewButton_1 = new JButton("Update Age");
                	btnNewButton_1.addActionListener(new ActionListener()
            		{
                        public void actionPerformed(ActionEvent e) 
                        {
                            try
                            {
                            	int temp1=Integer.parseInt(textField_2.getText());   
                            	   
                            	String query = "update account_details set age=? where account_no=?";
               					PreparedStatement st = con.prepareStatement(query);
               					st.setInt(1, temp1);
               					st.setInt(2,  temp);               					
               					
               					int count1 = st.executeUpdate();
               					if(count1>0)
            					{
            						JFrame frame = new JFrame();
            						frame.setSize(200, 200);
            						frame.setLocationRelativeTo(null);
            						frame.setVisible(true);
            						JOptionPane.showMessageDialog(frame, "Update Successfull");
            					}
               					
               					else
               					{
               					
               							int ERROR_MESSAGE = 0;
               							JOptionPane.showMessageDialog(frame, "Invalid Account_no", "Error",ERROR_MESSAGE );
               					}
                            }
                            catch(Exception e1)
                            {
                            	System.out.println(e1);
                            }

                        }
                    });
                	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
                	btnNewButton_1.setBounds(447, 486, 175, 30);
                	frame.getContentPane().add(btnNewButton_1);
                	
                	                	
                	
                }
                catch(Exception e1)
                {
                	System.out.println(e1);
                }

            }
        });
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(436, 305, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JButton btnNewButton_2 = new JButton("Mobile No");
		btnNewButton_2.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                	int temp=Integer.parseInt(textField.getText());


            		JLabel lblNewLabel_3 = new JLabel("New Mobile No: ");
            		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
            		lblNewLabel_3.setBounds(640, 413, 175, 30);
            		frame.getContentPane().add(lblNewLabel_3);
            		
            		textField_3 = new JTextField();
            		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
            		textField_3.setBounds(788, 413, 150, 30);
            		frame.getContentPane().add(textField_3);
            		textField_3.setColumns(10);
            		
            		
            		JButton btnNewButton_4 = new JButton("Update Mobile No");
            		btnNewButton_4.addActionListener(new ActionListener()
            		{
                        public void actionPerformed(ActionEvent e) 
                        {
                            try
                            {
                            	String temp2=textField_3.getText();   
                            	   
                            	String query = "update account_details set mobile_no=? where account_no=?";
               					PreparedStatement st = con.prepareStatement(query);
               					st.setString(1, temp2);
               					st.setInt(2,  temp);               					
               					
               					int count2 = st.executeUpdate();
               					if(count2>0)
            					{
            						JFrame frame = new JFrame();
            						frame.setSize(200, 200);
            						frame.setLocationRelativeTo(null);
            						frame.setVisible(true);
            						JOptionPane.showMessageDialog(frame, "Update Successfull");
            					}
               					
               					else
               					{
               					
               							int ERROR_MESSAGE = 0;
               							JOptionPane.showMessageDialog(frame, "Invalid Account_no", "Error",ERROR_MESSAGE );
               					}
                            }
                            catch(Exception e1)
                            {
                            	System.out.println(e1);
                            }

                        }
                    });
            		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
            		btnNewButton_4.setBounds(706, 544, 175, 25);
            		frame.getContentPane().add(btnNewButton_4);           	
                	

                	
            		                }
                catch(Exception e2)
                {
                	System.out.println(e2);
                }

            }
        });

		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(706, 305, 175, 30);
		frame.getContentPane().add(btnNewButton_2);
		

		
		
		JButton btnNewButton_3 = new JButton("Address");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int temp=Integer.parseInt(textField.getText());
					
					JLabel lblNewLabel_4 = new JLabel("New Address :");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblNewLabel_4.setBounds(975, 404, 150, 30);
					frame.getContentPane().add(lblNewLabel_4);
					
					textField_4 = new JTextField();
					textField_4.setBounds(1109, 407, 150, 30);
					frame.getContentPane().add(textField_4);
					textField_4.setColumns(10);
					
					JButton btnNewButton_5 = new JButton("Update Address");
					btnNewButton_5.addActionListener(new ActionListener()
					{
			            public void actionPerformed(ActionEvent e) 
			            {
			                try
			                {
			                	String temp2=textField_4.getText();   
			                	   
			                	String query = "update account_details set address=? where account_no=?";
			   					PreparedStatement st = con.prepareStatement(query);
			   					st.setString(1, temp2);
			   					st.setInt(2,  temp);               					
			   					
			   					int count3 = st.executeUpdate();
			   					if(count3>0)
								{
									JFrame frame = new JFrame();
									frame.setSize(200, 200);
									frame.setLocationRelativeTo(null);
									frame.setVisible(true);
									JOptionPane.showMessageDialog(frame, "Update Successfull");
								}
			   					
			   					else
			   					{
			   					
			   							int ERROR_MESSAGE = 0;
			   							JOptionPane.showMessageDialog(frame, "Invalid Account_no", "Error",ERROR_MESSAGE );
			   					}
			                }
			                catch(Exception e1)
			                {
			                	System.out.println(e1);
			                }

			            }
			        });
					btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnNewButton_5.setBounds(1024, 498, 175, 30);
					frame.getContentPane().add(btnNewButton_5);

										
					

					
				}
				
				catch(Exception e4)
				{
					System.out.println(e4);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(1024, 305, 175, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Exit");
		btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SecondWindow nextWindow = null;
                try {
					nextWindow = new SecondWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_6.setBounds(1216, 42, 150, 30);
		frame.getContentPane().add(btnNewButton_6);
		
		
				
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
