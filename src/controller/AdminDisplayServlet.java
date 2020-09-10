package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GetActiveContactsDao;
import DAO.GetArchiveContactsDao;
import entity.ContactUsEntity;

@WebServlet("/adminDisplay")
public class AdminDisplayServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GetArchiveContactsDao archiveContactObj = new GetArchiveContactsDao();
		GetActiveContactsDao activeContactObj = new GetActiveContactsDao();

		List<ContactUsEntity> archiveContactList = archiveContactObj.getArchiveContact();
		List<ContactUsEntity> activeContactList = activeContactObj.getActiveContact();

		request.setAttribute("archiveContactList", archiveContactList);
		request.setAttribute("activeContactList", activeContactList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactdisplay.jsp");
		requestDispatcher.forward(request, response);
	}
}
