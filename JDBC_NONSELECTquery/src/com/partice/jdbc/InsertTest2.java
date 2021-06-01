package com.partice.jdbc;
//JDBC APP TO INSERT DATA INTO EMP DB TABLE ONLY 4 COLUMNS(ENO,ENAME,JOB,SAL).
//TEAM-JAVA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {

		Scanner scn=null;
		String ENAME=null,JOB=null; 
		Connection con=null;
		Statement st=null;
		try {
			scn=new Scanner(System.in);
			int ENO=0;
			float SALARY=0.0f;
			if(scn!=null) {
				
				System.out.print("Enter Emp no::          ");
				ENO=scn.nextInt();
				scn.nextLine();
				System.out.print("Enter Emp name::        ");
				ENAME=scn.next().toUpperCase();
				
				System.out.print("Enter Emp job position::");
				JOB=scn.next().toUpperCase();
				
				System.out.print("Enter Emp Salary::      ");
				SALARY=scn.nextFloat();
				
				
			}
			//convert normal to SQL query
			ENAME="'"+ENAME+"'";
			JOB="'"+JOB+"'";
				
		
		//oracle.jdbc.driver.OracleDriver obj=new Oracle.jdbc.driver.OracleDriver();
		//DriverManager.registerDriver(obj);
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe";
	    con = DriverManager.getConnection(url, "SYSTEM","TIGER");
	    
	    //CREATE STATEMENT OBJECT
	    if(con!=null)
	    	st=con.createStatement();
	    //insert into emp ( empno,ename,job,sal) values(101,'ram','manager',6000);
	    String query="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL) VALUES("+ENO+","+ENAME+","+JOB+","+SALARY+")";
	    System.out.println(query);
	    
	    //send execute SQL query in db 
	    int count=0;
	    if(st!=null)
	    	count=st.executeUpdate(query);
	    
	    //process the Result
	    if(count==0)
	    	System.out.println("Record not inserted");
	    else
	    	System.out.println("Record sucessfully insterted.    Data sucessfully stored in EMP table!!");
	   
		
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
			
			
	}//finally

	}//main
}//class




