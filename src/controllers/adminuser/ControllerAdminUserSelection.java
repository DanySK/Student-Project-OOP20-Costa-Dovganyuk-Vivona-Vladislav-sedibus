package controllers.adminuser;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.adminuser.LoaderAdminLogin;
import view.adminuser.LoaderUserDecision;
import view.eccezioni.AlertEccezione;
import javafx.scene.control.Button;

public class ControllerAdminUserSelection  {
	
	@FXML
	private Button Admin;
	
	@FXML
	public void loadAdminLogin (ActionEvent event ){
		LoaderAdminLogin view = new LoaderAdminLogin();
    	Stage currentStage = (Stage) this.Admin.getScene().getWindow();
    	try { 
    		view.start(new Stage());
    		currentStage.close();
	    } catch (Exception e) {
	    	AlertEccezione avviso = new AlertEccezione();
			avviso.err(e.getMessage());
	    }
	}
	
	@FXML
	public void loadUserDecision (ActionEvent event ){
		LoaderUserDecision view = new LoaderUserDecision();
    	Stage currentStage = (Stage) this.Admin.getScene().getWindow();
		try {
			view.start(new Stage());
			currentStage.close();
	    } catch (Exception e) {
	    	AlertEccezione avviso = new AlertEccezione();
			avviso.err(e.getMessage());
	    }
	}
}
	
	
	