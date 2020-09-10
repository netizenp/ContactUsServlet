package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

	private Connection connection;
	
	public Connection getConnection() {
		/*String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/contactus";
		String username = "postgres";
		String password = "123456789a";*/
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/contactus";
		String username = "root";
		String password = "123456789A";
		try {
	         Class.forName(driver);
	         connection = DriverManager.getConnection(url,username, password);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
		return connection;
	}
}