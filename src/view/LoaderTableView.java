package view;
	
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MainTableModel;
import model.Utente;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	private static final int PROPORTION = 2;
	private static Utente utente;
	@FXML TextField typeUser;
	private boolean admin;
	
	/*
	public LoaderTableView(Utente utente) {
		this.utente = utente;
	}
	*/
	
	public void loadView(Utente utente) {
		
		launch();
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/MappaTavoli.fxml"));
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root);
            
            //setTextField(typeUser);
            
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Visione Tavoli-" + LoaderTableView.utente);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        //setUser(utente);
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	

	public void setUser(Utente u) {
		LoaderTableView.utente = u;
		
		if(u.equals(Utente.ADMIN)) {
			admin = true;
		}else {
			admin = false;
		}
		
	}
	
	private void setTextField(TextField field) {
		field.setText(LoaderTableView.utente.toString());
	}
	
	
}
