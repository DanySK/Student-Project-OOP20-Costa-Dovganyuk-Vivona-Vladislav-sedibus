package view;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewPrenotazione {
	
	private FXMLLoader loader;
	@FXML private TextField testoNome;
	@FXML private TextField testoCognome;
	@FXML private TextField testoEmail;
	@FXML private TextField testoTelefono;
	@FXML private DatePicker testoData;
	@FXML private ToggleGroup turno;
	@FXML private TextField testoPosti;
	@FXML private Button bottonePiuPosti;
	@FXML private Button bottoneMenoPosti;
	@FXML private Button bottonePrenota;
	@FXML private Button bottoneReset;
	@FXML private Button bottoneAnnulla;
	
	
	public ViewPrenotazione(Stage primaryStage) {
		try {
			this.loader = new FXMLLoader(getClass().getResource("/layouts/ScenePrenotazione.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);  //così non si trascinano più i bordi
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getCampoNome() {
		return this.testoNome.getText();
	}
	
	public void setCampoNome(String nome) {
		this.testoNome.setText(nome);
	}
	
	public String getCampoCognome() {
		return this.testoCognome.getText();
	}
	
	public void setCampoCognome(String cognome) {
		this.testoCognome.setText(cognome);
	}
	
	public String getCampoEmail() {
		return this.testoEmail.getText();
	}
	
	public void setCampoEmail(String email) {
		this.testoEmail.setText(email);
	}
	
	public String getCampoTelefono() {
		return this.testoTelefono.getText();
	}
	
	public void setCampoTelefono(String telefono) {
		this.testoTelefono.setText(telefono);
	}
	
	public String getCampoData() {
		return this.testoData.getValue().toString();
	}
	
	public void setCampoData(LocalDate data) {
		this.testoData.setValue(data);
	}
	
	public String getBottoneTurno() {
		RadioButton bottoneSelezionato = (RadioButton) turno.getSelectedToggle();
		return bottoneSelezionato.getText();
	}
	
	public String getCampoPosti() {
		return this.testoPosti.getText();
	}
	
	public void setCampoPosti(String nPosti) {
		this.testoPosti.setText(nPosti);
	}
	
	public Button getBottonePiuPosti() {
		return this.bottonePiuPosti;
	}
	
	public Button getBottoneMenoPosti() {
		return this.bottoneMenoPosti;
	}
	
	public Button getBottonePrenota() {
		return this.bottonePrenota;
	}
	
	public Button getBottoneReset() {
		return this.bottoneReset;
	}
	
	public Button getBottoneAnnulla() {
		return this.bottoneAnnulla;
	}
	
	
	
}
