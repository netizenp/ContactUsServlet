package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectDB;

public class AddContactDao {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	ConnectDB connectionObj = new ConnectDB();

	public boolean addContact(String name, String email, String message) {
		String query = "Insert into entries values (?,?,?,false);";
		try {
			connection = connectionObj.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, message);
			int rowAffected = statement.executeUpdate();
			if (rowAffected == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}