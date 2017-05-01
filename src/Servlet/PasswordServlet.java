package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;// or some long

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			String newPass1 = request.getParameter("new1");
			String newPass2 = request.getParameter("new2");
			String oldPass = request.getParameter("old");
			if(newPass1.equals(newPass2)){
				System.out.println("Passwords match!");
				HttpSession session = request.getSession(true);
				UserBean user = ((UserBean) (session.getAttribute("currentSessionUser")));
//				user.setPassword(request.getParameter("password"));
	
				user = UserDAO.changePass(user, oldPass, newPass1);
	
				if (user.isValid()) {
					System.out.println("Password changed successfully");
					session.setAttribute("currentSessionUser", user);
					request.getSession().setAttribute("message", 
							"Successfully changed password!");
					request.removeAttribute("page");
					response.sendRedirect("Success.jsp");
				}
	
				else {
					System.out.println("Password change unsuccessful - password is incorrect");
					request.getSession().setAttribute("message", 
							"Password is incorrect");
					request.getSession().setAttribute("page", "changeFailed");
					response.sendRedirect("Success.jsp"); 
					
	//				request.setAttribute("message", "Registration failed - this username is taken");
	//				request.getRequestDispatcher("/RegistrationPage.jsp").forward(request, response);
				}
			}
			else{
				System.out.println("New passwords do not match");
				request.getSession().setAttribute("message", 
						"New passwords do not match");
				request.getSession().setAttribute("page", "changeFailed");
				response.sendRedirect("Success.jsp"); 
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}