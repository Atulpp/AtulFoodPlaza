	<%
String admin=(String)session.getAttribute("username");

	if(admin!=null) {

	
	
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>

<body>
<%  %>
<center>
<jsp:include page="Header.jsp"></jsp:include>

	<script>
		function validate() {

			var x=document.getElementsByClassName("valid");
			var count=0;

			for(var i=0;i<x.length;i++)
				{
				if(x[i].value=="")
					{
					x[i].nextElementSibling.innerHTML="Field cant be empty";
					x[i].nextElementSibling.style.color="red";
					count++;
					}
				
				}

			if (x[3].value != x[2].value) {

				x[2].nextElementSibling.innerHTML = "Both password are not same";
				x[2].nextElementSibling.style.color = "red";
				count++;
			}
			

			
			if(count>0)
				return false;
			else
				return true;

		}

		function clearup(a) {
			if (a.value != "") {
				a.nextElementSibling.innerHTML = "";
			}
		}
	</script>
	<div class="login-card">
	<form action="LoginServlet" method="post">
		<input type="hidden" name="operation" value="changepassword">
		<table>
			<tr>
				<td>AdminName</td>
				<td><input type="text" name="username" value="<%= session.getAttribute("username") %>" readonly="readonly" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>old Password</td>
				<td><input type="text" name="password" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="text" name="npassword" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="text" name="nnpassword" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td><input type="submit" class="login-button" onclick="return validate()"
					value="Change Password"></td>
		
			
				<td><input type="reset" class="login-button" value="Clear"></td>
				</tr>


		</table>

	</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>

<%  } 
	else
	{
		
		response.sendRedirect("Login.jsp");
	}

%>