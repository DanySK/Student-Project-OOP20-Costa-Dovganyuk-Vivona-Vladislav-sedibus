package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import model.ImplMainTableModel;
import model.MainTableModel;
import model.Periodo;

public class Controller implements Initializable {

	
	private static String TAVOLO_VERDE_STYLE_PATH = "layouts/tavoloLibero.css";
	private static String TAVOLO_ROSSO_STYLE_PATH = "layouts/tavoloOccupato.css";
	
	@FXML private DatePicker datePicker;
	@FXML private ChoiceBox<Periodo> periodBox;
	@FXML private AnchorPane paneTavoli;
	private LocalDate ld = LocalDate.now();
	private List<Button> listButton = new ArrayList<>();
	private MainTableModel model = new ImplMainTableModel();
	private Periodo periodo;
	private boolean primaChiamata = true;

	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	//setta la data del DatePicker = a quella corrente
    	
    	
    	setPeriodBox();
    	this.datePicker.setValue(ld);
    	
    	getIDTavoliPrenotati(ld, periodo);
    	
    	//prelevare i bottoni dal fxml e colorarli di verde
    	coloraTavoli();
        
    }
    
    private void coloraTavoli() {
    	this.paneTavoli.getChildren().forEach(e -> {
        	Button b = (Button)e;
        	b.getStylesheets().add(TAVOLO_VERDE_STYLE_PATH);
        	this.listButton.add(b);
        });
    }
    
    private void setPeriodBox() {
    	this.periodBox.getItems().addAll( Periodo.PRANZO, Periodo.CENA);
    	this.periodBox.setValue(Periodo.PRANZO);
    	this.periodo = this.periodBox.getValue();
    }
    
    private void getIDTavoliPrenotati(LocalDate data, Periodo p) {
    	System.out.println("Vado a richiamare la model per farmi ritornare Gli ID dei Tavoli prenotati");
    	System.out.println("Per la data " + data + " e Periodo: " + p);
    	this.model.tavoliPrenotati(ld, periodo);
    }
    
    public void dateHandler() {
    	this.ld = datePicker.getValue();
    	getIDTavoliPrenotati(ld, periodo);
    }
    
    public void handlerPeriodo() {
    	if(!this.primaChiamata) {
	    	this.periodo = this.periodBox.getValue();
	    	getIDTavoliPrenotati(ld, periodo);
    	}else {
    		this.primaChiamata = false;
    	}
    }
    
    public void tornaIndietroHandler() {
    	System.out.println("Torna indietro...[Viene ricaricata la pagina iniziale]");
    }
    

}