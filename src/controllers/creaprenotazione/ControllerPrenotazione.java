package controllers.creaprenotazione;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.creaprenotazione.ModelPrenotazione;
import model.creaprenotazione.PilotaPosti;
import model.utili.AzioneUtente;

public class ControllerPrenotazione implements Initializable {
	
	private AzioneUtente azione;
	//@FXML private AnchorPane ancora;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private ToggleGroup turno;
	@FXML private Label testoPosti;
	@FXML private Label massimoPosti;
	@FXML private Label etichettaAzione;
	private ModelPrenotazione modello = new ModelPrenotazione();
	private PilotaPosti gestionePosti;
	
	public ControllerPrenotazione() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*this.ancora.getChildren().forEach(elem -> {
			if(elem.getClass().equals(TextField.class)) {
				this.campiTesto.add((TextField)elem);
			}
		});*/
		System.out.println(this.massimoPosti.getText());
		this.gestionePosti = new PilotaPosti(9);
		this.pulisciCampi();
	}
	
	private void pulisciCampi() {
		//this.campiTesto.forEach(tf -> tf.clear());
		this.testoNome.clear();
		this.testoCognome.clear();
		this.testoEmail.clear();
		this.testoTelefono.clear();
		//this.testoData.getEditor().clear();
		this.gestionePosti.azzeraPosti();
		this.aggiornaPagina();
		//this.turno.getSelectedToggle().setSelected(false); NON VA -> da sostituire
	}
	
	public void handlerPiuPosti() {
		this.gestionePosti.aggiungiPosto();
		this.aggiornaPagina();
	}
	
	public void handlerMenoPosti() {
		this.gestionePosti.togliPosto();
		this.aggiornaPagina();
	}
	
	private void aggiornaPagina() {
		this.testoPosti.setText(String.valueOf(this.gestionePosti.getNumeroPosti()));
	}
	
	public void handlerConferma() {
		//prende e controlla testi componenti
		if(this.modello.prendiDati(this.testoNome.getText(), this.testoCognome.getText(), 
									 this.testoEmail.getText(), this.testoTelefono.getText())) {
			//se ok allora aggiunge prenotaz.
			System.out.println("TUTTO OK");
			//prossima pagina -> riepilogo a cui passare etichettaAzione
		}
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