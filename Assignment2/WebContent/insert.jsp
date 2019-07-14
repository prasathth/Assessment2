<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertServlet" method="post">
<pre>
username <input type="text" name="new_user_name" required><br>
password <input type="password" name="new_password" required><br>
confirm password <input type="password" name="new_confirm_password" required><br>
id <input type="number" name="id" required><br>
role <input type="text" name="role" required><br>

<input type="submit" name="submit" value="register"><br>
</pre>
</form>
</body>
</html>