package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RolesController {
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
