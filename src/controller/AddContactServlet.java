package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AddContactDao;

@WebServlet("/addcontact")
public class AddContactServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String message = (String) request.getParameter("message");
		AddContactDao addContactobj = new AddContactDao();
		if (addContactobj.addContact(name, email, message)) {
			String msg = "Your Msg is Successfully Saved.";
			request.setAttribute("result", msg);
		} else {
			String msg = "Due to some technical issue, your msg is not saved. Retry";
			request.setAttribute("result", msg);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
		requestDispatcher.forward(request, response);
	}
}