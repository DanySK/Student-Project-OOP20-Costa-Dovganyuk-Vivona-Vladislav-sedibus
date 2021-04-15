package controllers.creaprenotazione;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.creaprenotazione.ModelPrenotazione;
import model.creaprenotazione.ModelPrenotazioneImpl;
import model.utili.AzioneUtente;

public class ControllerPrenotazione implements Initializable {
	
	//private AzioneUtente azione;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private TextField testoPeriodo;
	@FXML private Label testoPosti;
	@FXML private Label errore;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	
	public ControllerPrenotazione(String idTavolo, AzioneUtente azione) { 
		this.modello.prendiTavolo(idTavolo);
		//this.azione = azione;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.pulisciCampi();
	}
	
	private void pulisciCampi() {
		this.azzeraPosti();
		this.errore.setVisible(false);
		this.testoNome.clear();
		this.testoCognome.clear();
		this.testoEmail.clear();
		this.testoTelefono.clear();
	}
	
	private void azzeraPosti() {
		this.modello.inizializzaPosti();
		this.aggiornaPosti();
	}
	
	public void handlerPiuPosti() {
		this.modello.incrementaPosti();
		this.aggiornaPosti();
	}
	
	public void handlerMenoPosti() {
		this.modello.decrementaPosti();
		this.aggiornaPosti();
	}
	
	private void aggiornaPosti() {
		this.testoPosti.setText(String.valueOf(this.modello.postiCorrenti()));
	}
	
	public void handlerConferma() {
		if(this.modello.prendiDatiCliente(this.testoNome.getText(), this.testoCognome.getText(), 
										  this.testoEmail.getText(), this.testoTelefono.getText())) {
			this.modello.prendiPeriodo(this.testoPeriodo.getText());
			this.modello.aggiungiPrenotazione(this.testoData.getValue());
			//prossima pagina a cui passare la prenotazione
		} else {
			this.errore.setVisible(true);
		}
	}
	
	public void handlerReset() {
		this.pulisciCampi();
	}
	
	public void handlerAnnulla() {
		//pagina precedente
	}
	
}