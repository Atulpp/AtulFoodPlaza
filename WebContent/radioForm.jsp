<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.OutputStream" %>
    <%@page import="in.coder.pojo.*" %>
    <%@page import="java.sql.Blob" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Feedback</title>
</head>
<center>
<jsp:include page="Header.jsp"></jsp:include>

<body>

<div class="login-card">
<form method="post" action="FeedBackServlet">
<table>
<tr>
			<td>Name: (optional)</td>
			<td><input type="text" name="username"></td>
		</tr>
<tr>
			<td>E-mail:  (optional)</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
		<td>Food Quality:-</td>
		<td >
		<input type="radio" name="type" value="Excellent" >Excellent
			<input type="radio" name="type" value="Good" >Good
			<input type="radio" name="type" value="Average" >Average
			<input type="radio" name="type" value="Disatisfied" >Disatisfied
		</td>
		
		
		</tr>
		<tr>
			<td>Any comments, questions or suggestions? </td>
			<td><input type="text" name="question"></td>
		</tr>



<tr><td><input type="Submit" class="login-button" value="Submit"></td></tr>
</table>
</form>
</div>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</center>
</html>