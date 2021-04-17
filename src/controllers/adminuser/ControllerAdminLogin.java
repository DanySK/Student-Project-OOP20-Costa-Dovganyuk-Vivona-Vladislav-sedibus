package controllers.adminuser;



import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.piantina.LoaderTableView;
import model.utili.Utente;


public class ControllerAdminLogin  {
	
	
	@FXML
	private TextField user;
	
	@FXML 
	private PasswordField pass;
	
	@FXML
	private Label failedLabel;
	
	private static Utente utente;
	
	;
	
	 @FXML
	 public void loadTableViewAdmin(ActionEvent event) {

	  if (pass.getText().equals("pass") && user.getText().equals("utente"))
	  {	
		utente=Utente.ADMIN;
		
		LoaderTableView view= new LoaderTableView();
    	Stage currentStage = (Stage) this.user.getScene().getWindow();
    	LoaderTableView.loaderTableView(utente);
		 try { 
			 view.start(new Stage());
			   currentStage.close();
	     } catch (Exception e) {
	            e.printStackTrace();
	        }

	  }
	  
	  else failedLabel.setText("Nome Utente o Password Errati");
   }
    
	
}