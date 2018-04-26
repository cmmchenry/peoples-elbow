package app;
 
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class App extends Application {
	
	final double WIDTH = 720;
	final double HEIGHT = 720;
	private Scene loginScene, queryScene;
	private TableView table = new TableView();
	private TextField textField = new TextField("Input Parameter");
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
				password.clear();
			} catch (SQLException e1) {
				password.clear();
				System.out.println(e1.getMessage());
			}
        });
        
        VBox loginGroup = new VBox(10);
        loginGroup.getChildren().addAll(usernameLabel, username, passLabel, password, loginButton);
        GridPane layout1 = new GridPane();
        layout1.setAlignment(Pos.CENTER);
        layout1.add(loginGroup, 0, 0);
        loginScene = new Scene(layout1, WIDTH, HEIGHT);
        
        //QueryScene
        ToggleGroup group = new ToggleGroup();
        RadioButton query1 = new RadioButton("Receipts for Customer");
        query1.setToggleGroup(group);
        query1.setSelected(true);
        query1.setOnAction(e -> {
        	textField.setDisable(false);
        });
        RadioButton query2 = new RadioButton("Products sold for the past month");
        query2.setToggleGroup(group);
        query2.setOnAction(e -> {
        	textField.setDisable(false);
        });
        RadioButton query3 = new RadioButton("Employee Productivity");
        query3.setToggleGroup(group);
        query3.setOnAction(e -> {
        	textField.setDisable(false);
        });
        RadioButton query4 = new RadioButton("Employees' Managers");
        query4.setToggleGroup(group);
        query4.setOnAction(e -> {
        	textField.setDisable(true);
        });
        RadioButton query5 = new RadioButton("Register Balances");
        query5.setToggleGroup(group);
        query5.setOnAction(e -> {
        	textField.setDisable(true);
        });
        
        VBox radioGroup = new VBox(10);
        radioGroup.getChildren().addAll(query1, query2, query3, query4, query5);
        Button queryButton = new Button("Query");
        queryButton.setOnAction(e -> {
        	try {
	        	String query = "";
	        	if(query1.isSelected() == true) {
	        		query = Queries.QUERY_1;
	        		ResultSet rs = connectionManager.excecuteQuery(query);
					TableManager.buildTable1(rs, table);
	        	}
	        	else if(query2.isSelected() == true) {
	        		query = Queries.QUERY_2;
	        		ResultSet rs = connectionManager.excecuteQuery(query);
					TableManager.buildTable2(rs, table);
	        	}
				else if(query3.isSelected() == true) {
					query = Queries.QUERY_3;	
					ResultSet rs = connectionManager.excecuteQuery(query);
					TableManager.buildTable3(rs, table);
				}
				else if(query4.isSelected() == true) {
					query = Queries.QUERY_4;
					ResultSet rs = connectionManager.excecuteQuery(query);
					TableManager.buildTable4(rs, table);
				}
				else if(query5.isSelected() == true) {
					query = Queries.QUERY_5;
					ResultSet rs = connectionManager.excecuteQuery(query);
					TableManager.buildTable5(rs, table);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        	
        });

    	Button logoutButton = new Button("<- Logout");
    	logoutButton.setOnAction(e -> {
    		connectionManager = null;
    		table.getColumns().clear();
			primaryStage.setScene(loginScene);
    	});
    	HBox controls = new HBox(10);
    	controls.getChildren().addAll(textField, queryButton);
    	VBox layout2 = new VBox(10);
    	layout2.getChildren().addAll(logoutButton, table, controls, radioGroup);
    	queryScene = new Scene(layout2, WIDTH, HEIGHT);
   
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}