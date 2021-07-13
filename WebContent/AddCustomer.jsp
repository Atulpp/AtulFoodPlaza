<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		

	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>
</head>
<body>
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
				if(isNaN(x[2].value))
				{
					
					x[2].nextElementSibling.innerHTML="Contact should be in number";
					x[2].nextElementSibling.style.color="red";
					count++;
				}
				
				

			
				
			if(count>0)
				return false;
			else
				return true;
			

		}
		
		function clearup(a)
		{
			if(a.value!="")
				{
				a.nextElementSibling.innerHTML="";
				}
		}
	</script>
	
<div style="color:blue;font-size:20px">
<% String status=(String)request.getAttribute("success");
if(status!=null){
	
	out.write(status);
}
%>



</div>
<div class="login">
 <h1 class="login-title">Register Here</h1>
	<form action="CustServlet"  method="post">
	 <input type="hidden" name="operation" value="addCust"> 
			 
				 Name: 
				 <input type="text" class="login-input" name="cName" class="valid"
					onblur="clearup(this)"><span></span> 
			   
			 
				 Address: 
				 <input type="text" class="login-input" name="cAdd" class="valid"
					onblur="clearup(this)"><span></span> 
			   
			 
				 Age: 
				 <input type="text" class="login-input" name="cCon" class="valid"
					onblur="clearup(this)"><span></span> 
			   
			 
				 Email: 
				 <input type="email" class="login-input" name="cEmail"> 
					 
			   
			 
				 Password: 
				 <input type="password" class="login-input" name="cPass" class="valid"
					onblur="clearup(this)"><span></span> 
			   

			 
				 <input type="submit" value="Register" class="login-button"
					onclick="return validate()"> <br><br>
				 <input type="reset" value="Cancel" class="login-button"> 
			 
	

	</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>

