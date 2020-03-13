package dynamoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testDB {
	private static Connection con;
	
	public static void Connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:dynamodb:Host=dynamodb.us-west-1.amazonaws.com;Region=us-west-1;CredentialFilePath=C:\\Documents\\DynamoDB_JDBC_Credentials.txt;ProfileName=default");
	}
}
