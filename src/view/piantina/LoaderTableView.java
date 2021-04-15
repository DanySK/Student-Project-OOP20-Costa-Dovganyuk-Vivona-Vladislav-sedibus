package view.piantina;
	
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import model.piantina.MainTableModel;
import model.utili.Periodo;
import model.utili.Utente;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	
	private Text testoUtente;
	private DatePicker datePicker;
	private ChoiceBox<Periodo> periodBox;
	
	private static final int PROPORTION = 2;
	private static Utente utente;
	
	private boolean admin;
	private static Periodo periodo;
	private static LocalDate data;
	
	/*
	public LoaderTableView(Utente utente) {
		LoaderTableView.utente = utente;
	}
	*/
	public LoaderTableView() {
		
	}
	
	public LoaderTableView(Periodo p, LocalDate date) {
		LoaderTableView.periodo = p;
		LoaderTableView.data = date;
	}
	
	public void loadView(Utente utente) {
		LoaderTableView.utente = utente;
		launch();
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/MappaTavoli.fxml"));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            
            this.testoUtente = (Text) loader.getNamespace().get("testoUtente");
            this.testoUtente.setText(LoaderTableView.utente.toString());
            
            System.out.println("Data " + LoaderTableView.data );
            
            if(LoaderTableView.data != null) {
            	
	            this.datePicker = (DatePicker) loader.getNamespace().get("datePicker");
	            this.datePicker.setValue(LoaderTableView.data);
	           
	            this.periodBox = (ChoiceBox<Periodo>) loader.getNamespace().get("periodBox");
	            this.periodBox.setValue(LoaderTableView.periodo);
            }
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
