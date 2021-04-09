package controllers.adminuser;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class AdminLoginController {
	
	
	private static final int PROPORTION = 2;
	
	@FXML
	private TextField user;
	
	@FXML 
	private PasswordField pass;
	
	@FXML
	private Label failedLabel;
	
	
	
	 @FXML
	 public void loadTableView(ActionEvent event) { 

	if (pass.getText().equals("pass") && user.getText().equals("utente"))
	{	
	  
		 try {         //Copia incolla del metodo dento view.LoaderTableView con alcune modifiche 
			 final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/MappaTavoli.fxml"));
	            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
	            //tavoliView.start(primaryStage);
	            
	            Stage primaryStage= new Stage();
	            final Parent root = loader.load();
	            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	            final int sw = (int) screen.getWidth();
	            final int sh = (int) screen.getHeight();
	            final Scene scene = new Scene(root);
	            
	           
	            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
	            primaryStage.setTitle("Table Top View");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		        
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
	else failedLabel.setText("Nome Utente o Password Errati");
}
    
}