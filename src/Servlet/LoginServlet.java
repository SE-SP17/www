package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;// or some long

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			UserBean user = new UserBean();
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			user = UserDAO.login(user);

			if (user.isValid()) {
				System.out.println("Logged in");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				request.removeAttribute("message");
				response.sendRedirect("Success.jsp");
			}

			else {
				System.out.println("Login failed");
				request.getSession().setAttribute("message", "Login failed - "
						+ "please check your username and/or password");
				request.getSession().setAttribute("page", "login");
				response.sendRedirect("RegistrationPage.jsp"); 
				
//				request.setAttribute("message", "Registration failed - this username is taken");
//				request.getRequestDispatcher("/RegistrationPage.jsp").forward(request, response);
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}