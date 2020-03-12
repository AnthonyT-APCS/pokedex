package model_databases;

import java.sql.*;

public class Database {
	private static Connection con;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connect();
		
	}
	
	public static void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		try {
			con = DriverManager.getConnection("JDBC:SQLite:Pokemon.db.sqbpro");
			System.out.println("Connection successful");
		}
		catch(Exception e) {
			System.out.println("Could not get connection " + e);
		}
	}
}
