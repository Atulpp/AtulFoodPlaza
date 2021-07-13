<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
String admin=(String)session.getAttribute("username");

	if(admin!=null) {

	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding Food</title>
</head>
<body>
<center>
<jsp:include page="Header.jsp"></jsp:include>

	<script>
		function validate() {
			var x = document.getElementsByClassName("valid");
			var count = 0;

			if (x[2].value < 20) {

				x[2].nextElementSibling.innerHTML = "Price must be greater than 20";
				x[2].nextElementSibling.style.color = "red";
				count++;
			}
			for (var i = 0; i < x.length; i++) {
				if (x[i].value == "") {
					x[i].nextElementSibling.innerHTML = "Field cant be empty";
					x[i].nextElementSibling.style.color = "red";
					count++;
				}

			}
			if (isNaN(x[2].value)) {

				x[2].nextElementSibling.innerHTML = "Price Must Be Number";
				x[2].nextElementSibling.style.color = "red";
				count++;
			}

			if (count > 0)
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
	<form action="FoodServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" name="operation" value="addFood">
		<table>
			<tr>
				<td>Food Name:</td>
				<td><input type="text" name="fName" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Food Category:</td>
				<td><input type="text" name="fType" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Food Price:</td>
				<td><input type="text" name="fPrice" class="valid"
					onblur="clearup(this)"><span></span></td>
			</tr>
			<tr>
				<td>Food Image:</td>
				<td><input type="file" name="foodImage" 
					onblur="clearup(this)"><span></span></td>
			</tr>

			<tr>
				<td><input type="submit" class="login-button" value="Add Food"
					onclick="return validate()"></td>
				<td><input type="reset" class="login-button" value="Cancel"></td>
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