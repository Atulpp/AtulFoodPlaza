<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.*,in.coder.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<script>

</script>
</head>

<jsp:include page="Header.jsp"></jsp:include>
<body>
<center>
<% String status=(String)request.getAttribute("order");
if(status!=null){
	
	out.write(status);
}
%>
</center>
<%   List<Cart> ctlist=(List<Cart>)session.getAttribute("cartList"); %>
<div class="login-card">
<form action="OrderServlet" method="post">
<table border="4" padding="2">
<tr>
<th>CartId</th>
<th>Food Name</th>
<th>Food Price</th>
<th>Food Quantity</th>
</tr>
<% 
for(Cart ct:ctlist) {
	%>
	<tr>
	<td><%=ct.getCartId() %></td>
	<td><%=ct.getFoodName() %></td>
		<td><input type="text" name="foodPrice" readonly="readonly" value="<%=ct.getFoodPrice() %>"> </td>
	<td><input type="number" min="1" name="foodQty" value="<%=ct.getFoodQty() %>"></td>
	
	
<td>
	<a href="CartServlet?operation=delete&cartId=<%=ct.getCartId()%>"> <img src="images/delete.PNG" alt="Delete" height="50px" width="60px"></a></td>
	
	</tr>
	
		<% 
}
%></tr>
</table>
<input type="submit" value="Place Order" class="login-button" onclick="return validate()">
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>