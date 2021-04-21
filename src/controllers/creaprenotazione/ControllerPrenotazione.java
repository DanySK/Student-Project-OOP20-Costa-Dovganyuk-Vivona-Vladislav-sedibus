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
import view.eccezioni.AlertEccezione;
import view.piantina.LoaderTableView;
import view.riepilogo.LoaderRiepilogo;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	private Utente utente;
	private String idTavolo;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private ChoiceBox<Periodo> testoPeriodo;
	@FXML private Label testoPosti;
	@FXML private Label errore;
	private ModelPrenotazione modello = new ModelPrenotazioneImpl();
	
	public ControllerPrenotazione(Utente utente, AzioneUtente azione, String idTavolo, 
			String codPrenotaz, LocalDate data, Periodo periodo, String nPosti) { 
		this.idTavolo = idTavolo;
		this.azione = azione;
		this.utente = utente;
		
		this.modello.prendiTavolo(idTavolo);
		if(azione.equals(AzioneUtente.MODIFICA)) {
			
			this.modello.prendiVecchiaPrenotazione(codPrenotaz, periodo, data);
			this.modello.settaPostiModifica(Integer.parseInt(nPosti));
		} else {
			this.modello.settaPostiCreazione();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(azione.equals(AzioneUtente.CREAZIONE)) {
			this.azzeraPosti();
		}
		this.errore.setText("");
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
		if(this.modello.prendiDatiCliente(this.testoNome.getText(), 
										  this.testoCognome.getText(), 
										  this.testoEmail.getText(), 
										  this.testoTelefono.getText())) {
			
			this.modello.prendiPeriodo(this.testoPeriodo.getValue().toString());
			this.modello.prendiData(this.testoData.getValue());
			
			if(this.azione.equals(AzioneUtente.CREAZIONE)) {
				this.modello.aggiungiPrenotazione();
				this.chiudiScena();
				this.apriRiepilogo();
			} else {  //se una modifica
				if(this.modello.cercaTavolo()) {
					this.modello.modificaPrenotazione();
					this.chiudiScena();
					this.apriRiepilogo();
				} else {
					this.errore.setText("Tutto esaurito - cambiare data, periodo o n.posti");
				}
			}
			
		} else {
			this.errore.setText("Attenzione - dati inseriti non corretti!");
		}
	}
	
	public void handlerReset() {
		this.azzeraPosti();
		this.errore.setText("");
		this.testoNome.clear();
		this.testoCognome.clear();
		this.testoEmail.clear();
		this.testoTelefono.clear();
	}
	
	public void handlerAnnulla() {
		final LoaderTableView piantinaTavoli = new LoaderTableView();
		LoaderTableView.loaderTableView(this.utente);
		piantinaTavoli.start(new Stage());
		this.chiudiScena();
	}
	
	private void apriRiepilogo() {
		LoaderRiepilogo riepilogo = new LoaderRiepilogo(this.utente, 
				this.azione, this.testoPeriodo.getValue(), 
				this.testoData.getValue(), this.idTavolo);
		try {
			riepilogo.start(new Stage());
		} catch (Exception e) {
			AlertEccezione avviso = new AlertEccezione();
	    	avviso.err(e.getMessage());
		}
	}
	
	private void chiudiScena() {
		this.testoNome.getScene().getWindow().hide();
	}
	
}