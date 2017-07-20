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
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.fxml.*;

/**
 * Hello world!
 *
 */ 
public class App extends Application 
{
	private DatabaseUsersDAO usersDAO;
	
    public static void main( String[] args )
    {
    	try {
 			DriverManager.registerDriver(new Driver());
 		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
    	
    	launch(args);
        
        /*List<User> users = usersDAO.get();
        
        users.forEach((user) -> {
        	System.out.println(user.toString());
        });*/
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		DatabaseServer databaseServer = new DatabaseServer(
        		"localhost", "javadb", "jdbc", "pass123");
		
		usersDAO = new DatabaseUsersDAO(databaseServer);
		
		TextField name = new TextField();
		TextField surname = new TextField();
		Label fullName = new Label();
		
		Button addButton = new Button();
        addButton.setText("Dodaj");
        addButton.setOnAction((event) -> {
        	fullName.setText(name.getText() + " " + surname.getText() + " added!");
        	usersDAO.add(new User(0, name.getText(), surname.getText()));
        });
        
        Button getButton = new Button();
        getButton.setText("Get");
        getButton.setOnAction((event) -> {
        	List<User> users = usersDAO.get();
        	
        	users.forEach((user) -> {
        		System.out.println(user.toString());
        	});
        });
        
        VBox root = new VBox();
        root.getChildren().add(name);
        root.getChildren().add(surname);
        root.getChildren().add(fullName);
        root.getChildren().add(addButton);
        root.getChildren().add(getButton);
		
		//Parent root = FXMLLoader.load(getClass().getResource("./main.fxml"));

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Osoby");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		usersDAO.close();
	}
}
