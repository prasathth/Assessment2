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


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("new_user_name");
		String password = request.getParameter("new_password");
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String role = request.getParameter("role");
		
		Employee e = new Employee();
		e.setUsername(username);
		e.setPassword(password);
		e.setId(id);
		e.setRole(role);
		
		ApplicationContext ct = new ClassPathXmlApplicationContext("Beans.xml");
    	EmployeeDAO obj = (EmployeeDAO) ct.getBean("emp");
    	
    	PrintWriter out = response.getWriter();
    	out.print(username);
    	if(obj.insertEmp(e))
    	{
    		out.println("Success insertion");
    	}
    	else
    	{
    		out.println("Failed insertion");
    	}
	}

}
