package controllers.cercaprenotazione;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.cercaprenotazione.ModelCercaPrenotazione;
import model.cercaprenotazione.ModelCercaPrenotazioneImpl;
import model.utili.AzioneUtente;
import model.utili.Periodo;
import model.utili.Utente;
import view.adminuser.LoaderUserDecision;
import view.creaprenotazione.LoaderPrenotazione;

public class ControllerCercaPrenotazione implements Initializable {

	@FXML private TextField testoCodice;
	@FXML private TextField testoCognome;
	@FXML private Label testoErrore;
	@FXML private ToggleGroup turno;
	private ModelCercaPrenotazione modello = new ModelCercaPrenotazioneImpl();
	
	public ControllerCercaPrenotazione() { }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.testoCodice.clear();
		this.testoCognome.clear();
		this.testoErrore.setVisible(false);
	}
	
	public void handlerConferma() {
		if (this.sceltaTurno().isPresent() && 
			this.modello.cercaDati(this.testoCodice.getText(), this.testoCognome.getText(), this.getTurno())) {
			LoaderPrenotazione modifica = new LoaderPrenotazione(
					Utente.USER, AzioneUtente.MODIFICA, this.modello.getNome(), 
					this.testoCognome.getText(), this.modello.getEmail(), 
					this.modello.getTelefono(), this.modello.getData(),
					this.getTurno(), this.modello.getPosti(), 
					this.modello.getIdTavolo(), this.testoCodice.getText());
			try {
				modifica.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.chiudiPagina();
		} else {
			this.testoErrore.setVisible(true);
		}
	}
	
	public void handlerAnnulla() {
		//va alla pagina precedente
		LoaderUserDecision precedente = new LoaderUserDecision();
		precedente.start(new Stage());
		this.chiudiPagina();
	}
	
	private void chiudiPagina() {
		this.testoCodice.getScene().getWindow().hide();
	}
	
	private RadioButton turnoSelezionato() {
		return (RadioButton) this.turno.getSelectedToggle();
	}
	
	private Periodo getTurno() {
		return this.turnoSelezionato().getText().equalsIgnoreCase(Periodo.PRANZO.toString()) ? Periodo.PRANZO : Periodo.CENA;
	}
	
	private Optional<RadioButton> sceltaTurno() {
		return Optional.ofNullable(this.turnoSelezionato());
	}
	
}
