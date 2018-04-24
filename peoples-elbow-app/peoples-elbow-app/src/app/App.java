package app;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	
	Stage stage;
	final double WIDTH = 1600;
	final double HEIGHT = 900;
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	this.stage = primaryStage;
        this.stage.setTitle("The People's Elbow");
        loadLoginScene();
    }
    
    private void loadLoginScene() {
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadQueryScene();
            }
        });
        Label usernameLabel = new Label("username:");
        TextField username = new TextField("alpha");
        Label passLabel = new Label("password:");
        PasswordField password = new PasswordField();
        grid.add(usernameLabel, 0, 0);
        grid.add(username, 0, 1);
        grid.add(passLabel, 0, 2);
        grid.add(password, 0, 3);
        grid.add(loginButton,0, 4);
    	Scene scene = new Scene(grid, WIDTH, HEIGHT);
    	this.stage.setScene(scene);
        this.stage.show();
    }
    
    private void loadQueryScene() {
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	
    	Scene scene = new Scene(grid, WIDTH, HEIGHT);
    	this.stage.setScene(scene);
        this.stage.show();
    }
    
    private void loadResponseScene() {
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	
    	Scene scene = new Scene(grid, WIDTH, HEIGHT);
    	this.stage.setScene(scene);
        this.stage.show();
    }
}