package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class LoginServlet extends HttpServlet
{  
public void init()
{
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
{
PrintWriter pw=res.getWriter(); 
res.setContentType("text/html");
String username = req.getParameter("username");
String password = req.getParameter("password");
String utype = req.getParameter("utype");
if(utype.endsWith("Admin"))
{
String query = "select *from login where username='"+username+"' and password='"+password+"' and utype = '"+utype+"'";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
if(rs.next())
{
res.sendRedirect("adminhome.jsp?msg=success");   
}
else
{
res.sendRedirect("login.jsp?m1=Failed");
}
}
if(utype.endsWith("Student"))
{
String query = "select *from login where username='"+username+"' and password='"+password+"' and utype = '"+utype+"'";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
if(rs.next())
{    
HttpSession session=res.getSession();  	
session.setAttribute("user", username);
res.sendRedirect("studenthome.jsp?msg=success");
}
else
{
res.sendRedirect("login.jsp?m1=Failed");
}
}
if(utype.endsWith("Teacher"))
{
String query = "select *from login where username='"+username+"' and password='"+password+"' and utype = '"+utype+"'";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
if(rs.next()){  
HttpSession session=res.getSession();
session.setAttribute("user", username);
res.sendRedirect("teacherhome.jsp?msg=success");
}
else
{
res.sendRedirect("login.jsp?m1=Failed");
}
}
}
public void destroy()
{	
}
}  

