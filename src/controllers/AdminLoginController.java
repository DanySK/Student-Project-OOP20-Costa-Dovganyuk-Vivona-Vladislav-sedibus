package controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AdminLoginController {
	
	private static final int PROPORTION = 2;
	
	@FXML
	public void loadTableView(ActionEvent event) {  
	 //Copia incolla del metodo dento view.LoaderTableView con alcune modifiche 
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Sample.fxml"));
            Stage primaryStage = new Stage();
            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
            
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(scene);
	        primaryStage.show();
          

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
