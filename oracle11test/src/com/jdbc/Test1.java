package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	
		//oracle.jdbc.driver.OracleDriver obj=new Oracle.jdbc.driver.OracleDriver();
		//DriverManager.registerDriver(obj);
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe";
		Connection con = DriverManager.getConnection(url, "SYSTEM","TIGER");
		System.out.println("con object classname:"+con.getClass());
		
		
		if (con==null)
			System.out.println("CONNECTION ERROR");
		else
			System.out.println("CONNECTION DONE");
		
		//create statement
		Statement st=con.createStatement();
		System.out.println("Statament object(st) class name:"+st.getClass());
	
		ResultSet rs=st.executeQuery("select * from student ");
	//PreparedStatement ps=con.prepareStatement("INSERT INTO EMP VALUES(?,?)");
	//ps.setInt(1, 10023);
	//ps.setString(2, "Kingkom");
	
	//ps.executeUpdate();
	//System.out.println("Employee details saved sucessifully!!! ");
	}
}