package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

//la classe carica il file fxml nel costruttore e mette a disposizione i getter per i campi e i bottoni;
//più avanti dovrò aggiungere anche i setter per i campi TextField -> MODIFICA PRENOTAZIONE
public class ViewPrenotazione {
	
	private FXMLLoader loader;
	
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
	
	public Button getBottonePrenota() {
		return (Button)this.loader.getNamespace().get("bottonePrenota");
	}
	
	public Button getBottoneReset() {
		return (Button)this.loader.getNamespace().get("bottoneReset");
	}
	
	public Button getBottoneAnnulla() {
		return (Button)this.loader.getNamespace().get("bottoneAnnulla");
	}
	
	public TextField getCampoNome() {
		return (TextField)this.loader.getNamespace().get("testoNome");
	}
	
	public TextField getCampoCognome() {
		return (TextField)this.loader.getNamespace().get("testoCognome");
	}
	
	public TextField getCampoEmail() {
		return (TextField)this.loader.getNamespace().get("testoEmail");
	}
	
	public TextField getCampoTelefono() {
		return (TextField)this.loader.getNamespace().get("testoTelefono");
	}
	
	public DatePicker getCampoData() {
		return (DatePicker)this.loader.getNamespace().get("testoData");
	}
	
	public Button getBottonePiuPosti() {
		return (Button)this.loader.getNamespace().get("bottonePiuPosti");
	}
	
	public Button getBottoneMenoPosti() {
		return (Button)this.loader.getNamespace().get("bottoneMenoPosti");
	}
	
	public RadioButton getBottoneTurno() {
		ToggleGroup tg = (ToggleGroup)this.loader.getNamespace().get("turno");
		return (RadioButton)tg.getSelectedToggle();
	}
	
	public TextField getCampoNposti() {
		return (TextField)this.loader.getNamespace().get("testoPosti");
	}
	
}
