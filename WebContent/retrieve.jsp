
    <%@page import="java.io.OutputStream" %>
    <%@page import="in.coder.pojo.*" %>
    <%@page import="java.sql.Blob" %>

<% Food f=(Food)session.getAttribute("food"); %>

<% Blob blob=f.getFoodImg();
byte byteArray[]=blob.getBytes(1, (int) blob.length());

 response.setContentType("foodImage/jpg");
OutputStream os=response.getOutputStream();
os.write(byteArray);
os.flush();
os.close(); %>

