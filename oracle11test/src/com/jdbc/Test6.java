package com.jdbc;
//jdbc app that gives employe details from emp db tables based on their initial char of ename;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
    Scanner scn=null;
    String ch=null;
    Connection con=null;
    Statement st=null;
	ResultSet rs=null;
	try {
		scn=new Scanner(System.in);
		if(scn!=null) {
			System.out.print("Enter the first char of Employee's name-- ");
			ch=scn.next().toUpperCase();
			System.out.println();
				}//if
		ch="'"+ch+"%'";//convert to SQL query
		//register  JDBC driver by loading  JDBC driver class
        //  Class.forName("oracle.jdbc.drvier.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-DRTQSH7:1522:xe","SYSTEM","TIGER");
		
		if(con!=null)
			st=con.createStatement();
		//SQL> SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE 'S%';
		String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE " +ch+ "";
		System.out.println(query);
		if(st!=null)
			rs=st.executeQuery(query);
		if(rs!=null) {
			System.out.println();
			System.out.println("The Employees details are-----------");
			System.out.println("EMPNO  ENAME  JOB     SAL     DEPTNO");
			System.out.println("-----  -----  ---     ---     ------");
		 // int count=0;
		 // count++;
			boolean flag=false;//check record is available or not
			
			while(rs.next()) {
				flag=true;//when record not found then display message.
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"    "+rs.getFloat(4)+"   "+rs.getInt(5));
			//if(count==0)
			
		
		}
			if(flag==false)//when record not found, then print below message.
				System.out.println("Sorry no record found");
	}
	
	}catch(SQLException se) {
		if(se.getErrorCode()>900 || se.getErrorCode()<909)//for SQL query error
			System.out.println("Error in SQL query");
		se.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
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
		}catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(scn!=null)
				scn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}

}