package FirstServlet;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import FirstServlet.DbConnection;
public class AddTeacherAchievement extends HttpServlet
{  
public void init()
{
}
public void doGet(HttpServletRequest req,HttpServletResponse res)//
throws ServletException,IOException  
{
PrintWriter pw=res.getWriter(); 
res.setContentType("text/html");
String username = req.getParameter("username");
String year = req.getParameter("year");
String designation = req.getParameter("designation");
String branch = req.getParameter("branch");
String dob = req.getParameter("dob");
String qualificaion = req.getParameter("qualificaion");
String email = req.getParameter("email");
String mobile = req.getParameter("mobile");
String exp = req.getParameter("exp");
String specialization = req.getParameter("specialization");
String subjects = req.getParameter("subjects");
String image = req.getParameter("image");
try
{
PreparedStatement ps = con.prepareStatement("insert into teacherevents(username,designation,yr,branch,dob,qualificaion,email,mobile,exp1,specialization,subjects,image) values(?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,username);    
ps.setString(2,designation);
ps.setString(3,year);
ps.setString(4,branch);
ps.setString(5,dob);
ps.setString(6,qualificaion);
ps.setString(7,email);    
ps.setString(8,mobile);
ps.setString(9,exp);
ps.setString(10,specialization);
ps.setString(11,subjects);
ps.setString(12,image);
ps.executeUpdate();
res.sendRedirect("addtachievements.jsp?msg=success");
}
catch(Exception e1)
{
res.sendRedirect("addtachievements.jsp?m1=Failed");
pw.println(e1.getMessage());
}
}
public void destroy()
{	
}
}  

