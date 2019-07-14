package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.dao.EmployeeDAO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("5555555");
		ApplicationContext ct = new ClassPathXmlApplicationContext("Beans.xml");
    	EmployeeDAO obj = (EmployeeDAO) ct.getBean("emp");
    	
    	String username = request.getParameter("username");
    	int id = Integer.parseInt(request.getParameter("id"));
    	String pass = request.getParameter("pass");
    	String role = request.getParameter("role");
    	
    	
    	PrintWriter out = response.getWriter();
		System.out.println("5555555"+username);
    	Employee e = new Employee();
    	e.setId(id);
    	e.setRole(role);
    	e.setUsername(username);
    	e.setPassword(pass);
    	
    	if(obj.updateEmp(e))
    	{
    		out.println("Success update");
    	}
    	else
    	{
    		out.println("Failed to updat");
    	}
	}

}
