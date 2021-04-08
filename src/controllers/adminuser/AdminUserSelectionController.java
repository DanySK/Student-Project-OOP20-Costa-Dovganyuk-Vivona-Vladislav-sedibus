package controllers.adminuser;

import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminUserSelectionController {
	
	@FXML 
	public void loadAdminLogin(ActionEvent event)  throws Exception { 
		
		       Parent root = FXMLLoader.load(getClass().getResource("/layouts/AdminLogin.fxml"));
		    
		        Scene scene = new Scene(root, 600, 500);
		        Stage stage = new Stage();
		    
		        stage.setTitle("Sedibus");
		        stage.setScene(scene);
		        stage.show();
		    }
	
	@FXML
	public void loadUserDecision(ActionEvent event) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/UserDecision.fxml"));
	    
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
    
        stage.setTitle("Sedibus");
        stage.setScene(scene);
        stage.show();
	}
	}