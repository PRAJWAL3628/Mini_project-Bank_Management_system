package com.MiniProject.gui;

import java.util.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class OpenAccountWindows 
{
	
	private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    //private final Action action = new SwingAction();
    private Connection con;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OpenAccountWindows window = new OpenAccountWindows();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public OpenAccountWindows() {
        try {
            initialize();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Open Account");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(622, 49, 300, 50);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Account ID :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(421, 202, 100, 30);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(531, 202, 150, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Account No :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(753, 207, 100, 20);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Fname :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(421, 277, 75, 20);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Mname :");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(753, 277, 75, 20);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Lname :");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_5.setBounds(421, 351, 75, 30);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("DOB(YYYY-MM-DD) :");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_6.setBounds(753, 351, 175, 30);
        frame.getContentPane().add(lblNewLabel_6);

        textField_1 = new JTextField();
        textField_1.setBounds(906, 205, 150, 30);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_2.setBounds(531, 272, 150, 30);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_3.setBounds(906, 272, 150, 30);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_4.setBounds(531, 351, 150, 30);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_5.setBounds(906, 351, 150, 30);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Age :");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_7.setBounds(421, 426, 50, 30);
        frame.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Mobile No:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_8.setBounds(753, 426, 100, 30);
        frame.getContentPane().add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Address :");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_9.setBounds(599, 498, 100, 30);
        frame.getContentPane().add(lblNewLabel_9);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_6.setBounds(531, 426, 150, 30);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_7.setBounds(906, 426, 150, 30);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_8.setBounds(694, 498, 300, 30);
        frame.getContentPane().add(textField_8);
        textField_8.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                int id = Integer.parseInt(textField.getText());
                int acc_no = Integer.parseInt(textField_1.getText());
                String fname = textField_2.getText();
                String mname = textField_3.getText();
                String lname = textField_4.getText();
                String dob = textField_5.getText();
                Date DOB = Date.valueOf(dob);
                int age = Integer.parseInt(textField_6.getText());
               // Double mobile_no = Double.parseDouble(textField_7.getText());
                String mobile_no=textField_7.getText();
                String address = textField_8.getText();

                try 
                {
                			
                    PreparedStatement pst = con.prepareStatement(
                            "insert into account_details values(?,?,?,?,?,?,?,?,?)");
                    pst.setInt(1, id);
                    pst.setInt(2, acc_no);
                    pst.setString(3, fname);
                    pst.setString(4, mname);
                    pst.setString(5, lname);
                    pst.setDate(6, DOB);
                    pst.setInt(7, age);
                    pst.setString(8, mobile_no);
                    pst.setString(9, address);
                    //int count1=pst.executeUpdate();

                    PreparedStatement pst1 = con.prepareStatement(
                            "insert into transaction_details values(?,?,?)");
                    pst1.setInt(1, id);
                    pst1.setInt(2, acc_no);
                    pst1.setInt(3, 0);
                    //int count=pst1.executeUpdate();
                    
//                    pst.close();
//                    pst1.close();
                    //con.close();
                    
                    
                    if( mobile_no.matches("^[0-9]*$") && mobile_no.length()==10)
                    {
                    	int count1=pst.executeUpdate();
                    	int count=pst1.executeUpdate();
                    	
                    	if (count > 0 &&  count1>0 ) 
                        {
                        	JFrame frame = new JFrame();
    						frame.setSize(200, 200);
    						frame.setLocationRelativeTo(null);
    						frame.setVisible(true);
    						JOptionPane.showMessageDialog(frame, "Account Opened Successfully!!!");
                        } 
                        else 
                        {
                            System.out.println("Data not added");
                        }
                    	 pst.close();
                         pst1.close();
                         con.close();
                    }
                    
                    else
                    {
                    	JOptionPane.showMessageDialog(frame, "Invalid Mobile No", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                  
                    /*if (count > 0 &&  count1>0 && mobile_no.matches("^[0-9]*$") && mobile_no.length()==10) 
                    {
                    	JFrame frame = new JFrame();
						frame.setSize(200, 200);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Account Opened Successfully!!!");
                    } 
                    else 
                    {
                        System.out.println("Data not added");
                    }*/
                    
                   
                    
                } 
                catch (SQLException e1) 
                {
                    e1.printStackTrace();
                }
                
                

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBounds(678, 592, 150, 30);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Exit");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(1228, 29, 150, 30);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SecondWindow nextWindow = null;
                nextWindow = new SecondWindow();
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        frame.getContentPane().add(btnNewButton_1);
        
        JPanel panel = new JPanel();
        panel.setBounds(342, 115, 799, 523);
        frame.getContentPane().add(panel);
        frame.setBounds(100, 100, 1351, 773);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
