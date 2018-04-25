package app;
 
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class App extends Application {
	
	final static String q1 = 
			"SELECT R.RECEIPT_ID AS \"Receipt ID\", "
			+ " R.RECEIPT_DATE AS \"Date of Receipt          \", "
			+ " PR.ITEM_NAME AS \"Item Name\", "
			+ " PU.QUANTITY AS \"Item Quantity\" "
			+ " FROM CUSTOMER C"
			+ " JOIN RECEIPT R ON C.CUSTOMER_ID = R.CUSTOMER_ID"
			+ " JOIN PURCHASE PU ON R.RECEIPT_ID = PU.RECEIPT_ID"
			+ " JOIN PRODUCT PR ON PU.ITEM_ID = PR.ITEM_ID"
			+ " WHERE C.CUSTOMER_ID = 401 ";
	
	final double WIDTH = 800;
	final double HEIGHT = 450;
	Scene loginScene, queryScene, resultScene;
	private TableView table = new TableView();
	ConnectionManager connectionManager;
	
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
    		String result;
    		try {
    			textArea.setText(connectionManager.excecuteQuery(q1));
				primaryStage.setScene(resultScene);
			} catch (SQLException e1) {
				textArea.setText(e1.getMessage());
			}
    	});
    	Button button2 = new Button("Query2");
    	button2.setOnAction(e -> {
    		primaryStage.setScene(resultScene);
    	});
    	Button button3 = new Button("Query3");
    	button3.setOnAction(e -> {
    		primaryStage.setScene(resultScene);
    	});
    	Button button4 = new Button("Query4");
    	button4.setOnAction(e -> {
    		primaryStage.setScene(resultScene);
    	});
    	Button button5 = new Button("Query5");
    	button5.setOnAction(e -> {
    		primaryStage.setScene(resultScene);
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
    	layout3.getChildren().addAll(textArea, backButton);
    	resultScene = new Scene(layout3, WIDTH, HEIGHT);
    	
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    
    public void buildTable() {
    	
    }
}