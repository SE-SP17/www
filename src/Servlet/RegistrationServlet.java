//http://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
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
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;// or some long

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			UserBean user = new UserBean();
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			user = UserDAO.register(user);

			if (user.isValid()) {
				System.out.println("Registered");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				request.removeAttribute("message");
				response.sendRedirect("Success.jsp"); // logged-in page
			}

			else {
				System.out.println("Registration failed");
				request.getSession().setAttribute("message", "Registration failed - this username is taken");
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