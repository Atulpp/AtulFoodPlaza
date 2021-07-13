

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<title>ATUL FOOD PLAZA</title>

</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<center>




<% String status=(String)request.getAttribute("updatedcust");
if(status!=null){
	
	out.write(status);
}
%>
<% String status2=(String)request.getAttribute("loginuser");
if(status2!=null){
	
	out.write(status2);
}
%>
<% String status3=(String)request.getAttribute("loginadmin");
if(status3!=null){
	
	out.write(status3);
}
%>
<% String status4=(String)request.getAttribute("order");
if(status4!=null){
	
	out.write(status4);
}
%>
<% String status5=(String)request.getAttribute("feed");
if(status5!=null){
	
	out.write(status5);
}
%>

    	<center><img src="images/1.PNG" class="main"  height="150px" width="100%"></center>
    	
<div class="row">
  <div class="column">
    <img src="images/pavbhaji.png" alt="Pav Bhaji" id="mainimg" >
    <div class="overlay">Pav Bhaji</div>
    <div class="desc">CUISINES: Street Food, Fast Food<br>
COST FOR TWO:₹300<br>
HOURS: 12Noon to 12Midnight (Mon-Sun)</div>
  </div>
  <div class="column">
    <img src="images/chb.jpg" alt="Chicken Biryani" id="mainimg">
    <div class="overlay">Chicken Biryani</div>
     <div class="desc">CUISINES: North Indian, Mughlai, Biryani<br>
COST FOR TWO:₹550<br>
HOURS: 11AM to 11PM (Mon-Sun)</div>
  </div>
  <div class="column">
    <img src="images/vegt.jpg" alt="Indian Thali" id="mainimg">
    <div class="overlay">Indian Thali</div>
     <div class="desc">CUISINES: Seafood, Maharashtrian, Goan<br>
COST FOR TWO:₹700<br>
HOURS: 11:30AM to 3:30PM, 7PM to 11:30PM</div>
  </div>
</div>

<a href="FoodServlet"><img src="images/menu.PNG" alt="Menu" style="width:100%;height:300px;"></a>


<div class="row">
  <div class="column2">
    <img src="images/2.jpg"  id="mainimg" >
   </div>
  <div class="column2">
    <img src="images/3.jpg"  id="mainimg">
   </div>
  <div class="column2">
    <img src="images/4.jpg"  id="mainimg">
    </div>
</div>
<div class="row">
  <div class="column2">
    <img src="images/5.jpg"  id="mainimg" >
   </div>
  <div class="column2">
    <img src="images/6.jpg"  id="mainimg">
   </div>
  <div class="column2">
    <img src="images/7.jpg"  id="mainimg">
    </div>
</div>
<div class="row">
  <div class="column2">
    <img src="images/8.jpg"  id="mainimg" >
   </div>
  <div class="column2">
    <img src="images/9.jpg"  id="mainimg">
   </div>
  <div class="column2">
    <img src="images/10.jpg"  id="mainimg">
    </div>
</div>


<img src="images/swi.PNG"  style="width:100%;height:400px;">
<center><p style="font-size:30px;"><b>ABOUT US</b></p></center>

<img src="images/about.jpg" alt="about" style="width:50%;height:300px;float:left;margin-right:10px;margin-bottom:10px;">
<p ><b>Ordering food is easy as ABC</b> </p>
<p >The challenge for us is to make a versatile website that is simple and easy to use. What we have learned is that ordering food online is way easier, faster and has less complications than calling. What makes Atul Food Plaza better than the traditional order over the phone method?</p>
<p>✓24/7: Our site is available 24/7 with the feature to pre-order. You can plan your meal ahead from the best restaurants near you and avoid the rush hours</p>
<p>✓ Free to use: Browse through 4000+ restaurant menus for free</p>
<p>✓  Order food in 4 simple steps</p>
<p><b>Our Services </b></p>
<p> Should you have any concerns or would you want to give us feedback, please do not hesitate to contact our customer service team</p>
<p> </p>
<p> </p>
<p> </p>



</center>
</body>
	<jsp:include page="Footer.jsp"></jsp:include>
</html>

