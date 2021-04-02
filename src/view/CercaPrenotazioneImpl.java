package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CercaPrenotazioneImpl extends Application implements CercaPrenotazione  {

	private static final String PERC_SCENA = "/layouts/CercaPrenotazione.fxml";
	
	private  Stage scenaPrimaria;
	private  TextField campoCod;
	private  TextField campoCognome;
	private  Label testoErrore;
	private  Button bottoneConferma;
	private  Button bottoneAnnulla;
	
	public CercaPrenotazioneImpl() {
		
	}
	
	@Override
	public void inizia() {
		/*this.testoErrore.setVisible(false);
		this.scenaPrimaria.show();*/
		launch();
	}

	private void initialize(FXMLLoader caricatore) {
		this.campoCod = (TextField) caricatore.getNamespace().get("testoCodice");
		this.campoCognome = (TextField) caricatore.getNamespace().get("testoCognome");
		this.testoErrore = (Label) caricatore.getNamespace().get("testoErrore");
		this.bottoneConferma = (Button) caricatore.getNamespace().get("bottoneConferma");
		this.bottoneAnnulla = (Button) caricatore.getNamespace().get("bottoneAnnulla");
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

	@Override
	public void start(Stage scenaPrimaria ) throws Exception {
		// TODO Auto-generated method stub
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		try {
			Parent radice;
			radice = caricatore.load();
			final Scene miaScena = new Scene(radice);
			scenaPrimaria.setScene(miaScena);
			scenaPrimaria.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize(caricatore);
		
		this.testoErrore.setVisible(false);
		scenaPrimaria.show();
	}

}
