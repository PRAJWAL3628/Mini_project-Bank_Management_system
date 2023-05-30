package com.MiniProject.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteAccountWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccountWindow window = new DeleteAccountWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public DeleteAccountWindow() {
		try {
			initialize();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1380, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Account No :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(670, 230, 150, 20);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(842, 229, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Account Delete Section");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(620, 100, 400, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Delete");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp1;
				temp1 = Integer.parseInt(textField.getText());

				Connection con = null;
				try {
					String query = "select * from account_details where account_no=?";
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
					PreparedStatement st = con.prepareStatement(query);

					st.setInt(1, temp1);

					ResultSet result = st.executeQuery();

					int tempacc_no = 0;

					while (result.next()) {
						tempacc_no = result.getInt("account_no");
					}

					if (tempacc_no == temp1)
					{
						int count1 = st.executeUpdate("delete from transaction_details where account_no=" + temp1);
						int count2 = st.executeUpdate("delete from loan_details where account_no=" + temp1);
						int count = st.executeUpdate("delete from account_details where account_no=" + temp1);
						
						JFrame frame = new JFrame();
						frame.setSize(200, 200);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Account Deleted Successfully");
					} 
					
					else 
					{
						JOptionPane.showMessageDialog(frame, "Invalid Account_no", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (SQLException ex) 
				{
					System.out.println(ex);
				} 
				finally {
					// Close the connection in the finally block
					if (con != null) {
						try {
							con.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(735, 332, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(1241, 27, 150, 30);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void setVisible(boolean b) {
		JLabel label = new JLabel("This is the second window");
		frame.getContentPane().add(label);
		frame.setVisible(b);
	}

}
