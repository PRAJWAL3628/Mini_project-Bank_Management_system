package com.MiniProject.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DepositeWindow {

	protected static final int ERROR_MESSAGE = 0;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositeWindow window = new DepositeWindow();
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
	public DepositeWindow() throws ClassNotFoundException, SQLException 
	{
		initialize();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1350, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deposite");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(634, 96, 200, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(552, 212, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(552, 283, 150, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(753, 211, 200, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(753, 282, 200, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Deposite");
		btnNewButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	int temp1, temp2;
				temp1 = Integer.parseInt(textField.getText());
				temp2 = Integer.parseInt(textField_1.getText());
				
				try
				{
					String query = "select * from transaction_details where account_no=?";
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
					PreparedStatement st = con.prepareStatement(query);

					st.setInt(1, temp1);

					ResultSet result = st.executeQuery();
					int bal=0, acc_no = 0;
					while (result.next()) 
					{
						acc_no=result.getInt("account_no");
						 bal=result.getInt("balance");
					}
					
					if(temp1==acc_no)
					{
						int temp=bal+temp2;
						
						String query1="update transaction_details set balance=?  where account_no=?";
						PreparedStatement st1=con.prepareStatement(query1);
						
						st1.setInt(1, temp);
						st1.setInt(2, temp1);
						
						int count1 = st1.executeUpdate();
						if(count1>0)
						{
							JFrame frame = new JFrame();
						      frame.setSize(200, 200);
						      frame.setLocationRelativeTo(null);
						      frame.setVisible(true);
						      JOptionPane.showMessageDialog(frame, "Transaction Successfull");
						}
						
					}
					else 
					{
						JOptionPane.showMessageDialog(frame, "Invalid Account_no", "Error",ERROR_MESSAGE );
					}
	                  

				}
				catch (SQLException ex) 
				{
					System.out.println(ex);
				} 


            }
        });
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(619, 361, 175, 30);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(1193, 31, 150, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Receipt");
		btnNewButton_2.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
            	try
            	{
            		int temp1 = Integer.parseInt(textField.getText());
            		String query = "select * from transaction_details where account_no=?";
            		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
                    PreparedStatement st = con.prepareStatement(query);
            		//PreparedStatement st = con.prepareStatement(query);
            		st.setInt(1, temp1);
					ResultSet result2 = st.executeQuery();

					while (result2.next()) 
					{

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


							int id = result2.getInt(1);
  	                        int acc = result2.getInt(2);
  	                        int balance=result2.getInt(3);

							Object[] rowData = { id, acc, balance};
							model.addRow(rowData); // Add data to the table model

						
						result2.close();
					}

            	}
            	
            	catch(Exception e2)
            	{
            		System.out.println(e2);
            	}
            }
        });

		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(619, 431, 175, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 494, 650, 100);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void setVisible(boolean b) {
        JLabel label = new JLabel("This is the second window");
        frame.getContentPane().add(label);
        frame.setVisible(b);
    }
}
