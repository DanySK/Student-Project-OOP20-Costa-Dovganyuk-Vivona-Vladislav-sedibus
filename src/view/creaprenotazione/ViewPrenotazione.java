package view.creaprenotazione;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewPrenotazione {
	
	private FXMLLoader loader;
	private TextField testoNome;
	private TextField testoCognome;
	private TextField testoEmail;
	private TextField testoTelefono;
	private DatePicker testoData;
	private ToggleGroup turno;
	private Label testoPosti;
	private Button bottonePiuPosti;
	private Button bottoneMenoPosti;
	private Button bottonePrenota;
	private Button bottoneReset;
	private Button bottoneAnnulla;
	
	public ViewPrenotazione(Stage primaryStage) {
		try {
			this.loader = new FXMLLoader(getClass().getResource("/layouts/ScenePrenotazione.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);  //cos� non si trascinano pi� i bordi
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.testoNome = (TextField) this.loader.getNamespace().get("testoNome");
		this.testoCognome = (TextField) this.loader.getNamespace().get("testoCognome");
		this.testoEmail = (TextField) this.loader.getNamespace().get("testoEmail");
		this.testoTelefono = (TextField) this.loader.getNamespace().get("testoTelefono");
		this.testoData = (DatePicker) this.loader.getNamespace().get("testoData");
		this.turno = (ToggleGroup) this.loader.getNamespace().get("turno");
		this.testoPosti = (Label) this.loader.getNamespace().get("testoPosti");
		this.bottonePiuPosti = (Button) this.loader.getNamespace().get("bottonePiuPosti");
		this.bottoneMenoPosti = (Button) this.loader.getNamespace().get("bottoneMenoPosti");
		this.bottonePrenota = (Button) this.loader.getNamespace().get("bottonePrenota");
		this.bottoneReset = (Button) this.loader.getNamespace().get("bottoneReset");
		this.bottoneAnnulla = (Button) this.loader.getNamespace().get("bottoneAnnulla");
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
		RadioButton bottoneSelezionato = (RadioButton) this.turno.getSelectedToggle();
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
	
	public void pulisciCampi() {  //potrebbe andare nel controller
		this.testoNome.clear();
		this.testoCognome.clear();
		this.testoEmail.clear();
		this.testoTelefono.clear();
		this.testoData.getEditor().clear();
		this.turno.getSelectedToggle().setSelected(false);
	}
	
}
