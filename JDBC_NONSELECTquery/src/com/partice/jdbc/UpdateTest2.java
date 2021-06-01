package com.partice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String newCity=null,newName=null;
			float newAvg=0.0f;
			int no=0;
			if(sc!=null) {
				System.out.println("Enter new name for student ::");
				newName=sc.nextLine(); //gives anil rao
				System.out.println("Enter new address for student ::");
				newCity=sc.nextLine(); //gives navi mumbai
				System.out.println("Enter new avg for student ::");
				newAvg=sc.nextFloat(); //gives 89.66
				System.out.println("Enter Id of student ::");
				no=sc.nextInt(); //gives 1003
			}
			///conver input values as required for the SQL query
			newName="'"+newName+"'"; //gives 'ani rao'
			newCity="'"+newCity+"'";  //gives 'navi mumbai'

			//register  JDBC driver by loading  JDBC driver class
	        //  Class.forName("oracle.jdbc.drvier.OracleDriver");

			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query
			    //update  student set sname='anil rao' ,sadd='navi mumbai' ,avg=91.55 where sno=1003;
			//UPDATE EMP SET SAL=SAL * 2 WHERE SAL>=500 AND SAL<=800;
			  String query="update  student set name="+newName+" ,city="+newCity+" ,avg="+newAvg+" where id="+no;
			  System.out.println(query);

			//send and execute SQL query in Db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);

			//process the result
			if(count==0)
				System.out.println("No records found for updation");
			else
				System.out.println("no.of records that are effected ::"+count);
		}//try
		catch (SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Invalid col names or table names or SQL keywords");
			else  if(se.getErrorCode()==12899)
				System.out.println("Do not insert more than col size data to sname,sadd cols");

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