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
<title>Food List</title>

</head>
<body>

<center>
<jsp:include page="Header.jsp"></jsp:include>


<% 
String admin=(String)session.getAttribute("username");
String custEmail=(String)session.getAttribute("custEmail");
%>


<%   List<Food> flist=(List<Food>)session.getAttribute("foodlist"); %>

<% String status=(String)request.getAttribute("success");
if(status!=null){
	
	out.write(status);
}
%>



<form method="post" action="FoodServlet">
<table>
<tr><td colspan="3">Search For Food,Categories...</td></tr>
<tr>
<td><select name="filter" class="login-input" required>
<option value=''>Search By</option>
<option value='foodName'>Food Name</option>
<option value='foodType'>Food Type</option>
</select></td>
<td><input type="text" class="login-input" name="food" required></td>
			<input type="hidden" name="operation" value="search">
				<td><input type="submit"  value="Search" style="font-size: 16px;padding: 10px 10px;"></td>
</tr>			
</table>
</form>


<form >

<table border="4" padding="2" class="responstable">
<tr>
<th>Food Id</th>
<th>Food Name</th>
<th>Food Type</th>
<th>Food Price</th>
<th>Food Image</th>
</tr>
<% 
for(Food f:flist) {
	%>
	<tr>
	
	<td >
	
	<%=f.getFoodId() %></td>
	<td><%=f.getFoodName() %></td>
	<td><%=f.getFoodType() %></td>
	<td><%=f.getFoodPrice() %></td>
	
	<td><img src="retrievee.jsp?fid=<%=f.getFoodId() %>" id="mainimg2" width=170 height=110></td>
	

	
	
	
	<%if(admin!=null&&custEmail==null) {%>
	<td>
	<a href="FoodServlet?operation=update&fid=<%=f.getFoodId()%>">Update</a>
	<a href="FoodServlet?operation=delete&fid=<%=f.getFoodId()%>">Delete</a>
	</td>
	<%} %>
	
	
	
	<%if(admin==null&&custEmail!=null){ %>
	<td>
	
	<a href="CartServlet?operation=addToCart&fid=<%=f.getFoodId()%>"> <img src="images/addtocart.PNG" alt="Add To Cart" height="50px" width="60px"></a>

	</td>
	<%} 
	
	
	%>
	
	
	
		<% }%>
		
</tr>

</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>