<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.println("dear"+" "+session.getAttribute("name")+" "+"logined successfully");
%>

<br>
<a href="checkBalance">check balance</a>
<br>

<br>
<a href="changePassword.jsp">Change password</a>
<br>

<br>
<a href="transfer.jsp">Transfer balance</a>
<br>

<br>
<a href="Getstatement">get statement</a>
<br>

<br>
<a href="loan.jsp">apply loan</a>
<br>

<br>
<a href="Logout">logout</a>
<br>
</body>
</html>