package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class database_management {
private static final String URL = "jdbc:mysql://localhost:3306/banking";
private static final String USERNAME ="root";
private static final String PASSWORD = "jaya@123";

public static Connection getConnection() {
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(URL , USERNAME ,PASSWORD);
		System.out.println("Database connected successfully.");
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	  return connection;
	}
public static void main(String[] args) {
	getConnection();
}
}

