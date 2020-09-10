package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entity.ContactUsEntity;

public class GetActiveContactsDao {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	ConnectDB connectionObj = new ConnectDB();

	public List<ContactUsEntity> getActiveContact() {
		String query = "SELECT * FROM entries where archive = false;";
		List<ContactUsEntity> activeContactList = new ArrayList<>();
		try {
			connection = connectionObj.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ContactUsEntity activeContact = new ContactUsEntity();
				activeContact.setName(resultSet.getString("name"));
				activeContact.setEmail(resultSet.getString("email"));
				activeContact.setMessage(resultSet.getString("message"));
				activeContactList.add(activeContact);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return activeContactList;
	}
}