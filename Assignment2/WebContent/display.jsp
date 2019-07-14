<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="org.springframework.context.ApplicationContext"
 import="org.springframework.context.support.ClassPathXmlApplicationContext"
 import="com.bean.Employee"
 import="com.dao.EmployeeDAO"
 import="java.util.ArrayList"
 %>
<% 
ApplicationContext ct = new ClassPathXmlApplicationContext("Beans.xml");
EmployeeDAO obj = (EmployeeDAO) ct.getBean("emp");
ArrayList<Employee> emp = new ArrayList<Employee>();
emp = obj.getDetails();

%>

<%
out.println("id   username   role");
%><br><br>
<%
for(Employee e : emp)
	{
	out.println(e.getId()+"\t"+e.getUsername()+"\t"+e.getRole()+"\n");

%><br><%		
	}
%>


</body>
</html>