package news;

import java.sql.*;
import java.sql.DriverManager;

import java.sql.SQLException;


public class Link {

	public static Statement Connection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/AddressBook?useSSL=false&characterEncoding=utf-8",
				"root",
				"123456789");
		Statement s =  connection.createStatement();
		return s;
	}
}

