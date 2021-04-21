package controllers.adminuser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.utili.Utente;
import view.cercaprenotazione.LoaderCercaPrenotazione;
import view.eccezioni.AlertEccezione;
import view.piantina.LoaderTableView;
import model.utili.AzioneUtente;

public class ControllerUserDecision {
	
	private static Utente utente;
	private static AzioneUtente azioneUtente;
	
	@FXML
	private Button prenota;
	
	

	@FXML
	 public void loadTableViewUser(ActionEvent event) {

		utente=Utente.USER;
		
		LoaderTableView view= new LoaderTableView();
   	    Stage currentStage = (Stage) this.prenota.getScene().getWindow();
   	    LoaderTableView.loaderTableView(utente);
		try { 
			 view.start(new Stage());
			   currentStage.close();
	    } catch (Exception e) {
	    	this.errore(e.getMessage());
	    }
     }
	
	@FXML
	public void loadModificaPrenotazione (ActionEvent event){
		
		azioneUtente=AzioneUtente.MODIFICA;
		
		Stage currentStage = (Stage) this.prenota.getScene().getWindow();
		LoaderCercaPrenotazione view= new LoaderCercaPrenotazione();
		LoaderCercaPrenotazione.loadCercaPrenotazione(azioneUtente);
		try {
			view.start(new Stage());
			currentStage.close();
		} catch (Exception e) {
			this.errore(e.getMessage());
		}
	}
	
	@FXML
	public void loadCancellaPrenotazione (ActionEvent event){
		
		azioneUtente=AzioneUtente.CANCELLA;
		
		Stage currentStage = (Stage) this.prenota.getScene().getWindow();
		LoaderCercaPrenotazione view= new LoaderCercaPrenotazione();
		LoaderCercaPrenotazione.loadCercaPrenotazione(azioneUtente);
		try {
			view.start(new Stage());
			currentStage.close();
		} catch (Exception e) {
			this.errore(e.getMessage());
		}
	}
	
	private void errore(String mex) {
		AlertEccezione avviso = new AlertEccezione();
		avviso.err(mex);
	}
	
}