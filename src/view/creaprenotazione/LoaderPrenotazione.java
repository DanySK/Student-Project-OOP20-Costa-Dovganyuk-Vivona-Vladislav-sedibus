package view.creaprenotazione;

import java.io.IOException;
import java.time.LocalDate;

import controllers.creaprenotazione.ControllerPrenotazione;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.utili.AzioneUtente;
import model.utili.Periodo;

public class LoaderPrenotazione extends Application {

	private static final String PERC_SCENA = "/layouts/ScenePrenotazione.fxml";
	private static final int TOGGLE_POS_PRANZO = 0;
	private static final int TOGGLE_POS_CENA = 1;
	private static AzioneUtente azione;
	private Label etichettaAzione;
	private ToggleGroup turno;
	private DatePicker testoData;
	private Periodo periodo;
	private LocalDate data;
	private String idTavolo;
	private Label etichettaTavolo;
	
	public LoaderPrenotazione(AzioneUtente azione, Periodo periodo, LocalDate data, String idTavolo) {
		LoaderPrenotazione.azione = azione;
		this.periodo = periodo;
		this.data = data;
		this.idTavolo = idTavolo;
		
	}
	
	/*
	public void inizia(AzioneUtente a) {
		azione = a;
		launch();
	}
	 */
	
	
	@Override
	public void start(Stage scenaPrimaria) throws Exception {
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		try {
			Parent radice = caricatore.load();
			final Scene miaScena = new Scene(radice);
			scenaPrimaria.setScene(miaScena);
			scenaPrimaria.setResizable(false);
			
			this.etichettaAzione = (Label) miaScena.lookup("#etichettaAzione");
			this.etichettaAzione.setText(azione.toString());
			
			//compilazione inerente al turno
			this.turno =  (ToggleGroup) caricatore.getNamespace().get("turno");
			if(this.periodo.equals(Periodo.PRANZO)) {
				this.turno.getToggles().get(TOGGLE_POS_PRANZO).setSelected(true);
			}else {
				this.turno.getToggles().get(TOGGLE_POS_CENA).setSelected(true);
			}
			
			
			//compilazione inerente alla data
			this.testoData = (DatePicker) caricatore.getNamespace().get("testoData");
			this.testoData.setValue(this.data);
			this.testoData.setEditable(false);
			//this.testoData.setDisable(true);
			
			this.etichettaTavolo = (Label) caricatore.getNamespace().get("etichettaTavolo");
			this.etichettaTavolo.setText("Tavolo " + this.idTavolo);
			
			scenaPrimaria.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
