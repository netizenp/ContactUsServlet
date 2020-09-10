package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectDB;

public class AdminLoginDao {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	ConnectDB connectionObj = new ConnectDB();
	
	public boolean loginAuthetication(String username, String password) {
		String query = "SELECT * FROM admin where username = ? and password = ?;";
		try {
			connection = connectionObj.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}