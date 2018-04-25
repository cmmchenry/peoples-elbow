package app;

import static app.configuration.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ConnectionManager {

	private Connection connection;
	
	public ConnectionManager(String username, String password) throws SQLException {
			this.connection = DriverManager.getConnection(
					JDBC_URL, 
					username, 
					password
				);
	}
	
	public String excecuteQuery(String query) throws SQLException {
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String response = formatResultSet(rs);
		return response;
	}
	 
	private String formatResultSet(ResultSet rs) throws SQLException {
		String response = "";
		ResultSetMetaData meta = rs.getMetaData();
		int columns = meta.getColumnCount();
		int[] column_widths = new int[columns];
		
		for (int i = 1; i <= columns; i++) {
			if (meta.getColumnType(i) == Types.VARCHAR)
				column_widths[i-1] = meta.getColumnDisplaySize(i);
			else if (meta.getColumnType(i) == Types.TIMESTAMP)
				column_widths[i-1] = 21;
			else
				column_widths[i-1] = 10;
			column_widths[i-1] = Math.min(Math.max(meta.getColumnName(i).length(), column_widths[i-1]),25) + 2;
			response += "|";
			String value = meta.getColumnName(i);
			for (int j = 0; j < column_widths[i-1] - value.length(); j++) {
				response += " ";
			}
			response += value;
		}
		response += "|\n";
		for(int i = 1; i < columns; i++) {
			response +="|";
			for(int j = 0; j < column_widths[i-1]; j++ ) {
				response += "-";
			}
		}
		response += "|\n";
		
		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				response += "|";
				if (meta.getColumnType(i) == Types.NUMERIC) {
					int i_value = rs.getInt(i);
					for (int j = 0; j < column_widths[i-1] - i_value; j++) {
						response += " ";
					}
					response += i_value;
				}
				else {
					String s_value = rs.getString(i);
					for (int j = 0; j < column_widths[i-1] - s_value.length(); j++) {
						response += " ";
					}
					response += s_value;
				}
			}
			response += "|\n";
		}
		return response;
	}
}
