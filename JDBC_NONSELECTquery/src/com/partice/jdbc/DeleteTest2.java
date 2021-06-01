package com.partice.jdbc;
//JDBC APP TO DELETE STUDENT DB TABLE RECORD BASED ON THE GIVEN STUDENT ID.
//TEAM-JAVA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest2 {

	public static void main(String[] args) {

		Scanner scn = null;
		Connection con = null;
		Statement st = null;
		try {
			// read inputs
			scn = new Scanner(System.in);
			int Id = 0;
			if (scn != null) {
				System.out.println("Enter Student Id:::");
				Id = scn.nextInt();// gives input
			}

			// load jdbc driver
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");

			// create statement object
			if (con != null)
				st = con.createStatement();

			// create SQL query
			String query = "DELETE FROM STUDENT WHERE ID=" + Id;
			System.out.println(query);

			int count = 0;

			if (st != null)
				count = st.executeUpdate(query);

			if (count == 0)
				System.out.println("No Records found to delete");
			else
				System.out.println("no.of records that are effected ::" + count);
		} // try
		catch (SQLException se) {
			if (se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Invalid col names or table names or SQL keywords");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs

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

		} // finally
	}// main
}// class
