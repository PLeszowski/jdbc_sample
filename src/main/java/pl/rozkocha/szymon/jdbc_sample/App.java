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
		
		DatabaseUsersDAO.init(databaseServer);
		DatabaseRolesDAO.init(databaseServer);
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
		
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Osoby");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		DatabaseUsersDAO.getInstance().close();
		DatabaseRolesDAO.getInstance().close();
	}
}
