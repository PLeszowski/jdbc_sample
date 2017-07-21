package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsersController {
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
