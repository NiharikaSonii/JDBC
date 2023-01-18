package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection con;
	
	public static Connection createConnection() throws ClassNotFoundException {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			//create the connection
			String user="root";
			String password="root12345";
			String url="jdbc:mysql://localhost:3306/Bank";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connected To DB");
		} 
		catch (SQLException e) 
		{
		   e.printStackTrace();
		}
		return con;
	}
	}
	

