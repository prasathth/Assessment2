package com.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import java.sql.PreparedStatement;

public class EmployeeDaoImp implements EmployeeDAO {
	
	Connection con = null ;
	@Override
	public boolean conDatabase() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
			System.out.println("adad");
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	@Override
	public boolean insertEmp(Employee e) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into employee_details values(?,?,?,?)");
			//String name = sc.nextLine();
			//int age = sc.nextInt();
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getRole());
			//ps.setInt(2, age);
			//ps.execute();
			//Statement smt = con.createStatement();
			 ps.execute();
		}
		catch(Exception v)
		{
			System.out.println(v);
			return false;
		}
		return true;
	}

	
	@Override
	public boolean deleteEmp(String i) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from employee_details where username = ?");
			
			ps.setString(1, i);
			
			
			ps.execute();
			
			return true;
			
		}
		catch(Exception v)
		{
			System.out.println(v);
		}
		return false;
	}
	@Override
	public boolean updateEmp(Employee e) {
		
		try {
			System.out.println("Hello" +e.getRole()+e.getUsername());
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("update employee_details set role = ? where username = ?");
			
			ps.setString(1, e.getRole());
			ps.setString(2, e.getUsername());
			
			ps.execute();
			
			return true;
			
		}
		catch(Exception v)
		{
			System.out.println(v);
			System.out.println("h");
		}
		return false;
	}

	@Override
	public boolean isAdmin(Employee e) {
		// TODO Auto-generated method stub
		String username = e.getUsername();
		String password = e.getPassword();
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select role from employee_details where username = ? and password = ?");
			//String name = sc.nextLine();
			ps.setString(1, username);
			ps.setString(2, password);
			//ps.setInt(2, age);
			//ps.execute();
			ResultSet rs = ps.executeQuery();
			rs.next();
			String c = rs.getString("role");
			System.out.println(c);
			if(c.equals("admin"))
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception v)
		{
			System.out.println(v);
		}
		return false;
		/*
		 * if((username.equals("admin")) && password.equals("admin")) { return true; }
		 * else{ return false; }
		 */
		
	}

	@Override
	public ArrayList<Employee> getDetails()
	{
		ArrayList<Employee> a = new ArrayList<Employee>();
		
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from employee_details");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setRole(rs.getString("role"));
				
				a.add(e);
			}
		}
		catch(Exception v)
		{
			System.out.println(v);
		}
		
		return a;
	}
	@Override
	public Employee getByName(String i)
	{
		System.out.println(i);
		Employee e = new Employee();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from employee_details where username = ?");
			
			ps.setString(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				e.setId(rs.getInt("id"));
				e.setUsername(rs.getString("username"));
				e.setRole(rs.getString("role"));
			}

		}
		catch(Exception v)
		{
			System.out.println(v);
		}
		
		return e;
	}
}
