package studentmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection con = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123123");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found or check driver name correct!");
		} catch (SQLException e) {
			System.out.println("SQL Fail! " + e.getMessage());
		}

		return con;
	}
}
