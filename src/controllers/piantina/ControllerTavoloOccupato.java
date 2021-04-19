package controllers.piantina;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.piantina.ImplMainTableModel;
import model.piantina.MainTableModel;
import model.piantina.Prenotazione;
import model.utili.AzioneUtente;
import model.utili.Cliente;
import model.utili.Periodo;
import model.utili.Utente;
import view.creaprenotazione.LoaderPrenotazione;
import view.riepilogo.ViewAlert;


public class ControllerTavoloOccupato implements Initializable  {

	@FXML private Text textCodice;
	@FXML private Text textData;
	@FXML private Text textPeriodo;
	private MainTableModel model = null;
	
	private Cliente cliente;
	private Prenotazione prenotazione;
	private String codicePrenotazione;
	private Periodo periodo;
	private LocalDate data;
	private int idTavolo;
	private Utente utente;
	private AzioneUtente azione;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		this.utente = Utente.ADMIN;
	}

	
	public void handlerModifica() {
		this.azione = AzioneUtente.MODIFICA;
		if(this.model == null) {
			setModel();
		}
		
		LoaderPrenotazione viewPrenotazione = new LoaderPrenotazione(this.utente, this.azione, 
				this.cliente.getNome(), this.cliente.getCognome(), 
				this.cliente.getEmail(), this.cliente.getTelefono(),
				data, periodo, String.valueOf(prenotazione.getPostiPrenotati()) , String.valueOf(this.idTavolo) , this.codicePrenotazione);
		
		try {
			viewPrenotazione.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCurrentStage();
	}
	
	public void handlerElimina() {
		if(this.model == null) {
			setModel();
		}
		
		ViewAlert alert = new ViewAlert();
		if(alert.alertEliminazionePrenotazione(prenotazione, data, periodo).equals(ButtonType.YES)) {
			//elimino effettivamente il tutto
			System.out.println("Vado ad eliminare....");
		}
		
		
	}
	
	public void handlerAnnulla() {
		closeCurrentStage();
	}
	
	
	private void closeCurrentStage() {
		var stage = (Stage) this.textCodice.getScene().getWindow();
		stage.close();
	}
	
	
	private void setModel() {
		this.periodo = Periodo.valueOf(this.textPeriodo.getText());
		this.data = LocalDate.parse(this.textData.getText());
		this.model = new ImplMainTableModel(this.periodo,this.data);
		this.codicePrenotazione = this.textCodice.getText();
		this.idTavolo = this.model.getIdTavolo(this.codicePrenotazione);
		this.prenotazione = this.model.getPrenotazione(this.codicePrenotazione);
		this.cliente = this.prenotazione.getCliente();
	}
	
}
