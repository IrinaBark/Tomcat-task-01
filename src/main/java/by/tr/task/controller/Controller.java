package by.tr.task.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.task.agregate.Agregate;
import by.tr.task.bean.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");

		if (request.getParameter("signUp") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
			requestDispatcher.forward(request, response);

		} else {
		
			String userName = request.getParameter("login");
			String password = request.getParameter("password");

			User user = new User(userName, password);
			user.setSignIn(false);

			Set<User> users = Agregate.getUsers();

			boolean isRegistered = false;
			boolean correctPassword = false;

			for (User u : users) {
				if (u.getUserName().equals(userName)) {
					isRegistered = true;
				}
			}
			boolean isSignedIn = false;
			if (!isRegistered) {

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/notFound.jsp");
				requestDispatcher.forward(request, response);
			} else {
				for (User u : users) {
					if (u.getUserPassword().equals(password)) {
						correctPassword = true;
						isSignedIn = u.isSignIn();

					}
				}
				if (isSignedIn) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/WEB-INF/jsp/alreadySignedIn.jsp");
					requestDispatcher.forward(request, response);
					
				} else if (correctPassword) {
					user.setSignIn(true);
					for (User u : users) {
						if (u.getUserName().equals(userName)) {
							u.setSignIn(true);

						}
					}
				
					request.getSession().setAttribute("user", user);
                    
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
					requestDispatcher.forward(request, response);
				} else {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/WEB-INF/jsp/incorrectPassword.jsp");
					requestDispatcher.forward(request, response);
				}

			}
		}

	}

}
