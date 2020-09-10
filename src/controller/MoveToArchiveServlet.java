package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectDB;
import entity.ContactUsEntity;

@WebServlet("/movetoarchive")
public class MoveToArchiveServlet extends HttpServlet {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	ConnectDB connectionObj = new ConnectDB();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("moveToActive");
		String query = "Update entries set archive = true where email = ?;";
		try {
			connection = connectionObj.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			statement.executeUpdate();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminDisplay");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}