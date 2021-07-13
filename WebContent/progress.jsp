

<!DOCTYPE html>
        <html lang="en">
        <head>
       
     <meta charset="utf-8">
        
        </head>
<center>
<jsp:include page="Header.jsp"></jsp:include>
</center>
        <body>
   

<div class="namedisplay">Hello<br><%=request.getParameter("username") %></div>
<div id="percentCount" class="percent-count">100% test</div>
       <div class="progress-bar">
       
       <div class="progresss" id="progresss"></div>
       
         
        		
        		
        	
        </div>
 <form name="postForm" method="post" action="LoginServlet" >
 <input type="hidden" name="operation" value="<%=request.getParameter("operation") %>">
  <input type="hidden" name="password" value="<%=request.getParameter("password") %>">
   <input type="hidden" name="username" value="<%=request.getParameter("username") %>">
    <input type="hidden" name="type" value="<%=request.getParameter("type") %>">
 </form>
        <script>
        
        function progress() {

        	var prg = document.getElementById('progresss');
        	var percent = document.getElementById('percentCount');
        	var counter = 5;
        	var progresss = 25;
        	var id = setInterval(frame, 20);

        	function frame() {

        		if(progresss == 500 && counter ==100) {

        			clearInterval(id);
        			document.forms["postForm"].submit();
        		//	window.open("LoginServlet?method=post", "_self");
        		} else {
        			progresss += 5;
        			counter += 1;
        			prg.style.width = progresss + 'px';
        			percent.innerHTML = counter + '%';
        			}
        		}
        	}

        	progress();

        </script>



        </body><center>
        <jsp:include page="Footer.jsp"></jsp:include>
</center>
        </html>