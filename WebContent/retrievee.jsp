
    <%@page import="java.io.OutputStream" %>
    <%@page import="in.coder.pojo.*" %>
    <%@page import="java.sql.Blob" %>
     <%@page import="in.coder.dao.foodDaoImpl" %>



<%

Food f=new Food();
foodDaoImpl fdi=new foodDaoImpl();


int fid=Integer.parseInt(request.getParameter("fid"));
f=fdi.displayFoodById(fid);


 Blob blob=f.getFoodImg();
byte byteArray[]=blob.getBytes(1, (int) blob.length());

 response.setContentType("foodImage/jpg");
OutputStream os=response.getOutputStream();
os.write(byteArray);
os.flush();
os.close(); %>

