<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<center>
<jsp:include page="Header.jsp"></jsp:include>
<% String status=(String)request.getAttribute("wrong");
if(status!=null){
	
	out.write(status);
}
%>
<div class="login">
 <h1 class="login-title">Login Here</h1>
	<form action="progress.jsp" method="post">
	<input type="hidden" name="operation" value="login">
	
	
	
			Select Type:
			<input type="radio" name="type" value="user" checked="checked">User
			<input type="radio" name="type" value="admin" >Admin
		<br><br>
			Email ID:
			<input type="text" class="login-input" name="username" required>
		Password:
			<input type="password" class="login-input" name="password" required>
		<input type="submit" class="login-button" value="Login">
	
		
	</form>
	
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	</center>
</body>
</html>