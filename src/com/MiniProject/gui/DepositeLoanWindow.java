package com.MiniProject.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DepositeLoanWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositeLoanWindow window = new DepositeLoanWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DepositeLoanWindow() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		frame = new JFrame();
		frame.setBounds(100, 100, 1348, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Account No : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(656, 263, 150, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Amount :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(656, 338, 150, 30);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(850, 264, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(850, 342, 150, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Enter the Details : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(498, 197, 200, 30);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp1, temp2;
				temp1 = Integer.parseInt(textField.getText());
				temp2 = Integer.parseInt(textField_1.getText());
		
				

				try {
					String query = "select * from loan_details where account_no=?";
					PreparedStatement st = con.prepareStatement(query);
					st.setInt(1, temp1);
			
					ResultSet result = st.executeQuery();

					int tempacc_no = 0;
					int tempamo = 0;

					while (result.next()) {
						tempacc_no = result.getInt("account_no");
						tempamo = result.getInt("loan_amount");

						int temp = tempamo - temp2;

						String query1 = "update loan_details set amount_remain=?  where account_no=?";
						PreparedStatement st1 = con.prepareStatement(query1);

						st1.setInt(1, temp);
						st1.setInt(2, temp1);
						
						st1.executeUpdate();

						String query2 = "select * from loan_details where account_no=?";
						PreparedStatement st2 = con.prepareStatement(query2);
						st2.setInt(1, temp1);
						
						ResultSet result2 = st2.executeQuery();

						ResultSetMetaData r = result2.getMetaData();
						DefaultTableModel model = new DefaultTableModel();
						table.setModel(model); // Set the table model for the JTable
						table.setRowHeight(30);

						table.setPreferredScrollableViewportSize(table.getPreferredSize());

						DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
						renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
						for (int i = 0; i < table.getColumnCount(); i++) {
							table.getColumnModel().getColumn(i).setCellRenderer(renderer);
						}

						int col = r.getColumnCount();
						String[] col_name = new String[col];
						for (int i = 0; i < col; i++) {
							col_name[i] = r.getColumnName(i + 1);
						}

						model.setColumnIdentifiers(col_name);

						while (result2.next()) {

							int id = result2.getInt(1);
							int acc = result2.getInt(2);
							int loan_no = result2.getInt(3);
							Date date = result2.getDate(4);
							int loan_amo = result2.getInt(5);
							int remain_amo = result2.getInt(6);

							Object[] rowData = { id, acc, loan_no, date, loan_amo, remain_amo };
							model.addRow(rowData); // Add data to the table model

						}
						result2.close();
					}

				} catch (SQLException ex) {
					System.out.println(ex);
				}

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(710, 438, 150, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Loan Deposite Section");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(638, 81, 400, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 570, 902, 117);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_4 = new JLabel("Receipt");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_4.setBounds(725, 507, 150, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoanWindow nextWindow = null;
                try {
					nextWindow = new LoanWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(1225, 32, 150, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
