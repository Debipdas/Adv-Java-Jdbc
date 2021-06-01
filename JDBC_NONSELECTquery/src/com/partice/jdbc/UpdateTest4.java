package com.partice.jdbc;
//JDBC APP TO ADD GIVEN PERCENTAGE OF MARKS TO EXUSTING AVG BASED ON THE GIVEN 3 CITY NAMES AS THE ADDRESS FOR STUDENTS.
//TEAM-J
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest4   {

	public static void main(String[] args) {
		Scanner sc=null;
		String city1 = null , city2 = null , city3 = null;
		float percentage=0;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			
			if(sc!=null) {
				System.out.print("Enter percentage ::");
				percentage = sc.nextFloat();sc.nextLine(); //gives percentage
				
				System.out.print("Enter City1::");
				city1 = sc.nextLine().toUpperCase(); //gives city1
				System.out.println();
				System.out.print("Enter city2::");
				city2 = sc.nextLine().toUpperCase();  //gives city2
				System.out.println();
				System.out.print("Enter City3::");
				city3 = sc.nextLine().toUpperCase();  //gives city3
			     System.out.println();
			}
			//convert normal input to SQL query
			city1="'"+city1+"'";
			city2="'"+city2+"'";
			city3="'"+city3+"'";
	
			//register  JDBC driver by loading  JDBC driver class
	        //  Class.forName("oracle.jdbc.drvier.OracleDriver");

			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query
			   
			//UPDATE STUDENT SET AVG=AVG+5 WHERE CITY IN('HYD','CHENNAI','ODISHA');
			  String query="UPDATE STUDENT SET AVG=AVG +"+percentage+" WHERE CITY IN("+city1+","+city2+","+city3+")";
			  System.out.println(query);

			//send and execute SQL query in Db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);

			//process the result
			if(count==0)
				System.out.println("No records found for updation");
			else
				System.out.println("Update sucessfully");
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