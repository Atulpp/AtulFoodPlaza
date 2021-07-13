<%@page import="java.sql.*"%>
<%@page import="in.coder.utility.DBConnection"%>
	<%
String admin=(String)session.getAttribute("username");

	if(admin!=null) {

	
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Feedback</title>
</head>
<center>
<jsp:include page="Header.jsp"></jsp:include>
<body>



<table border="2" class="responstable">
<tr>
<td>Name</td>
<td>Email Id</td>
<td>Food Quality</td>
<td>Comments/Suggestions</td>


</tr>
<%
PreparedStatement ps=null;
Connection conn=null;
try
{
	conn=DBConnection.getDBConnect();
	String sql="select * from question";
	
ps=conn.prepareStatement(sql);
	
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{

%>
    
    <tr>
    <td><%=rs.getString("username") %></td>
    <td><%=rs.getString("email") %></td>
     <td><%=rs.getString("type") %></td>
      <td><%=rs.getString("question") %></td>
    </tr>
        <%

}
%>
    </table>
    <%
    rs.close();
   
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>


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