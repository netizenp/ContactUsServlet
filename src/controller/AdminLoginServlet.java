package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminLoginDao;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminLoginDao adminLoginObj = new AdminLoginDao();
		boolean autheticate = adminLoginObj.loginAuthetication(username, password);
		if (autheticate == true) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminDisplay");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}