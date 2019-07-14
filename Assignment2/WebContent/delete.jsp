<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
<input type="text" name="username">
<input type="submit" value="search">
</form>
<%@page import="org.springframework.context.ApplicationContext"
 import="org.springframework.context.support.ClassPathXmlApplicationContext"
 import="com.bean.Employee"
 import="com.dao.EmployeeDAO"
 import="java.util.ArrayList"
 import="java.util.*"
 %>
<%  
ApplicationContext ct = new ClassPathXmlApplicationContext("Beans.xml");
EmployeeDAO obj = (EmployeeDAO) ct.getBean("emp");
String i = request.getParameter("username");
//int c = Integer.parseInt(request.getParameter("id");
Employee e = new Employee();
e = obj.getByName(i);
//out.println("id "+e.getId());
%>

<input type="text" value="<%=e.getUsername() %>" readonly><br>
<input type="text" value="<%=e.getId() %>" readonly><br>
<input type="text" value="<%=e.getRole() %>" readonly>
<br>
<form action="del" method="post">
<input type="hidden" name="username" value="<%= request.getParameter("username") %>">
<input type="submit" value="erase">
</form>
</body>
</html>