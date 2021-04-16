package view.creaprenotazione;

import java.io.IOException;
import java.time.LocalDate;

import controllers.creaprenotazione.ControllerPrenotazione;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.utili.AzioneUtente;
import model.utili.Periodo;

public class LoaderPrenotazione extends Application {

	private static final String PERC_SCENA = "/layouts/ScenePrenotazione.fxml";
	private static AzioneUtente azione;
	private DatePicker testoData;
	private LocalDate data;
	private ChoiceBox<Periodo> testoPeriodo;
	private Periodo periodo;
	private Label etichettaTavolo;
	private String idTavolo;
	
	//MODIFICA
	private String vecchioNome;
	private TextField testoNome;
	private String vecchioCognome;
	private TextField testoCognome;
	private String vecchiaEmail;
	private TextField testoEmail;
	private String vecchioTelefono;
	private TextField testoTelefono;
	private String vecchiPosti;
	private Label testoPosti;
	
	public LoaderPrenotazione(AzioneUtente azione, Periodo periodo, LocalDate data, String idTavolo) {
		LoaderPrenotazione.azione = azione;
		this.data = data;
		this.periodo = periodo;
		this.idTavolo = idTavolo;
	}
	
	public LoaderPrenotazione(AzioneUtente azione, String nome, String cognome, String email, String telefono, LocalDate data, Periodo periodo, String nPosti, String idTavolo) {
		this(azione, periodo, data, idTavolo);
		this.vecchioNome = nome;
		this.vecchioCognome = cognome;
		this.vecchiaEmail = email;
		this.vecchioTelefono = telefono;
		this.vecchiPosti = nPosti;
	}
	
	@Override
	public void start(Stage scenaPrimaria) throws Exception {
		final FXMLLoader caricatore = new FXMLLoader(getClass().getResource(PERC_SCENA));
		ControllerPrenotazione crea = new ControllerPrenotazione(this.idTavolo, LoaderPrenotazione.azione);
		try {
			caricatore.setController(crea);
			final Parent radice = caricatore.load();
			final Scene miaScena = new Scene(radice);
			scenaPrimaria.setScene(miaScena);
			scenaPrimaria.setResizable(false);
			
			this.testoData = (DatePicker) caricatore.getNamespace().get("testoData");
			this.testoData.setValue(this.data);
			
			this.testoPeriodo = (ChoiceBox<Periodo>) caricatore.getNamespace().get("testoPeriodo");
			this.testoPeriodo.setValue(this.periodo);
			this.testoPeriodo.getItems().addAll(Periodo.PRANZO, Periodo.CENA);
			
			this.etichettaTavolo = (Label) caricatore.getNamespace().get("etichettaTavolo");
			this.etichettaTavolo.setText("Tavolo " + this.idTavolo);
			
			if(LoaderPrenotazione.azione.equals(AzioneUtente.MODIFICA)) {
				this.testoNome = (TextField) caricatore.getNamespace().get("testoNome");
				this.testoNome.setText(this.vecchioNome);
				this.testoCognome = (TextField) caricatore.getNamespace().get("testoCognome");
				this.testoCognome.setText(this.vecchioCognome);
				this.testoEmail = (TextField) caricatore.getNamespace().get("testoEmail");
				this.testoEmail.setText(this.vecchiaEmail);
				this.testoTelefono = (TextField) caricatore.getNamespace().get("testoTelefono");
				this.testoTelefono.setText(this.vecchioTelefono);
				this.testoPosti = (Label) caricatore.getNamespace().get("testoPosti");
				this.testoPosti.setText(this.vecchiPosti);
			} else {
				this.testoPeriodo.setDisable(true);
				this.testoData.setDisable(true);
			}
			
			scenaPrimaria.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
