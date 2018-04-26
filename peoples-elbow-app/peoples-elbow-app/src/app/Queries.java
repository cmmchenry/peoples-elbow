package app;

/*Defining all queries. Called by the application class.*/
public class Queries {
	
	/*Get all receipts for a given customer. 
	 * Requires parameter replacement.*/
	public static final String QUERY_1 = 
			"SELECT R.RECEIPT_ID AS \"Receipt ID\", "
			+ " R.RECEIPT_DATE AS \"Date of Receipt          \", "
			+ " PR.ITEM_NAME AS \"Item Name\", "
			+ " PU.QUANTITY AS \"Item Quantity\" "
			+ " FROM CUSTOMER C"
			+ " JOIN RECEIPT R ON C.CUSTOMER_ID = R.CUSTOMER_ID"
			+ " JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
			+ " JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
			+ " WHERE C.CUSTOMER_ID = ?"; //Replace ? with input parameter
	
	/*Get all products sold in the past month.*/
	public static final String QUERY_2 =
			"SELECT PR.ITEM_NAME AS \"Item Name\", "
			+ " SUM(PU.QUANTITY) AS \"Total quantity\" "
			+ " FROM RECEIPT R"
			+ " RIGHT OUTER JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
			+ " RIGHT OUTER JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
			+ " WHERE R.RECEIPT_DATE >= '09-APR-2018' "
			+ " GROUP BY PR.ITEM_NAME"
			+ " ORDER BY PR.ITEM_NAME ASC";
	
	/*Get employees' receipt count, average cost of receipt, 
	 *average item count, for the past year.*/
	public static final String QUERY_3 = 
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
	
	/*Show manager for each employee.*/
	public static final String QUERY_4 = 
			"SELECT E.FIRST_NAME AS \"First Name\", "
			+ " E.LAST_NAME AS \"Last Name\", "
			+ " M.MANAGER_E_ID AS \"Manager's ID\", "
			+ " B.FIRST_NAME AS \"Manager First Name\", "
			+ " B.LAST_NAME AS \"Manager Last Name\" "
			+ " FROM EMPLOYEE E"
			+ " JOIN MANAGES M ON E.EMPLOYEE_ID = M.EMPLOYEE_ID"
			+ " JOIN EMPLOYEE B ON M.MANAGER_E_ID = B.EMPLOYEE_ID";
	
	/*Register status.*/
	public static final String QUERY_5 = 
			"SELECT E.FIRST_NAME AS \"First Name\", "
			+ " E.LAST_NAME AS \"Last Name\", "
			+ " R.BALANCE AS \"Register Balance\" "
			+ " FROM EMPLOYEE E"
			+ " JOIN REGISTER R ON R.OPERATOR_E_ID = E.EMPLOYEE_ID"
			+ " ORDER BY REGISTER_NO ASC";
}
	
