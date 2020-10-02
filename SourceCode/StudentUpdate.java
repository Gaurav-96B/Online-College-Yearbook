package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class StudentUpdate extends HttpServlet
{  
public void init()
{
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
String username = req.getParameter("username");
String email = req.getParameter("email");
String id = req.getParameter("id");
String address = req.getParameter("address");
String mobile = req.getParameter("mobile");
try
{
PreparedStatement ps = con.prepareStatement("update reg set email='"+email+"',address='"+address+"',mobile='"+mobile+"' where username = '"+username+"' and id = '"+id+"'");
ps.executeUpdate();
res.sendRedirect("supdateprofile.jsp?msg=success");
}
catch(Exception e1)
{
res.sendRedirect("supdateprofile.jsp?m1=Failed");
pw.println(e1.getMessage());
}
}
public void destroy()
{	
}
}  

