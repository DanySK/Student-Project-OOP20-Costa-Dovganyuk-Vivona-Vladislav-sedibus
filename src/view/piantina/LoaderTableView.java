package view.piantina;
	
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import model.piantina.MainTableModel;
import model.utili.Utente;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	private static final int PROPORTION = 2;
	private static Utente utente;
	private Text testoUtente;
	private boolean admin;
	
	
	/*
	public LoaderTableView(Utente utente) {
		LoaderTableView.utente = utente;
	}
	*/
	
	public void loadView(Utente utente) {
		LoaderTableView.utente = utente;
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
            
            this.testoUtente = (Text) loader.getNamespace().get("testoUtente");
            this.testoUtente.setText(LoaderTableView.utente.toString());
            
            //setTextField(typeUser);
            
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Visione Tavoli - " + LoaderTableView.utente);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        //setUser(utente);
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	

	
	
	
	
	
}
