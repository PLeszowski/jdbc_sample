package pl.rozkocha.szymon.jdbc_sample;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.Driver;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.fxml.*;

/**
 * Hello world!
 *
 */ 
public class App extends Application 
{
    public static void main( String[] args )
    {
    	launch(args);
    	
        try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        DatabaseServer databaseServer = new DatabaseServer(
        		"localhost", "javadb", "jdbc", "pass123");
        
        DatabaseUsersDAO usersDAO = new DatabaseUsersDAO(databaseServer);
        
        List<User> users = usersDAO.get();
        
        users.forEach((user) -> {
        	System.out.println(user.toString());
        });
        
        usersDAO.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
		
		//Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
