package com.bean;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
	public boolean loginVerification(String username,String password) {
		try
		{
			//Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "Sapient123");
			Statement smt = con.createStatement();
			//smt.executeUpdate("insert into emp values('virat kohli',25)");
			ResultSet rs = smt.executeQuery("select * from employee_details");
			while(rs.next())
			{
				//System.out.println("your name :"+rs.getString(1));
				//System.out.println("your age :"+rs.getInt("age"));
				if((username.equals(rs.getString("username"))) && (password.equals(rs.getString("password"))))
					return true;
				
			}
			rs.close();
			smt.close();
			//con.close();
			//PreparedStatement ps = con.prepareStatement("insert into emp values(?,?)");
			//String name = sc.nextLine();
			//int age = sc.nextInt();
			//ps.setString(1, name);
			//ps.setInt(2, age);
			//ps.execute();
			
			//ps.close();
			con.close();
			//sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	public boolean userregis(String username,String password,int age,int no) {
		try
		{
			//Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Sapient123");
			//Statement smt = con.createStatement();
			//smt.executeUpdate("insert into emp values('virat kohli',25)");
			//ResultSet rs = smt.executeQuery("select * from user_info");
			//while(rs.next())
			//{
				//System.out.println("your name :"+rs.getString(1));
				//System.out.println("your age :"+rs.getInt("age"));
			//	if((username.equals(rs.getString("username"))) && (password.equals(rs.getString("password"))))
			//		return true;
				
			//}
			//rs.close();
			//smt.close();
			//con.close();
			String name = username;
			String pass = password;
			int ag = age;
			int n = no;
			PreparedStatement ps = con.prepareStatement("insert into user_info values(?,?,?,?)");
			
			//int age = sc.nextInt();
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setInt(3, ag);
			ps.setInt(4, n);
			try
			{
				ps.execute();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			//ps.close();
			//con.close();
			//sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
