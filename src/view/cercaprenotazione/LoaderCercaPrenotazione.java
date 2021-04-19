package view.cercaprenotazione;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utili.AzioneUtente;

public class LoaderCercaPrenotazione extends Application  {

	private static final String PERC_SCENA = "/layouts/CercaPrenotazione.fxml";
	private static AzioneUtente azioneUtente;
	
	public LoaderCercaPrenotazione() {}
	
	public static void loadCercaPrenotazione(AzioneUtente azioneUtente) {
		LoaderCercaPrenotazione.azioneUtente=azioneUtente;
	}

	@Override
	public void start(Stage scenaPrimaria) throws Exception {
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		try {
			Parent radice = caricatore.load();
			final Scene miaScena = new Scene(radice);
			scenaPrimaria.setScene(miaScena);
			scenaPrimaria.setResizable(false);
			scenaPrimaria.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
