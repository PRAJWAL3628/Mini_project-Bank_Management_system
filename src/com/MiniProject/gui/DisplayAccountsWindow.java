package com.MiniProject.gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DisplayAccountsWindow 
{

	private JFrame frame;
	private JTable table;

	public static void main(String[] args) throws Exception
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAccountsWindow window = new DisplayAccountsWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DisplayAccountsWindow() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

		frame = new JFrame();
		frame.setBounds(100, 100, 1340, 816);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		JButton btnNewButton = new JButton("Display ");
		btnNewButton.addActionListener(new ActionListener() 
		
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Statement st = con.createStatement();
					ResultSet result = st.executeQuery("select * from account_details");

					ResultSetMetaData r = result.getMetaData();
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model); // Set the table model for the JTable
					table.setRowHeight(20);
								
					
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

					while (result.next()) {
						int id = result.getInt(1);
						int acc_no = result.getInt(2);
						String fname = result.getString(3);
						String mname = result.getString(4);
						String lname = result.getString(5);
						Date DOB = result.getDate(6);
						int age = result.getInt(7);
						//Double mobile_no = result.getDouble(8);
						String mobile_no=result.getString(8);
						String address = result.getString(9);

						//String name = fname + " " + mname + " " + lname;

						Object[] rowData = { id, acc_no, fname, mname, lname, DOB, age, mobile_no, address };
						model.addRow(rowData); // Add data to the table model

						System.out.println(id + " 		" + acc_no + "		" + fname + "		" + mname + "		" + lname+" 		" + DOB + "		" + age
								+ "			" + mobile_no + "		" + address);
					}
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------");
					result.close();

				} 
				catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(718, 93, 175, 30);
		frame.getContentPane().add(btnNewButton);

		JScrollPane Table = new JScrollPane();
		Table.setBounds(112, 146, 1295, 607);
		frame.getContentPane().add(Table);
		
		
		
		table = new JTable();
		Table.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Account Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(689, 31, 300, 30);
		frame.getContentPane().add(lblNewLabel);
		
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
		btnNewButton_1.setBounds(1164, 17, 150, 30);
		frame.getContentPane().add(btnNewButton_1);

	}
	
	public void setVisible(boolean b) {
		JLabel label = new JLabel("This is the second window");
		frame.getContentPane().add(label);
		frame.setVisible(b);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}