package controllers.piantina;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.piantina.ImplMainTableModel;
import model.piantina.MainTableModel;
import model.utili.Cliente;
import model.utili.Periodo;
import model.utili.Utente;

public class ControllerTavoloOccupato implements Initializable  {

	@FXML private Text textCodice;
	@FXML private Text textData;
	@FXML private Text textPeriodo;
	//sara necessario per poi riaprire lo stage dei tavoli in modalita ADMIN
	private final Utente utente = Utente.ADMIN;
	private MainTableModel model = null;
	
	private Cliente cliente;
	private Periodo periodo;
	private LocalDate data;
	private int idTavolo;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
	}

	
	public void handlerModifica() {
		/*
		 * vado a richiamre la loader di ScenePrenotazione passandogli gli elementi necessari
		 * a precompilare i campi delle form, e il flag che indica che si tratta di una modifica
		 */
		if(this.model == null) {
			setModel();
		}
		
		System.out.println("Cliente: " + this.cliente.getNome() +" " 
				+ this.cliente.getCognome() + " " + this.cliente.getTelefono() 
				+ " " + this.cliente.getEmail());
		
		
	}
	
	public void handlerElimina() {
		/*
		 * vado a richiamare la funzione che elimina la prenotazione, e successivamente apre una finestra per confermare l'eliminazione
		 */
		if(this.model == null) {
			setModel();
		}
	}
	
	public void handlerAnnulla() {
		/*
		 * Chiude lo stage corrente e torna alla visuale principale
		 */
		var stage = (Stage) this.textCodice.getScene().getWindow();
		stage.close();
		
		
	}
	
	private void setModel() {
		this.periodo = Periodo.valueOf(this.textPeriodo.getText());
		this.data = LocalDate.parse(this.textData.getText());
		this.model = new ImplMainTableModel(this.periodo,this.data);
		this.idTavolo = this.model.getIdTavolo(this.textCodice.getText());
		this.cliente = this.model.getCliente(idTavolo);
	}
	
}
