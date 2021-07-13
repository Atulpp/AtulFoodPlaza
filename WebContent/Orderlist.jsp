<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.io.OutputStream" %>
    <%@page import="in.coder.pojo.*" %>
    <%@page import="java.sql.Blob" %>
    <%@page import="java.util.*,in.coder.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order List</title>

</head>
<body>

<center>
<jsp:include page="Header.jsp"></jsp:include>



<%   List<Ordero> olist=(List<Ordero>)session.getAttribute("orderlist"); %>



<form >

<table border="4" padding="2" class="responstable">
<tr>
<th>Order Id</th>
<th>Email</th>
<th>Total Bill</th>
<th>Date</th>
<th>Status</th>
</tr>
<% 
for(Ordero o:olist) {
	%>
	<tr>
	
	<td >
	
	<%=o.getOrder_id() %></td>
	<td><%=o.getCustEmail() %></td>
	<td><%=o.getTotal_bill() %></td>
	<td><%=o.getDate() %></td>
	<td><%=o.getStatus() %></td>

	
	
	
		<% }%>
		
</tr>

</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>