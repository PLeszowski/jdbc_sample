package pl.rozkocha.szymon;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import pl.rozkocha.szymon.jdbc_sample.App;
import pl.rozkocha.szymon.jdbc_sample.DatabaseUsersDAO;
import pl.rozkocha.szymon.jdbc_sample.User;

public class MainController {
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private Label fullName;
	
	@FXML protected void get(ActionEvent event) {
		List<User> users = DatabaseUsersDAO.getInstance().get();
    	
    	users.forEach((user) -> {
    		System.out.println(user.toString());
    	});
    }
	
	@FXML protected void add(ActionEvent event) {
		fullName.setText(name.getText() + " " + surname.getText() + " added!");
		DatabaseUsersDAO.getInstance().add(new User(0, name.getText(), surname.getText()));
    }
}
