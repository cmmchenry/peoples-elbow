package app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import beans.Query1;
import beans.Query2;
import beans.Query3;
import beans.Query4;
import beans.Query5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableManager {
	public static void buildTable1(ResultSet rs, TableView table) throws SQLException {
    	table.getColumns().clear();
    	
    	TableColumn col1 = new TableColumn("Receipt ID");
    	col1.setCellValueFactory(new PropertyValueFactory<Query1,String>("receiptId"));
		
		TableColumn col2 = new TableColumn("Date of Receipt");
		col2.setCellValueFactory(new PropertyValueFactory<Query1,String>("date"));
		
		TableColumn col3 = new TableColumn("Item Name");
		col3.setCellValueFactory(new PropertyValueFactory<Query1,String>("itemName"));
		
		TableColumn col4 = new TableColumn("Item Quantity");
		col4.setCellValueFactory(new PropertyValueFactory<Query1,String>("itemQuantity"));
  
    	table.getColumns().addAll(col1, col2, col3, col4);
    	
    	ObservableList<Query1> data = FXCollections.observableArrayList();
    	while (rs.next()) {
        	data.add(new Query1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
    	}
    	
    	table.setItems(data);
    }
    
    public static void buildTable2(ResultSet rs, TableView table) throws SQLException {
    	table.getColumns().clear();
    	
    	TableColumn col1 = new TableColumn("Item Name");
    	col1.setCellValueFactory(new PropertyValueFactory<Query2,String>("itemName"));
		
		TableColumn col2 = new TableColumn("Total Quantity");
		col2.setCellValueFactory(new PropertyValueFactory<Query2,String>("totalQuantity"));
  
    	table.getColumns().addAll(col1, col2);
    	
    	ObservableList<Query2> data = FXCollections.observableArrayList();
    	while (rs.next()) {
        	data.add(new Query2(rs.getString(1), rs.getInt(2)));
    	}
    	
    	table.setItems(data);
    }
    
    public static void buildTable3(ResultSet rs, TableView table) throws SQLException {
    	table.getColumns().clear();
    	ResultSetMetaData meta = rs.getMetaData();
    	
    	TableColumn col1 = new TableColumn("FirstName");
    	col1.setCellValueFactory(new PropertyValueFactory<Query3,String>("firstName"));
		
		TableColumn col2 = new TableColumn("Last Name");
		col2.setCellValueFactory(new PropertyValueFactory<Query3,String>("lastName"));
		
		TableColumn col3 = new TableColumn("Amount of Receipts");
		col3.setCellValueFactory(new PropertyValueFactory<Query3,String>("amountOfReceipts"));
		
		TableColumn col4 = new TableColumn("Average Receipt Price");
		col4.setCellValueFactory(new PropertyValueFactory<Query3,String>("averageReceiptPrice"));
		
		TableColumn col5 = new TableColumn("Average Amount of Items");
		col5.setCellValueFactory(new PropertyValueFactory<Query3,String>("averageAmountOfItems"));
  
    	table.getColumns().addAll(col1, col2, col3, col4, col5);
    	
    	ObservableList<Query3> data = FXCollections.observableArrayList();
    	while (rs.next()) {
        	data.add(new Query3(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
    	}
    	
    	table.setItems(data);
    }
    
    public static void buildTable4(ResultSet rs, TableView table) throws SQLException {
    	table.getColumns().clear();
    	ResultSetMetaData meta = rs.getMetaData();
    	
    	TableColumn col1 = new TableColumn("FirstName");
    	col1.setCellValueFactory(new PropertyValueFactory<Query4,String>("firstName"));
		
		TableColumn col2 = new TableColumn("Last Name");
		col2.setCellValueFactory(new PropertyValueFactory<Query4,String>("lastName"));
		
		TableColumn col3 = new TableColumn("Manager's ID");
		col3.setCellValueFactory(new PropertyValueFactory<Query4,String>("managerId"));
		
		TableColumn col4 = new TableColumn("Manager First Name");
		col4.setCellValueFactory(new PropertyValueFactory<Query4,String>("managerFirstName"));
		
		TableColumn col5 = new TableColumn("Manager Last Name");
		col5.setCellValueFactory(new PropertyValueFactory<Query4,String>("managerLastName"));
  
    	table.getColumns().addAll(col1, col2, col3, col4, col5);
    	
    	ObservableList<Query4> data = FXCollections.observableArrayList();
    	while (rs.next()) {
        	data.add(new Query4(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
    	}
    	
    	table.setItems(data);
    }
    
    public static void buildTable5(ResultSet rs, TableView table) throws SQLException {
    	table.getColumns().clear();
    	ResultSetMetaData meta = rs.getMetaData();
    	
    	TableColumn col1 = new TableColumn("FirstName");
    	col1.setCellValueFactory(new PropertyValueFactory<Query5,String>("firstName"));
		
		TableColumn col2 = new TableColumn("Last Name");
		col2.setCellValueFactory(new PropertyValueFactory<Query5,String>("lastName"));
		
		TableColumn col3 = new TableColumn("Register Balance");
		col3.setCellValueFactory(new PropertyValueFactory<Query5,String>("registerBalance"));
  
    	table.getColumns().addAll(col1, col2, col3);
    	
    	ObservableList<Query5> data = FXCollections.observableArrayList();
    	while (rs.next()) {
        	data.add(new Query5(rs.getString(1), rs.getString(2), rs.getInt(3)));
    	}
    	
    	table.setItems(data);
    }
}
