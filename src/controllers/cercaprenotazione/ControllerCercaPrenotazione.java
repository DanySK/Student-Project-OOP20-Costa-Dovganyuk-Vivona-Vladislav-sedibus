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
import view.adminuser.LoaderAdminUserSelection;
import view.adminuser.LoaderUserDecision;
import view.creaprenotazione.LoaderPrenotazione;
import view.eliminaprenotazione.ViewAlert;

public class ControllerCercaPrenotazione implements Initializable {

	private AzioneUtente azione;
	@FXML private TextField testoCodice;
	@FXML private TextField testoCognome;
	@FXML private Label testoErrore;
	@FXML private ToggleGroup turno;
	private ModelCercaPrenotazione modello = new ModelCercaPrenotazioneImpl();
	
	public ControllerCercaPrenotazione(AzioneUtente azione) { 
		this.azione = azione;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.testoCodice.clear();
		this.testoCognome.clear();
		this.testoErrore.setVisible(false);
	}
	
	public void handlerConferma() {
		this.modello.prendiDati(this.testoCodice.getText(), this.testoCognome.getText(), this.getTurno());
		if (this.sceltaTurno().isPresent() && this.modello.cercaDati()) {
			
			if(this.azione.equals(AzioneUtente.MODIFICA)) {  //se MODIFICA
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
			} else {  //altrimenti se ELIMINA
				ViewAlert alert = new ViewAlert();
				if(alert.alertEliminazionePrenotazione(this.modello.getPrenotazione(), 
						this.modello.getData(), this.getTurno()).equals(ButtonType.YES)) {
					if(this.modello.eliminaPrenotazione()) {
						alert.alertConfermaEliminazione();
						final LoaderAdminUserSelection viewSelectionUser = new LoaderAdminUserSelection();
						viewSelectionUser.start(new Stage());
					} else {
						alert.alertErrore("ERRORE");
					}
				}
			}
			
			this.chiudiPagina();
		} else {
			this.testoErrore.setVisible(true);
		}
	}
	
	public void handlerAnnulla() {
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
