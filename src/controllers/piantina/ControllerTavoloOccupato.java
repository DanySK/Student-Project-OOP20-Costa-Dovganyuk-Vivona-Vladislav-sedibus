package controllers.piantina;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ControllerTavoloOccupato implements Initializable  {

	@FXML private Text textCodice;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rsrc) {
		
		System.out.println("Codice Prenotazione = " + textCodice.getText());
	}

}
