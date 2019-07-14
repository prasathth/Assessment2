package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.dao.EmployeeDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee e = new Employee();
		e.setUsername(username);
		e.setPassword(password);
		
		ApplicationContext ct = new ClassPathXmlApplicationContext("Beans.xml");
    	EmployeeDAO obj = (EmployeeDAO) ct.getBean("emp");
		//Object obj = ct.getBean("emp");
    	PrintWriter out = response.getWriter();
    	if(obj.isAdmin(e))
    	{
    		out.println("Logged in "+username);
    		RequestDispatcher rd = request.getRequestDispatcher("AdminLog.html");
			rd.include(request, response);
    	}
    	else
    	{
    		out.println("fail to login Retry");
    		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
    	}
		
	}

}
