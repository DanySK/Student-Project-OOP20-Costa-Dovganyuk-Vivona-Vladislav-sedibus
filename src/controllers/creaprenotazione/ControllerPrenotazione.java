package controllers.creaprenotazione;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.creaprenotazione.ModelPrenotazione;
import model.creaprenotazione.ModelPrenotazioneImpl;
import model.utili.AzioneUtente;
import model.utili.Periodo;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private Label testoPosti;
	@FXML private Label errore;
	@FXML private ChoiceBox<Periodo> testoPeriodo;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	
	public ControllerPrenotazione(String idTavolo, AzioneUtente azione) { 
		this.modello.prendiTavolo(idTavolo);
		this.azione = azione;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.azzeraPosti();
		this.errore.setVisible(false);
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
			this.modello.prendiPeriodo(this.testoPeriodo.getValue().toString());
			this.modello.aggiungiPrenotazione(this.testoData.getValue());
			//prossima pagina a cui passare la prenotazione
			//Se ADMIN, riapri la MappaTavoli
			
			//Se user, apri la pagina iniziale, quella di accesso
			
			//altrimenti mandi il tutto al riepilogo, incluso il tipo di Utente che ha fatto 
			//la prenotazione/modifica, e li anche senza il controller esterno,
			//dopo aver cliccato il tasto conferma....se ADMIN apri la visuale tavoli
			//se USER apri la visuale iniziale(la pagina di accesso)
		} else {
			this.errore.setVisible(true);
		}
	}
	
	public void handlerReset() {
		this.pulisciCampi();
	}
	
	public void handlerAnnulla() {
		//pagina precedente
		//carichi la MappaTavoli con lo stesso tipo di utente che era prima(ADMIN o USER)
	}
	
}