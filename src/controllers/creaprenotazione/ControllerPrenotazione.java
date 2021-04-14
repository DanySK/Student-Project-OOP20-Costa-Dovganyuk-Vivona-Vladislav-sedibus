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
	
	private static final int POS_ID_TAVOLO = 1;
	private AzioneUtente azione;
	@FXML private AnchorPane ancoraTesti;
	@FXML protected TextField testoNome;
	@FXML protected TextField testoCognome;
	@FXML protected TextField testoEmail;
	@FXML protected TextField testoTelefono;
	@FXML protected DatePicker testoData;
	@FXML private ToggleGroup turno;
	@FXML private Label testoPosti;
	@FXML private Label massimoPosti;
	@FXML private Label etichettaAzione;
	@FXML private Label errore;
	@FXML private Label etichettaTavolo;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	private PilotaPosti gestionePosti;
	
	public ControllerPrenotazione() { }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.gestionePosti = new PilotaPosti(9);  //da modificare
		this.pulisciCampi();
	}
	
	private void pulisciCampi() {
		this.ancoraTesti.getChildren().stream().filter(p -> p.getClass().equals(TextField.class))
											   .map(el -> (TextField) el)
											   .forEach(tf -> tf.clear());
		this.gestionePosti.azzeraPosti();
		this.aggiornaPosti();
		this.errore.setVisible(false);
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
		if(this.modello.prendiDati(this.testoNome.getText(), this.testoCognome.getText(), this.testoEmail.getText(), this.testoTelefono.getText())) {
			this.modello.prelevaIdTavolo(this.getIdTavolo());
			this.modello.aggiungiPrenotazione(this.getPeriodo(), 
											  this.testoData.getValue(),
											  this.gestionePosti.getNumeroPosti());
			//prossima pagina -> riepilogo a cui passare etichettaAzione
		} else {
			this.errore.setVisible(true);
		}
	}
	
	private int getIdTavolo() {
		String testo = this.etichettaTavolo.getText();
		return Integer.parseInt(testo.split(" ")[POS_ID_TAVOLO]);
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
	
}