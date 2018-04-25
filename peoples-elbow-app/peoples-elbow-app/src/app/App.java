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
import javafx.geometry.Insets;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class App extends Application {
	
	final double WIDTH = 1280;
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
        Button button1 = new Button("Query1");
    	button1.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_1);
    			TableManager.buildTable1(rs, table);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
    	});
    	Button button2 = new Button("Query2");
    	button2.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_2);
    			TableManager.buildTable2(rs, table);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
    	});
    	Button button3 = new Button("Query3");
    	button3.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_3);
    			TableManager.buildTable3(rs, table);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
    	});
    	Button button4 = new Button("Query4");
    	button4.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_4);
    			TableManager.buildTable4(rs, table);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
    	});
    	Button button5 = new Button("Query5");
    	button5.setOnAction(e -> {
    		try {
    			ResultSet rs = connectionManager.excecuteQuery(Queries.QUERY_5);
    			TableManager.buildTable5(rs, table);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
    	});
    	Button logoutButton = new Button("<- Logout");
    	logoutButton.setOnAction(e -> {
    		connectionManager = null;
    		table.getColumns().clear();
			primaryStage.setScene(loginScene);
    	});
    	HBox buttons = new HBox(10);
    	buttons.setAlignment(Pos.CENTER);
    	buttons.getChildren().addAll(textField, button1, button2, button3, button4, button5);
    	VBox layout2 = new VBox(10);
    	layout2.getChildren().addAll(logoutButton, table, buttons);
    	queryScene = new Scene(layout2, WIDTH, HEIGHT);
   
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}