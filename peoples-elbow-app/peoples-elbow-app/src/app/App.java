package app;
 
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import beans.Query1;
import beans.Query2;
import beans.Query3;
import beans.Query4;
import beans.Query5;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class App extends Application {
	
	final double WIDTH = 800;
	final double HEIGHT = 450;
	private Scene loginScene, queryScene, resultScene;
	private TableView table = new TableView();
	private ConnectionManager connectionManager;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The People's Elbow");
        
        //loginScene
        Button loginButton = new Button("Login");
        Label usernameLabel = new Label("username:");
        TextField username = new TextField("alpha");
        Label passLabel = new Label("password:");
        PasswordField password = new PasswordField();
        loginButton.setOnAction(e -> {
        	try {
				connectionManager = new ConnectionManager(username.getText(), password.getText());
				primaryStage.setScene(queryScene);
			} catch (SQLException e1) {
				primaryStage.setScene(loginScene);
			}
        });
        GridPane layout1 = new GridPane();
        layout1.setAlignment(Pos.CENTER);
        layout1.add(usernameLabel, 0, 0);
        layout1.add(username, 0 , 1);
        layout1.add(passLabel, 0 , 2);
        layout1.add(password, 0 , 3);
        layout1.add(loginButton, 0 , 4);
        loginScene= new Scene(layout1, WIDTH, HEIGHT);
        
        //*****************
        TextArea textArea = new TextArea("Test");
        //*****************
        
        //QueryScene
        Button button1 = new Button("Query1");
    	button1.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_1);
    			buildTable1(rs);
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				
			}
    	});
    	Button button2 = new Button("Query2");
    	button2.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_2);
    			buildTable2(rs);
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				
			}
    	});
    	Button button3 = new Button("Query3");
    	button3.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_3);
    			buildTable3(rs);
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				
			}
    	});
    	Button button4 = new Button("Query4");
    	button4.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_4);
    			buildTable4(rs);
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				
			}
    	});
    	Button button5 = new Button("Query5");
    	button5.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_5);
    			buildTable5(rs);
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				
			}
    	});
    	GridPane layout2 = new GridPane();
    	layout2.setAlignment(Pos.CENTER);
    	layout2.add(button1, 0, 0);
    	layout2.add(button2, 0, 1);
    	layout2.add(button3, 0, 2);
    	layout2.add(button4, 0, 3);
    	layout2.add(button5, 0, 4);
    	queryScene = new Scene(layout2, WIDTH, HEIGHT);
        
        //ResultScene
    	
    	Button backButton = new Button("Back");
    	backButton.setOnAction(e -> {
    		primaryStage.setScene(queryScene);
    	});
    	VBox layout3 = new VBox(20);
    	layout3.getChildren().addAll(table, backButton);
    	resultScene = new Scene(layout3, WIDTH, HEIGHT);
    	
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    
    public void buildTable1(ResultSet rs) throws SQLException {
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
    
    public void buildTable2(ResultSet rs) throws SQLException {
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
    
    public void buildTable3(ResultSet rs) throws SQLException {
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
    
    public void buildTable4(ResultSet rs) throws SQLException {
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
    
    public void buildTable5(ResultSet rs) throws SQLException {
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