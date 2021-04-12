package view.creaprenotazione;

import java.io.IOException;

import controllers.creaprenotazione.ControllerPrenotazione;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.utili.AzioneUtente;

public class LoaderPrenotazione extends Application {

	private static final String PERC_SCENA = "/layouts/ScenePrenotazione.fxml";
	private static AzioneUtente azione;
	private Label etichettaAzione;
	
	public LoaderPrenotazione() {}
	
	public void inizia(AzioneUtente a) {
		azione = a;
		launch();
	}

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
			
			scenaPrimaria.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
