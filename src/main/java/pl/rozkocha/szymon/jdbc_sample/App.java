package pl.rozkocha.szymon.jdbc_sample;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    	
    	HibernateUsersDAO dao = new HibernateUsersDAO("hibernate/hibernate.cfg.xml");
    	
    	List<User> users = dao.get();
    	
    	users.forEach((user) -> {
    		System.out.println(user.toString());
    	});
    	
    	System.out.println(dao.getById(1).toString());
    	
    	/*List<Role> roles = (List<Role>)session.createQuery("from Role").list();
    	
    	roles.forEach((role) -> {
    		System.out.println(role.toString());
    	});
    	
    	session.close();*/
    	
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
