package controllers.adminuser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.utili.Utente;
import view.piantina.LoaderTableView;

public class ControllerUserDecision {
	
	private static Utente utente;
	
	@FXML
	private Button prenota;
	

	@FXML
	 public void loadTableViewUser(ActionEvent event) {

		utente=Utente.USER;
		
		LoaderTableView view= new LoaderTableView();
   	Stage currentStage = (Stage) this.prenota.getScene().getWindow();
   	LoaderTableView.loaderTableView(utente);
		 try { 
			 view.start(new Stage());
			   currentStage.close();
	     } catch (Exception e) {
	            e.printStackTrace();
	        }
     } 
}