package SimpleSeleniumPractice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SQLConnector 
{
	@Test
	public void authentication() throws Exception
	{
		String dbURL="jdbc:mysql://localhost:3306/employee";
		
		String username="root";
		String password="A123753r&";
		String query="SELECT * from emp; ";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(dbURL,username,password);
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		while (rs.next()){
    		String myName = rs.getString(1);								        
            String myAge = rs.getString(2);					                               
            System. out.println(myName+"  "+myAge);		
			}
		con.close();
	}
}
