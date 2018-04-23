package app;

import static app.configuration.JDBC_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;


public class Queries {
	public static void main(String[] args)throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Connecting...");  //connects to database
		try (
			Wizard auth = new Wizard();
			Connection con = DriverManager.getConnection(
				JDBC_URL, 
				auth.getUsername(), 
				auth.getPassword()
			);
		) {
			System.out.println("Connected successfully.");
			int customer = 401;
			Statement stmt = con.createStatement();
			String sql =
					"SELECT R.RECEIPT_ID, R.RECEIPT_DATE, R.HOUR, R.MINUTE, PR.ITEM_NAME, PU.STOCK"
					+ " FROM CUSTOMER C"
					+ " JOIN RECEIPT R ON C.CUSTOMER_ID = R.CUSTOMER_ID"
					+ " JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
					+ " JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
					+ " WHERE C.CUSTOMER_ID = customer";
		
					
					ResultSet rs = stmt.executeQuery(sql );
					
					System.out.print("Receipts and purchases for: " + "______");
					
					final ResultSetMetaData meta = rs.getMetaData();
					final int columns = meta.getColumnCount();
					int[] column_widths = new int[columns];
					
					for (int i = 1; i <= columns; i++) {
						if (meta.getColumnType(i) == Types.VARCHAR)
							column_widths[i-1] = meta.getColumnDisplaySize(i);
						else if (meta.getColumnType(i) == Types.TIMESTAMP)
							column_widths[i-1] = 21;
						else
							column_widths[i-1] = 10;
						column_widths[i-1] = Math.min(
							Math.max(
								meta.getColumnName(i).length(), 
								column_widths[i-1]
							),
							25
						) + 2;
						
						System.out.printf(
							"%-" + column_widths[i-1] + "s", 
							meta.getColumnName(i)
						);
					}
					System.out.println();
					
					while (rs.next()) {
						for (int i = 1; i <= columns; i++) {
							if (meta.getColumnType(i) == Types.NUMERIC)
								System.out.printf(
									"%-," + column_widths[i-1] + "d", 
									rs.getInt(i)
								);
							else
								System.out.printf(
									"%-" + column_widths[i-1] + "s", 
									rs.getString(i)
								);
						}
						System.out.println();
					}
				}
		}
	}
