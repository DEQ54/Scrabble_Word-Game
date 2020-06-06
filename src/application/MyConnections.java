package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnections {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/WordGame", "root", "");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}       catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}
}


