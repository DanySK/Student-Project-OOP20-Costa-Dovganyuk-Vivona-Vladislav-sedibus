package controllers.piantina;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.utili.Utente;

public class ControllerTavoloOccupato implements Initializable  {

	@FXML private Text textCodice;
	//sara necessario per poi riaprire lo stage dei tavoli in modalita ADMIN
	private final Utente utente = Utente.ADMIN;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
		System.out.println("Codice Prenotazione = " + textCodice.getText());
	}

	
	public void handlerModifica() {
		/*
		 * vado a richiamre la loader di ScenePrenotazione passandogli gli elementi necessari
		 * a precompilare i campi delle form, e il flag che indica che si tratta di una modifica
		 */
	}
	
	public void handlerElimina() {
		/*
		 * vado a richiamare la funzione che elimina la prenotazione, e successivamente apre una finestra per confermare l'eliminazione
		 */
	}
	
	public void handlerAnnulla() {
		/*
		 * Chiude lo stage corrente e torna alla visuale principale
		 */
		var stage = (Stage) this.textCodice.getScene().getWindow();
		stage.close();
		
		
	}
	
}
