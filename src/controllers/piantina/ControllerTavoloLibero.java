package controllers.piantina;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.creaprenotazione.ViewPrenotazione;

public class ControllerTavoloLibero implements Initializable {

	private final int POS_NUM_TAVOLO = 1;
	@FXML private VBox vBoxPrincipale;
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
	}
	
	
	public void handlerConferma() {
		ViewPrenotazione view = new ViewPrenotazione(new Stage());
		closeCurrentStage();
	}
	
	
	public void handlerAnnulla() {
		System.out.println("Premuto ANNULLA");
		closeCurrentStage();
	}
	
	private void closeCurrentStage() {
		var s = (Stage) this.vBoxPrincipale.getScene().getWindow();
		s.close();
	}
	
	

}
