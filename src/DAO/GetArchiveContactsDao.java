package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entity.ContactUsEntity;

public class GetArchiveContactsDao {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	ConnectDB connectionObj = new ConnectDB();

	public List<ContactUsEntity> getArchiveContact() {
		String query = "SELECT * FROM entries where archive = true;";
		List<ContactUsEntity> archiveContactList = new ArrayList<>();
		try {
			connection = connectionObj.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ContactUsEntity archiveContact = new ContactUsEntity();
				archiveContact.setName(resultSet.getString("name"));
				archiveContact.setEmail(resultSet.getString("email"));
				archiveContact.setMessage(resultSet.getString("message"));
				archiveContactList.add(archiveContact);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return archiveContactList;
	}
}