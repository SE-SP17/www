package Servlet;


import java.sql.*;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Connection getConnection() {

		try {
			String url = "jdbc:mysql:"+ "//localhost:3306/set";
			String username = "root";
			String password = "sable";
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			try {
				con = DriverManager.getConnection(url, username, password); //username password
			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;
	}

}
