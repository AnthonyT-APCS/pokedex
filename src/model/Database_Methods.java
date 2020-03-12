package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Methods {
	public static Connection connect(String input) {
		//Url format is like: jdbc:sqlite:src/Model/amazon2.db
		//hi
		
		String url = input;
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
		}
		catch(SQLException e) {
			System.out.print(e.getMessage());
		}
		
		return conn;
	}
	
	
}
