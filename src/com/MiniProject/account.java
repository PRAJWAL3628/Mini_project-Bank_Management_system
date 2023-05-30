package com.MiniProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class account {	

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prajwal");

			Statement st = con.createStatement();
			//st.executeUpdate(
				//	"create table account_details(id int not null primary key, account_no int, fname varchar2(20), mname varchar2(20), lname varchar2(20), DOB date, age int, mobile_no number, address varchar2(50))");
			Statement st1 = con.createStatement();
			st1.executeUpdate(
					"create table transaction_details (id int references account_details(id), account_no int, balance int)");
			
			Statement st2 = con.createStatement();
			st2.executeUpdate(
					"create table loan_details (id int references account_details(id), account_no int, loan_no int not null primary key, loan_date date, loan_amount int, amount_remain int)");
			//st.close();
			st1.close();
			st2.close();
			
			/*Statement st3 = con.createStatement();
			st3.executeUpdate("create table login_details (username varchar2(20), password varchar2(20))");
			st3.close();*/
				
			System.out.println("Tables created!!!");
			con.close();

		}

		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}
}
