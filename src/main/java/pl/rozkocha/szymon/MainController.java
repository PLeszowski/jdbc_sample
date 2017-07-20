package pl.rozkocha.szymon;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import pl.rozkocha.szymon.jdbc_sample.App;
import pl.rozkocha.szymon.jdbc_sample.DatabaseRolesDAO;
import pl.rozkocha.szymon.jdbc_sample.DatabaseUsersDAO;
import pl.rozkocha.szymon.jdbc_sample.Role;
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
	
	@FXML private TextField roleName;
	
	@FXML protected void role_add(ActionEvent event) {
		DatabaseRolesDAO.getInstance().add(new Role(0, roleName.getText()));
    }
	
	@FXML protected void role_get(ActionEvent event) {
		List<Role> roles = DatabaseRolesDAO.getInstance().get();
    	
		roles.forEach((role) -> {
    		System.out.println(role.toString());
    	});
    }
}
