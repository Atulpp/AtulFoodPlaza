<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,in.coder.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer list</title>
</head>
<body>
<center>
<jsp:include page="Header.jsp"></jsp:include>


<%   List<Customer> clist=(List<Customer>)session.getAttribute("custlist"); %>
<form >
<table border="4" padding="2" class="responstable">
<tr>
<th>Customer Id</th>
<th>Customer Name</th>
<th>Customer Add</th>
<th>Customer Age</th>
<th>Customer Email</th>
<th>Customer Pass</th>
</tr>
<% 
for(Customer c:clist) {
	%>
	<tr>
	<td><%=c.getCustId() %></td>
	<td><%=c.getCustName() %></td>
	<td><%=c.getCustAdd() %></td>
	<td><%=c.getCustCon() %></td>
	<td><%=c.getCustEmail() %></td>
		<td><%=c.getCustPass() %></td>
	<td>
	<a href="CustServlet?operation=update&cid=<%=c.getCustId()%>">Update</a>/
	<a href="CustServlet?operation=delete&cid=<%=c.getCustId()%>">Delete</a></td>
	</tr>
	<% 
}
%>

</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>