package view.riepilogo;

import java.io.IOException;
import java.time.LocalDate;
import controllers.riepilogo.ControllerRiepilogo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utili.AzioneUtente;
import model.utili.Periodo;
import model.utili.Utente;

public class LoaderRiepilogo extends Application {

	private static final String PERC_SCENA = "/layouts/Riepilogo.fxml";
	private Utente utente;
	private AzioneUtente azione;
	private Periodo periodoPrenotato;
	private LocalDate dataPrenotata;
	private String idTavoloPrenotato;
	
	public LoaderRiepilogo(Utente utente, AzioneUtente azione, Periodo periodo, LocalDate data, String idTavolo) {
		this.utente = utente;
		this.azione = azione;
		this.periodoPrenotato = periodo;
		this.dataPrenotata = data;
		this.idTavoloPrenotato = idTavolo;
	}

	@Override
	public void start(Stage scenaPrimaria) throws Exception {
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		ControllerRiepilogo riepilogo = new ControllerRiepilogo(this.utente, this.azione, 
				this.periodoPrenotato, this.dataPrenotata, this.idTavoloPrenotato);
		try {
			caricatore.setController(riepilogo);
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
