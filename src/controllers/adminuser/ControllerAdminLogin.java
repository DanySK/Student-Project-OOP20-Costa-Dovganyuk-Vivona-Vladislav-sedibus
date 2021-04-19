package controllers.adminuser;



import java.io.FileReader;
import java.io.IOException;
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
import view.piantina.LoaderTableView;


public class ControllerAdminLogin  {
	private static String LOGIN_FILE_PATH = System.getProperty("user.home") + System.getProperty("file.separator") +"logindata.json";
	
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
	 * loginData imposta i campi fileUser e filePassword, che verrano usati per il login, leggendo il file logindata.json
	 * 
	 */
	private void loginData () {
		try{
		Reader reader = new FileReader( LOGIN_FILE_PATH);//creo il file reader per il file logindata.json
		JsonObject jobj = new Gson().fromJson(reader,JsonObject.class);//creo il JsonObject da cui andro a leggere i dati presenti su file 
		this.fileUser=jobj.get("utente").getAsString();//uso il metodo getAsString invece di toString in modo che la stringa restituita non abbia i quote marks
		this.filePassword= jobj.get("password").getAsString();
	} catch (IOException e) {
        e.printStackTrace();
	
	}
	}

/**
 *  loadTableViewAdmin confronta il nome utente e password inseriti dall'utente con quelli presenti sul file logindata.json
 *  nel caso di successo viene caricata la view dei tavoli passando come argomento l'Enum utente impostato su admin
 */
	 @FXML
	 public void loadTableViewAdmin(ActionEvent event) {
		 
		 loginData();

	     
	  if (pass.getText().equals(filePassword) && user.getText().equals(fileUser))//confronto i dati inseriti dall'utente con quelli sul file
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
    
	
