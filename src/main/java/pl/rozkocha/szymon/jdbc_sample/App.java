package pl.rozkocha.szymon.jdbc_sample;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
 			e1.printStackTrace();
 		}
    	
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		DatabaseServer databaseServer = new DatabaseServer(
        		"localhost", "javadb", "jdbc", "pass123");
		
		DatabaseUsersDAO.init(databaseServer);
		DatabaseRolesDAO.init(databaseServer);
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
		
        Scene scene = new Scene(root, 400, 500);

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
