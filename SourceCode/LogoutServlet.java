package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class LogoutServlet extends HttpServlet
{  
public void init()
{	
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
{
HttpSession session=re.getSession(); 
session.invalidate();
response.sendRedirect("index.html");
}
public void destroy()
{
}
}  

