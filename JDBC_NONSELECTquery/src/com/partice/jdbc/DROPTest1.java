package com.partice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DROPTest1 {
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
			String query="DROP TABLE TEMP_TAB";
			System.out.println(query);
			
			//send and execute SQL query
			int count=0;
			if(st!=null)
			count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("DB table successfully DROPED");
			else
				System.out.println(" DB table is not DROPED");
			
			  
		}
		catch(SQLException se) {
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
			
			
		}//finally
	}

}