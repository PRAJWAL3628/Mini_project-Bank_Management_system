package com.MiniProject;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class Account_details
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");
        Statement st = con.createStatement();
        
        int count = 0;

        System.out.println("\n					!!!Bank Management system Database!!!					");
        System.out.println("--------------------------------------------------------------------------------------------------------------------\n");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------\n");
            System.out.println("1)Open New Account  \n2)Display all Accounts \n3)Update Account  \n4)Delete Account  \n5)Withdraw Money \n6)Deposite Money \n7)Loan \n8)Exit");
            System.out.println("------------------------------\n");
            System.out.print("Enter your Choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1: {
                    while (true) {
                        System.out.println("#Enter the Details: ");
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Account No: ");
                        int acc_no = sc.nextInt();

                        System.out.print("First Name: ");
                        String fname = sc.next();

                        System.out.print("Middle Name: ");
                        String mname = sc.next();

                        System.out.print("Last Name: ");
                        String lname = sc.next();

                        System.out.print("DOB (YYYY-MM-DD): ");
                        String dobString = sc.next();
                        Date DOB = Date.valueOf(dobString);

                        System.out.print("Age: ");
                        int age = sc.nextInt();

                        System.out.print("Mobile No: ");
                        double mobile_no = sc.nextDouble();

                        System.out.print("Address: ");
                        String address = sc.next();

                        PreparedStatement pst = con.prepareStatement("insert into account_details values(?,?,?,?,?,?,?,?,?)");
                        
                        pst.setInt(1, id);
                        pst.setInt(2, acc_no);
                        pst.setString(3, fname);
                        pst.setString(4, mname);
                        pst.setString(5, lname);
                        pst.setDate(6, DOB);
                        pst.setInt(7, age);
                        pst.setDouble(8, mobile_no);
                        pst.setString(9, address);
                        
                        PreparedStatement pst1 = con.prepareStatement("insert into transaction_details values(?,?,?)");
                        pst1.setInt(1, id);
                        pst1.setInt(2, acc_no);
                        pst1.setInt(3, 0);
                        
                        count = pst.executeUpdate();
                        int count1 = pst1.executeUpdate();
                        if (count > 0 &&  count1>0) 
                        {
                            System.out.println("Data added successfully!");
                        } else {
                            System.out.println("Data not added");
                        }

                        System.out.println("Do you want to add new data? 1:yes 2:no");
                        int ch = sc.nextInt();
                        if (ch != 1) {
                            System.out.println("Exited!!!");
                            break;
                        }
                    }

                }
                break;

                case 2: {
                    /*ResultSet result = st.executeQuery("select * from account_details");

                    System.out.println("					!!!Bank Database: Account Holder Details!!!					");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("ID		Account No		Name			DOB			Age			Mobile No		Address");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
                    while (result.next()) {
                        int id = result.getInt(1);
                        int acc_no = result.getInt(2);
                        String fname = result.getString(3);
                        String mname = result.getString(4);
                        String lname = result.getString(5);
                        Date DOB = result.getDate(6);
                        int age = result.getInt(7);
                        Double mobile_no = result.getDouble(8);
                        String address = result.getString(9);

                        String name = fname + " " + mname + " " + lname;

                        System.out.println(id + " 		" + acc_no + "		" + name + "		" + DOB + "		" + age + "			" + mobile_no + "		" + address);
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                    result.close();
                    
                    */
                	         	
                	
                    /*ResultSet result1 = st.executeQuery("select account_details.id, account_details.account_no, transaction_details.balance, loan_details.loan_amount from account_details left join transaction_details on account_details.id=transaction_details.id left join loan_details on  account_details.id=loan_details.id");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("ID		Account No		Balance		Loan Amount");
                    System.out.println("-----------------------------------------------------------------------------");
                    
                    
                    while(result1.next()) 
                    {
                    	int id=result1.getInt(1);
                    	int acc_no=result1.getInt(2);
                    	int bal=result1.getInt(3);
                    	int amo=result1.getInt(4);
                    	
                    	System.out.println(id + "		" + acc_no + "			" + bal + "		" + amo);
                    }
                    System.out.println("-----------------------------------------------------------------------------");
                    result1.close();
                    */
                	
                
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                }
                break;

                case 3: 
                {
                    Scanner sc2 = new Scanner(System.in);
                    while (true) {
                        System.out.print("Enter Account no you want to Update: ");
                        int acc_no = sc2.nextInt();

                        System.out.println("Enter your choice of what you want to update: ");
                        System.out.println("1)Age  2)Mobile No  3)Address");
                        int ch1 = sc2.nextInt();

                        switch (ch1) 
                        {
                           
                        	case 1: {
                                System.out.println("Enter new Age: ");
                                int age = sc2.nextInt();
                                count = st.executeUpdate("update account_details set age=" + age + " where account_no=" + acc_no);
                            }
                            break;

                            case 2: {
                                System.out.println("Enter new Mobile No: ");
                                Double mob = sc2.nextDouble();
                                count = st.executeUpdate("update account_details set mobile_no=" + mob + " where account_no=" + acc_no);
                            }
                            break;

                            case 3: {
                                System.out.println("Enter new Address: ");
                                String address = sc2.next();
                                count = st.executeUpdate("update account_details set address='" + address + "' where account_no=" + acc_no);
                            }
                            break;

                            default:
                                System.out.println("!!!Invalid Choice");

                        }

                        if (count > 0) {
                            System.out.println("Record updated");
                        } else {
                            System.out.println("No Record updated");
                        }

                        System.out.println("Do you want to update another data? 1:yes 2:no");
                        int ch = sc2.nextInt();
                        if (ch != 1) {
                            System.out.println("Exited!!!");
                            break;
                        }
                    }

                }
                break;

                case 4: 
                {
                    Scanner sc = new Scanner(System.in);
                    while (true) {
                        System.out.print("#Enter Account no of Account you want to delete: ");
                        int acc_no = sc.nextInt();
                        int count1=st.executeUpdate("delete from transaction_details where account_no=" + acc_no);
                        int count2=st.executeUpdate("delete from loan_details where account_no=" + acc_no);
                        
                        count = st.executeUpdate("delete from account_details where account_no=" + acc_no);
                        
                        if (count > 0 && count1>0 && count2>0) {
                            System.out.println("Record deleted");
                        } else {
                            System.out.println("No Record deleted");
                        }

                        System.out.println("Do you want to delete another Records: 1:yes 2:no");
                        int ch = sc.nextInt();
                        if (ch != 1) {
                            System.out.println("Exited!!!");
                            break;
                        }
                    }
                }
                break;
                
                case 5:
                {
                	Scanner sc3=new Scanner(System.in);
            		System.out.print("#Enter Account no of Account: ");
            		int acc_no = sc3.nextInt();
            		System.out.print("Enter the amount you want to Withdraw: ");
            		int amo=sc3.nextInt();
            		
            		String query="select * from transaction_details where account_no=?";
                	PreparedStatement statement=con.prepareStatement(query);
                	statement.setInt(1,  acc_no);
            		
            		ResultSet result=statement.executeQuery();
            		
            		while(result.next())
            		{     		

                        int bal=result.getInt("balance");
                        
                        if(bal<amo)
          				{
          					System.out.println("!!!low Balance\n");
          				}
          				
          				else
          				{
          					int temp=bal-amo;
          					
          					String query1="update transaction_details set balance=?  where account_no=?";
          					PreparedStatement st1=con.prepareStatement(query1);
          					
          					st1.setInt(1, temp);
          					st1.setInt(2, acc_no);
          					
          					int count1 = st1.executeUpdate();
          					if (count1 > 0) 
          					{
          						System.out.println("Withdrawal successfully!!!\n");
          					}
          					else
          					{
          						System.out.println("Withdrawal failed!!!\n");
          					}
          					
          					System.out.println("Do you want receipt of transaction?: 1:yes 2:no ");
          					int ch1=sc3.nextInt();
          					if(ch1==1)
          					{
          						ResultSet result1 = st.executeQuery("select * from transaction_details");

          	                    System.out.println("			!!!Account Holder Transaction Details!!!			");
          	                    System.out.println("----------------------------------------------------------");
          	                    System.out.println("ID		Account No		Balance");
          	                    System.out.println("-----------------------------------------------------------");
          	                    while (result1.next()) 
          	                    {
          	                        int id = result1.getInt(1);
          	                        int acc = result1.getInt(2);
          	                        int balance=result1.getInt(3);
          	                        
          	                      System.out.println(id + " 		" + acc + "		" + balance);
          	                              	                        
          	                    }
          	                    System.out.println("-----------------------------------------------------------");
          	                    result1.close();
          					}
          					
          					
          					System.out.println("Do you want to perform more transactions? 1:yes 2:no");
          					int ch = sc3.nextInt();
          					if (ch != 1) 
          					{
          						System.out.println("Exited!!!");
          						break;
          					}
          					
          				}
                        
                    }
                    result.close();
                }
                break;
                
                case 6:
                {
                	Scanner sc3=new Scanner(System.in);
            		System.out.print("Enter Account no: ");
            		int acc_no = sc3.nextInt();
            		System.out.print("Enter the amount you want to Deposite: ");
            		int amo=sc3.nextInt();
            		
            		String query="select * from transaction_details where account_no=?";
                	PreparedStatement statement=con.prepareStatement(query);
                	statement.setInt(1,  acc_no);
            		
            		ResultSet result=statement.executeQuery();
            		
            		while(result.next())
            		{     		

                        	int bal=result.getInt("balance");
                  
          					int temp=bal+amo;
          					
          					String query1="update transaction_details set balance=?  where account_no=?";
          					PreparedStatement st1=con.prepareStatement(query1);
          					
          					st1.setInt(1, temp);
          					st1.setInt(2, acc_no);
          					
          					int count1 = st1.executeUpdate();
          					if (count1 > 0) 
          					{
          						System.out.println("Amount Deposited successfully!!!\n");
          					}
          					else
          					{
          						System.out.println("Deposit failed!!!\n");
          					}
          					
          					System.out.println("Do you want receipt of transaction?: 1:yes 2:no ");
          					int ch1=sc3.nextInt();
          					if(ch1==1)
          					{
          						ResultSet result1 = st.executeQuery("select * from transaction_details");

          	                    System.out.println("		!!!Account Holder Transaction Details!!!		");
          	                    System.out.println("----------------------------------------------------");
          	                    System.out.println("ID		Account No		Balance");
          	                    System.out.println("----------------------------------------------------");
          	                    while (result1.next()) 
          	                    {
          	                        int id = result1.getInt(1);
          	                        int acc = result1.getInt(2);
          	                        int balance=result1.getInt(3);
          	                        
          	                      System.out.println(id + " 		" + acc + "		" + balance);
          	                              	                        
          	                    }
          	                    System.out.println("-----------------------------------------------------");
          	                    result1.close();
          					}
          					System.out.println("Do you want to perform more transactions? 1:yes 2:no");
          					int ch = sc3.nextInt();
          					if (ch != 1) 
          					{
          						System.out.println("Exited!!!");
          						break;
          					}
          					
                        
                    }
                    result.close();

                }
                break;
                
                case 7:
                {
                	System.out.println("\n				!!!Welcome to Loan Section!!!				");
                	System.out.println("----------------------------------------------------------------------------------------------------------\n");
                	Scanner sc3=new Scanner(System.in);
                	System.out.println("What you want to do?: 1)Issue Loan  2)Deposite loan amount 3)Loan Details");
                	System.out.println("Enter your Choice: ");
                	int ch2=sc3.nextInt();
                	
                	if(ch2==1)
                	{
                		             		
                		System.out.println("#Enter the Details: ");
                        System.out.print("Enter ID: ");
                        int id = sc3.nextInt();

                        System.out.print("Account No: ");
                        int acc_no = sc3.nextInt();
                        
                        System.out.print("Loan No: ");
                        int loan_no = sc3.nextInt();
                        
                        System.out.print("Loan Date (YYYY-MM-DD): ");
                        String dobString = sc3.next();
                        Date date = Date.valueOf(dobString);

                        System.out.println("Loan Amount: ");
                        int amo=sc3.nextInt();
                        
                        PreparedStatement pst = con.prepareStatement("insert into loan_details values(?,?,?,?,?,?)");
                        
                        pst.setInt(1, id);
                        pst.setInt(2, acc_no);
                        pst.setInt(3,  loan_no);
                        pst.setDate(4, date);
                        pst.setInt(5, amo);
                        pst.setInt(6, amo);
                        
                        int count1 = pst.executeUpdate();
                        
                        if (count1 > 0) 
                        {
                            System.out.println("Data added successfully!");
                        } else {
                            System.out.println("Data not added");
                        }

                        
                        System.out.println("Do you want receipt of Loan?: 1:yes 2:no ");
            			int ch1=sc3.nextInt();
            			if(ch1==1)
            			{
            				ResultSet result1 = st.executeQuery("select * from loan_details");
            				
            				System.out.println("				!!!Account Holder Loan Details!!!				");
            				System.out.println("---------------------------------------------------------------------------------");
            				System.out.println("ID		Account No		Loan No		Date	Loan Amount		Remaining Amount");
            				System.out.println("----------------------------------------------------------------------------------");
            				while (result1.next()) 
            				{
            					int Id = result1.getInt(1);
            					int acc = result1.getInt(2);
            					int Loan_no=result1.getInt(3);
            					Date Date=result1.getDate(4);
            					int loan_amo=result1.getInt(5);
            					int remain_amo=result1.getInt(6);
            					
            					System.out.println(Id + " 		" + acc + "			" + Loan_no + "		" + Date + "	" + loan_amo + "	" + remain_amo );
            					
            				}
            				System.out.println("-----------------------------------------------------------------------------------");
            				result1.close();
            			}
                		
                	}
                	
                	else if(ch2==2)
                	{
                		System.out.print("Enter Account no: ");
                		int acc_no = sc3.nextInt();
                		System.out.print("Enter the amount you want to deposite: ");
                		int amo=sc3.nextInt();
                		
                		String query="select * from loan_details where account_no=?";
                		PreparedStatement statement=con.prepareStatement(query);
                		statement.setInt(1,  acc_no);
                		
                		ResultSet result=statement.executeQuery();
                		
                		while(result.next())
                		{     		
                			
                			int bal=result.getInt("loan_amount");
                			
                			int temp=bal-amo;
                			
                			String query1="update loan_details set amount_remain=?  where account_no=?";
                			PreparedStatement st1=con.prepareStatement(query1);
                			
                			st1.setInt(1, temp);
                			st1.setInt(2, acc_no);
                			
                			int count1 = st1.executeUpdate();
                			if (count1 > 0) 
                			{
                				System.out.println("Amount Deposited successfully!!!\n");
                			}
                			else
                			{
                				System.out.println("Deposite failed!!!\n");
                			}
                			
                			System.out.println("Do you want receipt of Loan?: 1:yes 2:no ");
                			int ch1=sc3.nextInt();
                			if(ch1==1)
                			{
                				ResultSet result1 = st.executeQuery("select * from loan_details");
                				
                				System.out.println("				!!!Account Holder Loan Details!!!				");
                				System.out.println("---------------------------------------------------------------------------------");
                				System.out.println("ID		Account No		Loan No		Date	Loan Amount		Remaining Amount");
                				System.out.println("----------------------------------------------------------------------------------");
                				while (result1.next()) 
                				{
                					int id = result1.getInt(1);
                					int acc = result1.getInt(2);
                					int loan_no=result1.getInt(3);
                					Date date=result1.getDate(4);
                					int loan_amo=result1.getInt(5);
                					int remain_amo=result1.getInt(6);
                					
                					System.out.println(id + " 		" + acc + "		" + loan_no + "		" + date + "	" + loan_amo + "		" + remain_amo );
                					
                				}
                				System.out.println("-----------------------------------------------------------------------------------");
                				result1.close();
                			}
                			System.out.println("Do you want to perform more transactions? 1:yes 2:no");
                			int ch = sc3.nextInt();
                			if (ch != 1) 
                			{
                				System.out.println("Exited!!!");
                				break;
                			}
                			
                			
                		}
                	}
                	
                	else if(ch2==3)
                	{
                		
                		Scanner sc4=new Scanner(System.in);
                		System.out.print("#Enter Account no of Account: ");
                		int acc_no = sc4.nextInt();
                		                		
                		String query="select * from loan_details where account_no=?";
                    	PreparedStatement statement=con.prepareStatement(query);
                    	statement.setInt(1,  acc_no);
                    	ResultSet result2=statement.executeQuery();
                    	
        				System.out.println("				!!!Account Holder Loan Details!!!				");
        				System.out.println("---------------------------------------------------------------------------------");
        				System.out.println("ID		Account No		Loan No	   		Date	Loan Amount	   Remaining Amount");
        				System.out.println("----------------------------------------------------------------------------------");
        				while (result2.next()) 
        				{
        					int id = result2.getInt(1);
        					int acc = result2.getInt(2);
        					int loan_no=result2.getInt(3);
        					Date date=result2.getDate(4);
        					int loan_amo=result2.getInt(5);
        					int remain_amo=result2.getInt(6);
        					
        					System.out.println(id + " 		" + acc + "			" + loan_no + "		" + date + "   	 " + loan_amo + "			" + remain_amo );
        					
        				}
        				System.out.println("-----------------------------------------------------------------------------------");
        				result2.close();
                        
                    	
                	}

                }
                break;

                default: {
                    System.out.println("!!!Invalid Choice!!!");
                }
                break;

            }

            System.out.println("\nDo you want to perform another operation? 1:yes 2:no");
            int ch = input.nextInt();
            if (ch != 1) {
                System.out.println("Exited!!!");
                System.out.println("!!!See you Soon");
                break;
            }
        }
        st.close();
        con.close();
    }
}


