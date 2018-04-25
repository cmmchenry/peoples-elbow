package helpers;

import static helpers.configuration.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import app.Queries;

public class QueryTester {
	//issues with rounding
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
			System.out.println();
			Statement stmt = con.createStatement();
			
			//QUERY 1: Get all receipts and purchase for given customer.		(work on user input)			
			int customer = 401;	
			ResultSet rs = stmt.executeQuery(Queries.QUERY_1);
			System.out.println("Receipts and Purchases for Customer Number: " + customer);
			printResultSet(rs);
					
			//Query 2: Get all Products sold for the past month. (work on last month part- either user input or current date?)
			//	(THIS ONE WORKS without user input or current date)			
			rs = stmt.executeQuery(Queries.QUERY_2);
			System.out.println("All Products Sold During the Previous Month: ");
			printResultSet(rs);
						
			//Query 3: For employees get receipt count, average cost of receipt, and average item count past year.	
			//(work on rounding issue for averages)				
			//String date = "'24-APR-2017'";
			rs = stmt.executeQuery(Queries.QUERY_3);
            System.out.println("Employee Productivity During the Previous Year: ");
			printResultSet(rs);
			
			/*
			//work in progress
			System.out.println("Please enter the current date in DD-MMM-YYYY format");
			String Sql =
					"SELECT PR.ITEM_NAME AS \"Item Name\", "
					+ " SUM(PU.QUANTITY) AS \"Total quantity\" "
					+ " FROM RECEIPT R"
					+ " RIGHT OUTER JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
					+ " RIGHT OUTER JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
					+ " WHERE R.RECEIPT_DAY = ? "
					+ " GROUP BY PR.ITEM_NAME"
					+ " ORDER BY PR.ITEM_NAME ASC";
				PreparedStatement pstmt = con.prepareStatement(Sql);
				pstmt.setInt(1, 11);
				ResultSet ps = pstmt.executeQuery();
			*/
						
			//Query 4: List of managers for all employees. 	
			rs = stmt.executeQuery(Queries.QUERY_4);
            System.out.println("List of the Manager of Each Employee: ");
			printResultSet(rs);
				
			//Query 5: Current status of all registers and employees operating them.	
			rs = stmt.executeQuery(Queries.QUERY_5);
			System.out.println("Current Balance of Each Register Including the Name of the Employee Operating it: ");
			printResultSet(rs);
		}
	}

	private static void printResultSet(ResultSet rs) throws SQLException {
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
			column_widths[i-1] = Math.min(
					Math.max(meta.getColumnName(i).length(), column_widths[i-1])
					,25) + 2;
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
		System.out.println();
	}
}
	
