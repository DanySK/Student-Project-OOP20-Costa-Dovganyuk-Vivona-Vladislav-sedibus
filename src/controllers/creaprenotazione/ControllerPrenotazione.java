package controllers.creaprenotazione;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.creaprenotazione.ModelPrenotazione;
import model.creaprenotazione.ModelPrenotazioneImpl;
import model.utili.AzioneUtente;
import model.utili.Periodo;
import model.utili.Utente;
import view.adminuser.LoaderAdminUserSelection;
import view.piantina.LoaderTableView;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	private Utente utente;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private Label testoPosti;
	@FXML private Label errore;
	@FXML private ChoiceBox<Periodo> testoPeriodo;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	
	public ControllerPrenotazione(Utente utente, AzioneUtente azione, String idTavolo, String codPrenotaz, LocalDate data, Periodo periodo, String nPosti) { 
		this.modello.prendiTavolo(idTavolo);
		if(azione.equals(AzioneUtente.MODIFICA)) {
			this.modello.prendiVecchiaPrenotazione(codPrenotaz, periodo, data);
			this.modello.settaPostiModifica(Integer.parseInt(nPosti));
		} else {
			this.modello.settaPostiCreazione();
		}
		this.azione = azione;
		this.utente = utente;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(azione.equals(AzioneUtente.CREAZIONE)) {
			this.azzeraPosti();
		}
		this.errore.setText("");
	}
	
	private void pulisciCampi() {
		this.azzeraPosti();
		this.errore.setText("");
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
		
		if(this.modello.prendiDatiCliente(this.testoNome.getText(), this.testoCognome.getText(), this.testoEmail.getText(), this.testoTelefono.getText())) {
			this.modello.prendiPeriodo(this.testoPeriodo.getValue().toString());
			this.modello.prendiData(this.testoData.getValue());
			if(this.azione.equals(AzioneUtente.CREAZIONE)) {
				this.modello.aggiungiPrenotazione();
				
			} else {
				if(this.modello.cercaTavolo()) {
					this.modello.modificaPrenotazione();
				} else {
					this.errore.setText("Tutto esaurito - cambiare data, periodo o n.posti");
				}
			}
			if(this.utente.equals(Utente.ADMIN)) {
				//pagina mappa dei tavoli
				apriMappaTavoli();
			} else {
				//riepilogo
				//mandi il tutto al riepilogo, incluso il tipo di Utente che ha fatto 
				//la prenotazione/modifica, e li anche senza il controller esterno,
				//dopo aver cliccato il tasto conferma....se ADMIN apri la visuale tavoli
				//se USER apri la visuale iniziale(la pagina di accesso)
				apriViewIniziale();
			}
			//se tutto inserito correttamente chiudo lo stage corrente
			chiudiScena();
		} else {
			this.errore.setText("Attenzione - dati inseriti non corretti!");
		}
		
	}
	
	public void handlerReset() {
		this.pulisciCampi();
	}
	
	public void handlerAnnulla() {
		//apro la mappa tavoli qualsiasi sia il tipo di utente
		apriMappaTavoli();
		this.chiudiScena();
	}
	 
	private void apriMappaTavoli() {
		final LoaderTableView piantinaTavoli = new LoaderTableView();
		LoaderTableView.loaderTableView(this.utente);
		piantinaTavoli.start(new Stage());
	}
	
	private void apriViewIniziale() {
		final LoaderAdminUserSelection viewSelectionUser = new LoaderAdminUserSelection();
		viewSelectionUser.start(new Stage());
	}
	
	private void chiudiScena() {
		this.testoNome.getScene().getWindow().hide();
	}
	
}