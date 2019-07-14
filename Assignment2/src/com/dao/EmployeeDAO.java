package com.dao;

import java.util.ArrayList;

import com.bean.Employee;

public interface EmployeeDAO {

	public boolean insertEmp(Employee e);
	public boolean deleteEmp(String s);
	public boolean updateEmp(Employee e);
	public boolean isAdmin(Employee e);
	public boolean conDatabase();
	public ArrayList<Employee> getDetails();
	public Employee getByName(String i);
}
