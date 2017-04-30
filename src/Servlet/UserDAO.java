package Servlet;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null;

	public static UserBean register(UserBean bean) {
		// preparing some objects for connection
		PreparedStatement ps = null;

		String username = bean.getUsername();
		String password = bean.getPassword();

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);

		try {
			// connect to DB
			// check if user exists
			con = ConnectionManager.getConnection();
			String table = ConnectionManager.getTable();
			ps = con.prepareStatement("SELECT * from "+table+ "where username=?");

			ps.setString(1, bean.getUsername());

			rs = ps.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to true
			if (!more) {
				System.out.println("Adding user...");
				PreparedStatement entry = con
						.prepareStatement("INSERT INTO "+table+" (username, password)" + "VALUES(?, MD5(?));");
				entry.setString(1, bean.getUsername());
//				entry.setString(2, BCrypt.hashpw(bean.getPassword(), BCrypt.gensalt(9)));
				entry.setString(2, bean.getPassword());

				entry.executeUpdate(); // Insert new user into database

				bean.setValid(true);
			}
			// if user exists set the isValid variable to false
			else if (more) {
				System.out.println("Username taken");
//				if (BCrypt.checkpw(bean.getPassword(), rs.getString("password"))) {
//					System.out.println("Password match!");
//				} else {
//					System.out.println("Password does not match!");
//				}

				bean.setValid(false);
			}
		}

		catch (Exception ex) {
			System.out.println("Registration failed: A MYSQL connection exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
				con = null;
			}
		}

		return bean;
	}

	public static UserBean login(UserBean bean) {
		// preparing some objects for connection
		PreparedStatement ps = null;

		String username = bean.getUsername();
		String password = bean.getPassword();

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);

		try {
			// connect to DB
			// check if user exists
			con = ConnectionManager.getConnection();
			String table = ConnectionManager.getTable();
			ps = con.prepareStatement("SELECT * from "+table+" where username=? AND password=MD5(?)");

			ps.setString(1, bean.getUsername());
			ps.setString(2, bean.getPassword());

			rs = ps.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Incorrect username or password");
				
				bean.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("Login success");
//				if (BCrypt.checkpw(bean.getPassword(), rs.getString("password"))) {
//					System.out.println("Password match!");
//				} else {
//					System.out.println("Password not match!");
//				}

				bean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Login failed: A MYSQL connection exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
				con = null;
			}
		}

		return bean;
	}
}
