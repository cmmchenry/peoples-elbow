package app;

import static helpers.configuration.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private Connection connection;
	
	public ConnectionManager(String username, String password) throws SQLException {
			this.connection = DriverManager.getConnection(
					JDBC_URL, 
					username, 
					password
				);
	}
	
	public ResultSet excecuteQuery(String query) throws SQLException {
		Statement stmt = this.connection.createStatement();
		return stmt.executeQuery(query);
	}
}
