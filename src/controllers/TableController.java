package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.ImplRistorante;
import model.Ristorante;
import model.Tavolo;

public class TableController implements Initializable{

	private Ristorante r = new ImplRistorante();
	private LocalDate date = new DatePickerController().getCurrentDate();
	
	
	
	@FXML private List<Button> button;
	@FXML private Button bt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//carico da file JSON il necessario per quella data,
		//e imposto il giusto colore dei tavoli
		List<Tavolo> tavoli = r.tavoliRistorante();
		
		List<Tavolo> tPrenotati = r.tavoliPrenotati(date);
		
		
		
		
		
		System.out.println("Table View Loaded...");
	}
	
	
	
	
	
	

}
