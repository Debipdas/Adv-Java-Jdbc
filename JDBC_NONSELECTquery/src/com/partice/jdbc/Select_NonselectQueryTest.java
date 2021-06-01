package com.partice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_NonselectQueryTest {

	public static void main(String[] args) {

		Scanner scn = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			scn = new Scanner(System.in);
			int no = 0;
			String query = null;
			if (scn != null) {// read inputs
				
				System.out.println("Enter Select or NonSelect query::");
				query = scn.nextLine().toUpperCase();
			}
			// class load
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish

			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");

			// create JDBC statement
			if (con!= null)
				st = con.createStatement();

			// send and execute query
			if (st!= null) {
				boolean flag = st.execute(query);
				if (flag == true) {
					System.out.println("SELECT query is executed");

					// process result
					rs = st.getResultSet();

					// process resultset obj
					if (rs != null) {
						while (rs.next()) {
							System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
									+ rs.getString(4));
						} // WHILE

					} // IF
				} // IF
				else {
					System.out.println("NON SELECT query is qxecuted");
					int count = st.getUpdateCount();
					System.out.println("No of recorde that are effected " + count);
				} // else

			} // if

		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
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
