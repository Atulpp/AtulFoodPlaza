	<%
String admin=(String)session.getAttribute("username");

	if(admin!=null) {

	
	
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="in.coder.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
	<%
		Customer c = (Customer) session.getAttribute("customer");
	%>
	<div class="login-card">
	<form action="CustServlet" method="post">
		<input type="hidden" name="operation" value="updateCust">
		<table border="2">
		
			<tr>
				<td>Customer Id</td>
				<td><input type="text" name="cid" value="<%=c.getCustId()%>"
					readonly="readonly" class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Customer Name:</td>
				<td><input type="text" name="cName"
					value="<%=c.getCustName()%>" class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Customer Add:</td>
				<td><input type="text" name="cAdd" value="<%=c.getCustAdd()%>"
					class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Customer Age:</td>
				<td><input type="text" name="cCon" value="<%=c.getCustCon()%>"
					class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Customer Email:</td>
				<td><input type="text" name="cEmail"
					value="<%=c.getCustEmail()%>" class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Customer Password:</td>
				<td><input type="text" name="cPass"
					value="<%=c.getCustPass()%>" class="valid" onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td><input type="submit" class="login-button" value="Update Customer"
					onclick="return validate()"></td>
				<td><input type="reset" class="login-button" value="Cancel"></td>
			</tr>

		</table>
	</form></div>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>

<%  } 
	else
	{
		
		response.sendRedirect("Login.jsp");
	}

%>