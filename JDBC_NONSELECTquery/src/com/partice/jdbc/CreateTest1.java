package com.partice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTest1 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			//load JDBC driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe","SYSTEM","TIGER");
			
			//create jdbc statement object
			if(con!=null)
				st=con.createStatement();
			
			//prepared SQL query
			//DROP TABLE STUD;
			String query="CREATE TABLE TEMP_TAB(ID INT PRIMARY KEY,SNAME VARCHAR2(10))";
			System.out.println(query);
			
			//send and execute SQL query
			int count=0;
			if(st!=null)
			count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("db table successfully CREATED");
			else
				System.out.println(" DB table is not CREATED");
			
			  
		}
		catch(SQLException se) {
			se.printStackTrace();
			if(se.getErrorCode()==955)
				System.out.println("DB table is already created");
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
			
			
		}//finally
	}

}