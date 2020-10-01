package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class RegisterServlet extends HttpServlet
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
String email = req.getParameter("email");
String id = req.getParameter("id");
String address = req.getParameter("address");
String mobile = req.getParameter("mobile");
String utype = req.getParameter("utype");
try
{
String sql = "select * from reg where username = '"+username+"'";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
if(rs.next())
{
res.sendRedirect("register.jsp?msg1=UserName_Already_Existed");   
}
else
{ 
PreparedStatement ps = con.prepareStatement("insert into reg(id,username,password,email,address,mobile,utype) values(?,?,?,?,?,?,?)");
ps.setString(1,id);
ps.setString(2,username);    
ps.setString(3,password);
ps.setString(4,email);
ps.setString(5,address);
ps.setString(6,mobile);
ps.setString(7,utype);
ps.executeUpdate();
PreparedStatement ps1 = con.prepareStatement("insert into login(username,password,utype) values(?,?,?)");
ps1.setString(1,username);    
ps1.setString(2,password);
ps1.setString(3,utype);
ps1.executeUpdate();
res.sendRedirect("login.jsp?msg=success");
}
}
catch(Exception e1)
{
res.sendRedirect("register.jsp?m1=Failed");
pw.println(e1.getMessage());
}
}
public void destroy()
{	
}

}  
