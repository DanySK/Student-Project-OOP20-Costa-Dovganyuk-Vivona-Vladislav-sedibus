package controllers.piantina;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.utili.AzioneUtente;
import model.utili.Periodo;
import model.utili.Utente;
import view.creaprenotazione.LoaderPrenotazione;
import view.eccezioni.AlertEccezione;

public class ControllerTavoloLibero implements Initializable {

	private final int POS_NUM_TAVOLO = 1;
	@FXML private VBox vBoxPrincipale;
	@FXML private Text testoPeriodo;
	@FXML private Text testoData;
	@FXML private Text testoSuperiore;
	@FXML private Text testoUtente;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
	}
	
	
	public void handlerConferma() {
		LoaderPrenotazione view = new LoaderPrenotazione(getUtente(),AzioneUtente.CREAZIONE,getPeriodo(),getData(),getIdTavolo());
		try {
			view.start(new Stage());
		} catch (Exception e) {
			AlertEccezione avviso = new AlertEccezione();
	    	avviso.err(e.getMessage());
		}
		closeCurrentStage();
	}
	
	
	public void handlerAnnulla() {
		closeCurrentStage();
		
	}
	
	private void closeCurrentStage() {
		var s = (Stage) this.vBoxPrincipale.getScene().getWindow();
		s.close();
	}
	
	private String getIdTavolo() {
		return this.testoSuperiore.getText().split(" ")[POS_NUM_TAVOLO];
	}
	
	private LocalDate getData() {
		return LocalDate.parse(this.testoData.getText());
	}
	
	private Periodo getPeriodo() {
		return Periodo.valueOf(this.testoPeriodo.getText());
	}
	
	private Utente getUtente() {
		return Utente.valueOf(this.testoUtente.getText());
	}
	

}
