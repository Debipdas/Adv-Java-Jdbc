package com.partice.jdbc;
//JDBC APP TO HIKE EMP SALARY BY GIVEN PERCENTAGE FOR THE EMPLOYESS WHOSE SAL IS IN THE GIVEN RANGE.
//TEAM - JAVA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest3 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			float StartRange=0;
			float EndRange=0;
			float Input=0;
			if(sc!=null) {
				System.out.println("Enter percentage value to hike emp salary::");
				Input=sc.nextFloat(); //gives percentage
				System.out.println("Enter Start range of Employee salary ::");
				StartRange=sc.nextFloat(); //gives Start Range sal
				System.out.println("Enter  End range  of Employee salary ::");
				EndRange=sc.nextFloat(); //gives End Range sal
				
			}
	
			//register  JDBC driver by loading  JDBC driver class
	        //  Class.forName("oracle.jdbc.drvier.OracleDriver");

			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query
			   
			//UPDATE EMP SET SAL=SAL +(SAL*2/100) WHERE SAL>=500 AND SAL<=800;
			  String query="UPDATE EMP SET SAL=SAL+(SAL *"+Input+"/100) WHERE SAL >="+StartRange+"AND SAL <="+EndRange;
			  System.out.println(query);

			//send and execute SQL query in Db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);

			//process the result
			if(count==0)
				System.out.println("No records found for updation");
			else
				System.out.println("EMP TABLE UPDATE SUCESSFULLY.");
				System.out.println("no.of records that are effected ::"+count);
		}//try
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs

			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}

			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}

			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}//finally
	}//main
}//class