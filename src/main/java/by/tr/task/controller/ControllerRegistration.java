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

@WebServlet("/ControllerRegistration")
public class ControllerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerRegistration() {
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

		String userName = request.getParameter("login");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		User user = new User(userName, password1);
		Set<User> users = Agregate.getUsers();

		boolean haveName = false;

		for (User u : users) {
			if (u.getUserName().equals(userName)) {
				haveName = true;
			}
		}
		if (haveName) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/haveName.jsp");
			requestDispatcher.forward(request, response);
		} else {
			if (password1.equals(password2)) {
				Agregate.getUsers().add(user);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/successRegistration.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/incorrectPassword.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}
}
