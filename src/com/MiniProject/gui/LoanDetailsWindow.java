package com.MiniProject.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class LoanDetailsWindow {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanDetailsWindow window = new LoanDetailsWindow();
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
	public LoanDetailsWindow() throws ClassNotFoundException, SQLException 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		frame = new JFrame();
		frame.setBounds(100, 100, 1362, 753);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() 
		
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Statement st = con1.createStatement();
					ResultSet result2 = st.executeQuery("select * from loan_details");

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
        					int loan_no=result2.getInt(3);
        					Date date=result2.getDate(4);
        					int loan_amo=result2.getInt(5);
        					int remain_amo=result2.getInt(6);
        					

						Object[] rowData = { id, acc, loan_no, date, loan_amo, remain_amo };
						model.addRow(rowData); // Add data to the table model

					}
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------");
					result2.close();

				} 
				catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(729, 30, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 88, 1097, 593);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("Exit");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(1203, 17, 150, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}

	public void setVisible(boolean b) {
        JLabel label = new JLabel("This is the second window");
        frame.getContentPane().add(label);
        frame.setVisible(b);
    }
}
