package controllers.cercaprenotazione;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.cercaprenotazione.ModelCercaPrenotazione;
import model.cercaprenotazione.ModelCercaPrenotazioneImpl;
import model.utili.Periodo;

public class ControllerCercaPrenotazione implements Initializable {

	@FXML private TextField testoCodice;
	@FXML private TextField testoCognome;
	@FXML private Label testoErrore;
	@FXML private ToggleGroup turno;
	private ModelCercaPrenotazione modello = new ModelCercaPrenotazioneImpl();
	
	public ControllerCercaPrenotazione() {
	}
	
	public void handlerConferma() {
		if(this.sceltaTurno().isPresent() && this.modello.cercaDati(this.testoCodice.getText(), 
																	this.testoCognome.getText(), 
																	this.getTurno())) {
			//va alla prossima pagina -> modifica prenotazione
			System.out.println("TROVATA!");
		} else {
			this.testoErrore.setVisible(true);
		}
	}
	
	public void handlerAnnulla() {
		//va alla pagina precedente
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.testoCodice.clear();
		this.testoCognome.clear();
		this.testoErrore.setVisible(false);
	}
	
	private RadioButton turnoSelezionato() {
		return (RadioButton)this.turno.getSelectedToggle();
	}
	
	private Periodo getTurno() {
		return this.turnoSelezionato().getText().equals("Pranzo") ? Periodo.PRANZO : Periodo.CENA;
	}
	
	private Optional<RadioButton> sceltaTurno() {
		return Optional.ofNullable(this.turnoSelezionato());
	}
	
}
