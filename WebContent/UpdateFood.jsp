
	<%
String admin=(String)session.getAttribute("username");

	if(admin!=null) {

	
	
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.OutputStream" %>
    <%@page import="in.coder.pojo.*" %>
    <%@page import="java.sql.Blob" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Food</title>
</head>
<center>
<jsp:include page="Header.jsp"></jsp:include>

<body>
<% Food f=(Food)session.getAttribute("food"); %>


<div class="login-card">
<form action="FoodServlet" method="post" enctype="multipart/form-data">
<input type="hidden" name="operation" value="updateFood">

<table border="2">

<tr><td>Food Id</td><td><input type="text" name="fid" value="<%=f.getFoodId()%>" readonly="readonly" class="valid" onblur="clearup(this)"><span></span></td></tr>
<tr><td>Food Name:</td><td><input type="text" name="fName"  value="<%=f.getFoodName()%>" class="valid" onblur="clearup(this)"><span></span></td></tr>
<tr><td>Food Category:</td><td><input type="text" name="fType" value="<%=f.getFoodType()%>"  class="valid" onblur="clearup(this)"><span></span></td></tr>
<tr><td>Food Price:</td><td><input type="text"  name="fPrice"  value="<%=f.getFoodPrice()%>" class="valid" onblur="clearup(this)"><span></span></td></tr>
	
<tr><td>Food Image:</td><td><img src="retrieve.jsp" id="mainimg2" width=130 height=130></td></tr>




<tr><td>Food Image:</td><td><input type="file" name="foodImage"></td></tr>
<tr><td><input type="submit" class="login-button" value="Update Food" onclick="return validate()"></td>
<td><input type="reset" class="login-button" value="Cancel"></td></tr>

</table>
</form></div>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</center>
</html>

<%  } 
	else
	{
		
		response.sendRedirect("Login.jsp");
	}

%>