package view.piantina;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoaderTavoloVerdeLibero extends Application {

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TavoloVerdeLibero.fxml"));
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root);
            
            //setTextField(typeUser);
            
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Tavolo LIBERO");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        //setUser(utente);
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
	public void loadView() {
		launch();
	}

}
