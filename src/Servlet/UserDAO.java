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
			ps=con.prepareStatement(  
				    "SELECT username from Players where username=?");  
				  
			ps.setString(1,bean.getUsername());  
			
			rs = ps.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to true
			if (!more) {
				System.out.println("Adding user...");
				PreparedStatement entry=con.prepareStatement(  
						"INSERT INTO Players (username, password)"
						+ "VALUES(?, ?);" );
				entry.setString(1, bean.getUsername());
//				entry.setString(2,  BCrypt.hashpw(bean.getPassword(), BCrypt.gensalt()));
				entry.setString(2, bean.getPassword());
					
				entry.executeUpdate();  // Insert new user into database
				
				bean.setValid(true);
			}
			// if user exists set the isValid variable to false
			else if (more) {
				System.out.println("Username taken");
				
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
				} 
				catch (Exception e) {
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
				} 
				catch (Exception e) {
				}
				con = null;
			}
		}

		return bean;

	}
}
