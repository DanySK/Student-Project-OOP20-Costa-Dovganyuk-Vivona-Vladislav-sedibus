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


public class ControllerTavoloOccupato implements Initializable  {

	@FXML private Text textCodice;
	@FXML private Text textData;
	@FXML private Text textPeriodo;
	private MainTableModel model = null;
	
	private Cliente cliente;
	private Periodo periodo;
	private LocalDate data;
	private int idTavolo;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
	}

	
	public void handlerModifica() {
		if(this.model == null) {
			setModel();
		}
		
		System.out.println("Cliente: " + this.cliente.getNome() +" " 
				+ this.cliente.getCognome() + " " + this.cliente.getTelefono() 
				+ " " + this.cliente.getEmail());
		
		
	}
	
	public void handlerElimina() {
		if(this.model == null) {
			setModel();
		}
	}
	
	public void handlerAnnulla() {
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
