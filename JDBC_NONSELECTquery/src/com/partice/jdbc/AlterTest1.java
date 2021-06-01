package com.partice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlterTest1 {

	
	
	
	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		Statement st=null;
		try {
			scn=new Scanner(System.in);
			String query=null;
			if(scn!=null) {
				System.out.println("Enter query for  drop table in database::");
				query=scn.nextLine().toUpperCase();
			}
			//class load
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish
			con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe","SYSTEM","TIGER");
			
			// create JDBC statement
						if (con!= null)
							st = con.createStatement();

						// send and execute query
						if (st!= null)
							st=con.createStatement();
						
						if (st != null)
							st.executeUpdate(query);

						System.out.println("Table is sucessfully created!!!");
			 
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
			finally {//finally
				
				try {
					if (st != null)
						st.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if (con != null)
						con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
				try {
					if (scn != null)
						scn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}//finally
		
	}//main

}//class


