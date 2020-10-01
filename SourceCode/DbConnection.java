package FirstServlet;
import java.sql.*;
import java.util.*;

public class DbConnection 
{
Connection con=null;
try 
{
Class.forName("com.mysql.jdbc.Driver");	
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yearbook","root","root");
String sql="";
}
catch(Exception e)
{
System.out.println(e);
}
}
}
