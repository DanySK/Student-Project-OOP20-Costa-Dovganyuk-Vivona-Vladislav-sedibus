package controllers.creaprenotazione;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.creaprenotazione.ModelPrenotazione;
import model.creaprenotazione.ModelPrenotazioneImpl;
import model.creaprenotazione.PilotaPosti;
import model.utili.AzioneUtente;
import model.utili.Periodo;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	@FXML private AnchorPane ancora;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private ToggleGroup turno;
	@FXML private Label testoPosti;
	@FXML private Label massimoPosti;
	@FXML private Label etichettaAzione;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	private PilotaPosti gestionePosti;
	
	public ControllerPrenotazione() { }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {  //forse non serve neanche
		//System.out.println(this.massimoPosti.getText()); NON VA
		this.gestionePosti = new PilotaPosti(9);  //da modificare
		this.pulisciCampi();
	}
	
	private void pulisciCampi() {
		this.ancora.getChildren().stream().filter(p -> p.getClass().equals(TextField.class))
										  .map(el -> (TextField) el)
										  .forEach(tf -> tf.clear());
		//this.testoData.getEditor().clear();
		this.gestionePosti.azzeraPosti();
		this.aggiornaPosti();
		//this.turno.getSelectedToggle().setSelected(false); NON VA -> da sostituire
	}
	
	public void handlerPiuPosti() {
		this.gestionePosti.aggiungiPosto();
		this.aggiornaPosti();
	}
	
	public void handlerMenoPosti() {
		this.gestionePosti.togliPosto();
		this.aggiornaPosti();
	}
	
	private void aggiornaPosti() {
		this.testoPosti.setText(String.valueOf(this.gestionePosti.getNumeroPosti()));
	}
	
	public void handlerConferma() {
		//prende e controlla testi componenti
		if(this.modello.prendiDati(this.testoNome.getText(), this.testoCognome.getText(), 
									 this.testoEmail.getText(), this.testoTelefono.getText())) {
			//se ok allora aggiunge prenotaz.
			System.out.println("TUTTO OK");
			/*this.modello.aggiungiPrenotazione(this.getPeriodo(), 
											  this.testoData.getValue(), 
											  tavolo, 
											  this.gestionePosti.getNumeroPosti());*/
			//prossima pagina -> riepilogo a cui passare etichettaAzione
		}
	}
	
	private RadioButton turnoSelezionato() {
		return (RadioButton) this.turno.getSelectedToggle();
	}
	
	private Periodo getPeriodo() {
		return this.turnoSelezionato().getText().equals("Pranzo") ? Periodo.PRANZO : Periodo.CENA;
	}
	
	public void handlerReset() {
		this.pulisciCampi();
	}
	
	public void handlerAnnulla() {
		//pagina precedente
	}
	
	private void riempiCampi() {
		
	}

}