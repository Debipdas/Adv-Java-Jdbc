package com.jdbc;

//JDBC app that give EMPLOYEE details who having lowest salary.
//Team-java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test9 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// load class
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// Established
			con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe", "SYSTEM", "TIGER");

			// create Statement
			if (con != null)
				st = con.createStatement();
			// prepare SQL query
			// SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP);
			String query = "SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP)";
			System.out.println(query);
	       System.out.println("Employee details who having lowest Salary---");
			// send execute SQL query
			if (st != null)
				rs = st.executeQuery(query);

			// process the request
			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					System.out.println(
							rs.getInt(1) + "  " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getFloat(4));
				} // while

				if (flag == false)
					System.out.println("Records not found");
			} // IF
		} // TRY
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}//finally

	}//main
}//class
