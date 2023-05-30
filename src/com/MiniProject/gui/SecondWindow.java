package com.MiniProject.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class SecondWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SecondWindow window = new SecondWindow();
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
    public SecondWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1354, 776);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Services");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(627, 91, 200, 40);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Open Account");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpenAccountWindows nextWindow;
                nextWindow = new OpenAccountWindows();
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton.setBounds(491, 221, 175, 30);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Display Accounts");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayAccountsWindow nextWindow = null;
                try {
					nextWindow = new DisplayAccountsWindow();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_1.setBounds(796, 221, 175, 30);
        frame.getContentPane().add(btnNewButton_1);
        
        
        JButton btnNewButton_2 = new JButton("Update Account");
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateAccountWindow nextWindow = null;
                try {
					nextWindow = new UpdateAccountWindow();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_2.setBounds(491, 308, 175, 30);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Delete Account");
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteAccountWindow nextWindow;
                nextWindow = new DeleteAccountWindow();
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_3.setBounds(796, 308, 175, 30);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Withdraw");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WithdrawWindow nextWindow = null;
                nextWindow = new WithdrawWindow();
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_4.setBounds(491, 398, 175, 30);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Deposit");
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DepositeWindow nextWindow = null;
                try {
					nextWindow = new DepositeWindow();
				} 
                catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_5.setBounds(796, 398, 175, 30);
        frame.getContentPane().add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton("Loan");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoanWindow nextWindow = null;
                nextWindow = new LoanWindow();
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_6.setBounds(651, 489, 175, 30);
        frame.getContentPane().add(btnNewButton_6);
        
        JButton btnNewButton_7 = new JButton("Log Out");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainWindow nextWindow = null;
                try {
					nextWindow = new MainWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextWindow.setVisible(true);
				frame.dispose();

            }
        });
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_7.setBounds(1161, 37, 150, 30);
        frame.getContentPane().add(btnNewButton_7);
        
        JPanel panel = new JPanel();
        panel.setBounds(337, 10, 10, 10);
        frame.getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(422, 177, 631, 431);
        frame.getContentPane().add(panel_1);
    }

    public void setVisible(boolean b) {
        JLabel label = new JLabel("This is the second window");
        frame.getContentPane().add(label);
        frame.setVisible(b);
    }
}
