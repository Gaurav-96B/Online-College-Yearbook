import java.sql.*;
public class Dbconnection 
{
public static Connection getConnection() 
{
Connection con = null;
try 
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yearbook", "root", "root");
} 
catch (Exception ex) 
{
ex.printStackTrace();
}
return con;
}
}

