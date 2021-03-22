package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TableController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//carico da file JSON il necessario per quella data,
		//e imposto il giusto colore dei tavoli
		
		
		System.out.println("Table View Loaded...");
	}
	
	@FXML private Button bt;
	
	

}
