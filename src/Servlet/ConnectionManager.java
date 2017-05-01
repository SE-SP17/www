package servlet;


import java.sql.*;

public class ConnectionManager {

	static Connection con;
	static String url;
	static String database="set_server";
	static String table="users";

	public static Connection getConnection() {

		try {
			url ="jdbc:mysql://localhost:3306/"+database;
			String username = "set_server";
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
	public static String getTable(){
		return table;
	}

}
