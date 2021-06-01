package com.partice.jdbc;
//JDBC APP TO INSERT STUDENT DETAILS INTO STUDENT DB TABLE.\
//TEAM-JAVA

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest1 {

	public static void main(String[] args) {

		Scanner scn=null;
		String NAME=null,CITY=null; 
		Connection con=null;
		Statement st=null;
		try {
			scn=new Scanner(System.in);
			int ID=0;
			float AVG=0.0f;
			if(scn!=null) {
				System.out.println("Enter Student Id::");
				ID=scn.nextInt();				
				System.out.println("Enter Student name::");
				NAME=scn.next().toUpperCase();
				
				System.out.println("Enter Student Address::");
				CITY=scn.next().toUpperCase();
				
				System.out.println("Enter Student percentage::");
				AVG=scn.nextFloat();
				
				
			}
			//convert normal to SQL query
			NAME="'"+NAME+"'";
			CITY="'"+CITY+"'";
				
		
		//oracle.jdbc.driver.OracleDriver obj=new Oracle.jdbc.driver.OracleDriver();
		//DriverManager.registerDriver(obj);
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe";
	    con = DriverManager.getConnection(url, "SYSTEM","TIGER");
	    
	    //CREATE STATEMENT OBJECT
	    if(con!=null)
	    	st=con.createStatement();
	    
	    String query="INSERT INTO STUDENT1 VALUES("+ID+","+NAME+","+CITY+","+AVG+")";
	    System.out.println(query);
	    
	    //send execute SQL query in db 
	    int count=0;
	    if(st!=null)
	    	count=st.executeUpdate(query);
	    
	    //process the Result
	    if(count==0)
	    	System.out.println("Record not inserted");
	    else
	    	System.out.println("Record sucessfully insterted");
		
		}catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Invalid col names or table names or SQL keywords");
			else if(se.getErrorCode()==12899)
				System.out.println("Do not insert more than col size data ");
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
				if(scn!=null)
					scn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
	}

	}
}


