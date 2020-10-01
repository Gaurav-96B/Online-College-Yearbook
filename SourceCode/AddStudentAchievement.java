package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class AddStudentAchievement extends HttpServlet
{  
public void init()
{
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
{
PrintWriter pw=res.getWriter(); 
res.setContentType("text/html");
String username = req.getParameter("username");
String year = req.getParameter("year");
String rno = req.getParameter("rno");
String branch = req.getParameter("branch");
String dob = req.getParameter("dob");
String email = req.getParameter("email");
String mobile = req.getParameter("mobile");
String fbid = req.getParameter("fbid");
String address = req.getParameter("address");
String about = req.getParameter("about");
String image = req.getParameter("image");
try
{
PreparedStatement ps = con.prepareStatement("insert into studentevents(username,rno,yr,branch,dob,email,mobile,fbid,address,about,image) values(?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,username);    
ps.setString(2,rno);
ps.setString(3,year);
ps.setString(4,branch);
ps.setString(5,dob);
ps.setString(6,email);    
ps.setString(7,mobile);
ps.setString(8,fbid);
ps.setString(9,address);
ps.setString(10,about);
ps.setString(11,image);
ps.executeUpdate();
res.sendRedirect("addsachievements.jsp?msg=success");
}
catch(Exception e1)
{
res.sendRedirect("addsachievements.jsp?m1=Failed");
pw.println(e1.getMessage());
}
}
public void destroy()
{	
}
}  

