package controllers.adminuser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.utili.Utente;
import view.adminuser.LoaderAdminUserSelection;
import view.eccezioni.AlertEccezione;
import view.piantina.LoaderTableView;

public final class ControllerAdminLogin  {
	
	private static final String LOGIN_FILE_PATH = "logindata.json";
	
	@FXML
	private TextField user;
	@FXML 
	private PasswordField pass;
	@FXML
	private Label failedLabel;
	private static Utente utente;
	
	private String fileUser;
	private String filePassword;
	
	/**
	 * loginData sets the fileUser and filePassword fields, which will be used for login, by reading the logindata.json file
	 */
	private void loginData () {
		final InputStream res = ClassLoader.getSystemResourceAsStream(LOGIN_FILE_PATH);
		final Reader reader = new BufferedReader(new InputStreamReader(res));//creo il file reader per il file logindata.json
		final JsonObject jobj = new Gson().fromJson(reader,JsonObject.class);//creo il JsonObject da cui andro a leggere i dati presenti su file 
		this.fileUser = jobj.get("utente").getAsString();//uso il metodo getAsString invece di toString in modo che la stringa restituita non abbia i quote marks
		this.filePassword = jobj.get("password").getAsString();
	}

	/**
	 * loadTableViewAdmin compares the username and password entered by the user with those present in the logindata.json file.
	 * In case of success, the view of the tables is loaded passing the User Enum set on admin as the argument
	 */
	 @FXML
	 public void loadTableViewAdmin(ActionEvent event) {
		 
		 loginData();

	     
	  if (pass.getText().equals(filePassword) && user.getText().equals(fileUser))//confronto i dati inseriti dall'utente con quelli sul file
	  {	
		utente=Utente.ADMIN;
		
		final LoaderTableView view = new LoaderTableView();
    	final Stage currentStage = (Stage) this.user.getScene().getWindow();
    	LoaderTableView.loaderTableView(utente);
		try {
			view.start(new Stage());
			currentStage.close();
	     } catch (Exception e) {
	    	 final AlertEccezione avviso = new AlertEccezione();
	    	 avviso.err(e.getMessage());
	     }
	
	  }
	  
	  else failedLabel.setText("Nome Utente o Password Errati");
      }
	 
	 @FXML
	 public void goBack (ActionEvent event){
		 
		    final LoaderAdminUserSelection view= new LoaderAdminUserSelection();
	        final Stage currentStage = (Stage) this.user.getScene().getWindow();
	  
			try {
				view.start(new Stage());
				currentStage.close();
		     } catch (Exception e) {
		    	 final AlertEccezione avviso = new AlertEccezione();
		    	 avviso.err(e.getMessage());
		     }
	 }

}	
    
	
