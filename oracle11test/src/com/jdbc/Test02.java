package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		//read inputs from enduser
		Scanner sc=null;
		String desg1=null, desg2=null, desg3=null;
		Connection con=null;
	    Statement st=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				
			System.out.print("Enter desg1::");
			desg1=sc.next().toUpperCase();
			System.out.print("Enter desg2::");
			desg2=sc.next().toUpperCase();
			System.out.print("Enter desg3::");
			desg3=sc.next().toUpperCase();
			
			//converts input values as required for Sql query;
	        desg1="'"+desg1+"'";//gives clerk
		    desg2="'"+desg2+"'";//gives 'MANAFER'
		    desg3="'"+desg3+"'";//gives 'SALESMAN'
		    
		    //Load JDBC driver class
		    //Class.forName("oracle.jdbc.driver.OracleDriver");
		    
		    con= DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");

            //create Statement object
		 if(con!=null)
		    
		  st = con.createStatement();
		   //prepare SQL query
		   String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN("+desg1+","+desg2+","+desg3+")ORDER BY JOB";
		   
		    System.out.println(query);
		    
		    //send and execute SQL Query in DB s/w
		    // rs = st.executeQuery(query);
		    if(st!=null)
		    	rs=st.executeQuery(query);
		    if(rs!=null) {
		    	System.out.println("The Emp details are---");
		    	while(rs.next()!=false) {
		    		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
		    		
		    	}//while
	
		
		    }//if
			
			}//try
		}
			catch(SQLException se) {
				se.printStackTrace();//gives details info about raised exception
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			/*finally {
				try {
					if(rs!=null && st!=null && con!=null && sc!=null) {
						rs.close();
						st.close();
						con.close();
						sc.close();
					}
					}//try
					catch(SQLException se) {
						se.printStackTrace();
					}
					catch(Exception e) {
						e.printStackTrace();
					}//finally*/
			finally {
				try {
					if(rs!=null)
						rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
				try {
				if(st!=null)
					st.close();
				}catch(SQLException se) {
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
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
	}
}
	



// cmd>javac -d.Test02.java
// cmd>java com.jdbc.Test02
