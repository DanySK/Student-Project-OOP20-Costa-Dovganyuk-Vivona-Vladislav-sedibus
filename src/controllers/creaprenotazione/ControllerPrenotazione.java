package controllers.creaprenotazione;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.utili.AzioneUtente;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	@FXML private AnchorPane ancora;
	private List<TextField> campiTesto = new ArrayList<>();
	@FXML private DatePicker testoData;
	@FXML private ToggleGroup turno;
	@FXML private Label testoPosti;
	@FXML private Label etichettaAzione;
	
	public ControllerPrenotazione() {}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.ancora.getChildren().forEach(elem -> {
			if(elem.getClass().equals(TextField.class)) {
				this.campiTesto.add((TextField)elem);
			}
		});
		this.pulisciCampi();
	}
	
	private void pulisciCampi() {
		this.campiTesto.forEach(tf -> tf.clear());
		this.testoData.getEditor().clear();
		//this.turno.getSelectedToggle().setSelected(false); NON VA -> da sostituire
	}
	
	public void handlerPiuPosti() {
		
	}
	
	public void handlerMenoPosti() {
		
	}
	
	public void handlerConferma() {
		//prende e controlla testi componenti
		//se ok allora aggiunge prenotaz.
		//prossima pagina -> riepilogo
	}
	
	public void handlerReset() {
		this.pulisciCampi();
	}
	
	public void handlerAnnulla() {
		//pagina precedente
	}
	
	private void riempiCampi() {
		
	}

}