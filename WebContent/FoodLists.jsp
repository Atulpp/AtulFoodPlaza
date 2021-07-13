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
<div style="color:blue;font-size:20px">
<% String status=(String)request.getAttribute("success");
if(status!=null){
	
	out.write(status);
}
%>


</div>



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
	
	<a href="CartServlet?operation=addToCart&fid=<%=f.getFoodId()%>"><img src="images/addtocart.PNG" alt="Add To Cart" height="50px" width="60px"></a>

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