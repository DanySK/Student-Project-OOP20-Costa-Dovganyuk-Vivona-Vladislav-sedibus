package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CercaPrenotazioneImpl implements CercaPrenotazione {

	private static final String PERC_SCENA = "/layouts/CercaPrenotazione.fxml";
	
	private final Stage scenaPrimaria;
	private final  TextField campoCod;
	private final TextField campoCognome;
	private final Label testoErrore;
	private final Button bottoneConferma;
	private final Button bottoneAnnulla;
	
	public CercaPrenotazioneImpl(final Stage scenaPrimaria) {
		this.scenaPrimaria = scenaPrimaria;
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		try {
			Parent radice;
			radice = caricatore.load();
			final Scene miaScena = new Scene(radice);
			scenaPrimaria.setScene(miaScena);
			scenaPrimaria.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.campoCod = (TextField) caricatore.getNamespace().get("testoCodice");
		this.campoCognome = (TextField) caricatore.getNamespace().get("testoCognome");
		this.testoErrore = (Label) caricatore.getNamespace().get("testoErrore");
		this.bottoneConferma = (Button) caricatore.getNamespace().get("bottoneConferma");
		this.bottoneAnnulla = (Button) caricatore.getNamespace().get("bottoneAnnulla");
	}
	
	@Override
	public void inizia() {
		this.testoErrore.setVisible(false);
		this.scenaPrimaria.show();
	}

	@Override
	public void datiIncorretti() {
		this.testoErrore.setVisible(true);
	}

	@Override
	public void prossimaPagina() {
		// TODO Auto-generated method stub
	}

	@Override
	public void precedentePagina() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getCodice() {
		return this.campoCod.getText();
	}

	@Override
	public String getCognome() {
		return this.campoCognome.getText();
	}
	
	@Override
	public Button getBottoneConferma() {
		return this.bottoneConferma;
	}

	@Override
	public Button getBottoneAnnulla() {
		return this.bottoneAnnulla;
	}

}
