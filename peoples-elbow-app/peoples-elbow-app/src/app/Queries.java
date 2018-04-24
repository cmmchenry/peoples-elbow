package app;

import static app.configuration.JDBC_URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;


public class Queries {
	//make print a method call
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
			
//Get all receipts and purchase for given customer.		(work on user input)			
			int customer = 401;
			Statement stmt = con.createStatement();
			

			
			String sql =
					"SELECT R.RECEIPT_ID AS \"Receipt ID\", "
					+ " R.RECEIPT_DATE AS \"Date of Receipt          \", "
					+ " PR.ITEM_NAME AS \"Item Name\", "
					+ " PU.QUANTITY AS \"Item Quantity\" "
					+ " FROM CUSTOMER C"
					+ " JOIN RECEIPT R ON C.CUSTOMER_ID = R.CUSTOMER_ID"
					+ " JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
					+ " JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
					+ " WHERE C.CUSTOMER_ID = 401 ";
		
					
					ResultSet rs = stmt.executeQuery(sql );
					
					System.out.println("Receipts and Purchases for Customer Number: " + customer);
							
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
						System.out.println();
					
					
//Get all Products sold for the past month. (work on last month part- either user input or current date?)

			//	(THIS ONE WORKS without user input or current date)			
						sql =
							"SELECT PR.ITEM_NAME AS \"Item Name\", "
							+ " SUM(PU.QUANTITY) AS \"Total quantity\" "
							+ " FROM RECEIPT R"
							+ " RIGHT OUTER JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
							+ " RIGHT OUTER JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
							+ " WHERE R.RECEIPT_DATE >= '09-APR-2018' "
							+ " GROUP BY PR.ITEM_NAME"
							+ " ORDER BY PR.ITEM_NAME ASC";
					
						rs = stmt.executeQuery(sql );
						
						meta = rs.getMetaData();
						columns = meta.getColumnCount();
						column_widths = new int[columns];
						
						System.out.println("All Products Sold During the Previous Month: ");
									
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
							System.out.println();
						
						
						
		//work in progress
						//System.out.println("Please enter the current date in DD-MMM-YYYY format");
						/*
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
							meta = ps.getMetaData();
							columns = meta.getColumnCount();
							column_widths = new int[columns];
							
							System.out.println("All Products Sold During the Previous Month: ");
										
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
								ps.close();
								pstmt.close();
								System.out.println();
								}
								System.out.println();
						
						
						
						*/
						
						
						

					
						
//For employees get receipt count, average cost of receipt, and average item count past year.	
//(work on rounding issue for averages)				
					//String date = "'24-APR-2017'";
						
					sql = 
							"SELECT E.FIRST_NAME AS \"First Name\", "
							+ " E.LAST_NAME AS \"Last Name\", "
							+ " COUNT(R.RECEIPT_ID) AS \"Amount of Receipts\", "
							+ " AVG(R.TOTAL_PRICE) AS \"Average Receipt Price\", "
							+ " AVG(R.ITEM_COUNT) AS \"Average Amount of Items\" "
							+ " FROM EMPLOYEE E"
							+ " JOIN RECEIPT R ON E.EMPLOYEE_ID = R.EMPLOYEE_ID"
							+ " JOIN PURCHASE P ON R.RECEIPT_ID = P.RECEIPT_ID"
							+ " WHERE R.RECEIPT_DATE >= '09-APR-2017'" 
							+ " GROUP BY E.FIRST_NAME, E.LAST_NAME"
							+ " ORDER BY E.LAST_NAME ASC, E.FIRST_NAME ASC";
					rs = stmt.executeQuery(sql );
					
					meta = rs.getMetaData();
					columns = meta.getColumnCount();
					column_widths = new int[columns];
					
					System.out.println("Employee Productivity During the Previous Year: ");
								
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
						
						System.out.println();
						
					
//List of managers for all employees. 	
					sql = 
							"SELECT E.FIRST_NAME AS \"First Name\", "
							+ " E.LAST_NAME AS \"Last Name\", "
							+ " M.MANAGER_E_ID AS \"Manager's ID\", "
							+ " B.FIRST_NAME AS \"Manager First Name\", "
							+ " B.LAST_NAME AS \"Manager Last Name\" "
							+ " FROM EMPLOYEE E"
							+ " JOIN MANAGES M ON E.EMPLOYEE_ID = M.EMPLOYEE_ID"
							+ " JOIN EMPLOYEE B ON M.MANAGER_E_ID = B.EMPLOYEE_ID";
					
					rs = stmt.executeQuery(sql );
					
					meta = rs.getMetaData();
					columns = meta.getColumnCount();
					column_widths = new int[columns];
					
					System.out.println("List of the Manager of Each Employee: ");
								
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
						System.out.println();
					
					
//Current status of all registers and employees operating them.	
					
					
					sql = 
							"SELECT E.FIRST_NAME AS \"First Name\", "
							+ " E.LAST_NAME AS \"Last Name\", "
							+ " R.BALANCE AS \"Register Balance\" "
							+ " FROM EMPLOYEE E"
							+ " JOIN REGISTER R ON R.OPERATOR_E_ID = E.EMPLOYEE_ID"
							+ " ORDER BY REGISTER_NO ASC";
					
					rs = stmt.executeQuery(sql );
					
					meta = rs.getMetaData();
					columns = meta.getColumnCount();
					column_widths = new int[columns];
					
					System.out.println("Current Balance of Each Register Including the Name of the Employee Operating it: ");
								
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
	
