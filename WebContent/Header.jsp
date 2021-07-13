<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link href="style.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<center>
<body>

<div class="topnav">
<img src="images/start.jpg" class="main" height="150px" width="170px">

<img src="images/tt.PNG" class="main" height="150px" width="300px" style=" border-radius: 30%;">

<img src="images/ss.jpg" class="main" height="150px" width="210px">

  </div>    


<% 
String admin=(String)session.getAttribute("username");
String custEmail=(String)session.getAttribute("custEmail");
%>
<div id='cssmenu'>
        <ul>
        	<li class="current"><a href="index.jsp"><b>Home</b></a></li>
        	<li><a href="FoodServlet"><b>Food Menu</b></a></li>
        	
        	
        	
        	<% if(admin==null&&custEmail==null) {%>
        	 <li><a href="Login.jsp"><b>Login</b></a></li>
           
             <li><a href="AddCustomer.jsp"><b>Register</b></a></li>
              <li ><a href="radioForm.jsp"><b>FeedBack</b></a></li> 
               
  
            <%} %>
            
            <% if(admin!=null&&custEmail==null) {%>
            <li ><a href="changePass.jsp"><b>Change Password</b></a></li>
               <li ><a href="CustServlet"><b>Customer List</b></a></li>
               <li><a href="AddFood.jsp"><b>Add Food</b></a></li>
               <li><a href="ShowFeed.jsp"><b>Show Feedback</b></a></li>
                <li><a href="OrderServlet"><b>All Orders List</b></a></li>
                <li ><a href="LoginServlet?action=logout"><b>Logout</b></a></li>
                
            
            
           
            <%} %>
            
              <% if(admin==null&&custEmail!=null) {%>
            
                
                
            <li ><a href="CartServlet?operation=displayCart"><b>Show Cart</b></a></li>
            <li ><a href="CustServlet?operation=updateCust"><b>Edit Profile</b></a></li>
             <li ><a href="LoginServlet?action=logout"><b>Logout</b></a></li>
               <li ><a href="radioForm.jsp"><b>FeedBack</b></a></li>
                 <%} %>
           
           
  
            
            <li ><a href="contactus.jsp"><b>Contact Us</b></a></li>
            
        </ul>
    </div>
    </center>
</body>
</html>