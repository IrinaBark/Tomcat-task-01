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

@WebServlet("/ControllerOut")
public class ControllerOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerOut() {
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
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Set<User> users = Agregate.getUsers();
		for (User u : users) {
			if (u.equals(user)) {
				u.setSignIn(false);

			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/out.jsp");
		requestDispatcher.forward(request, response);
	}

}
