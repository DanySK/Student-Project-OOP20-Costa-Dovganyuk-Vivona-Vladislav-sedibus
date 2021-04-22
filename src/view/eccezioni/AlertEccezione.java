package view.eccezioni;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public final class AlertEccezione {

	private static final String MEX_ERRORE = "Attenzione si e\' verificato un errore";
	private Alert alert;
	
	/**
	 * shows the exception to the user
	 * @param mex the message of the exception
	 */
	public void err(String mex) {
		this.alert = new Alert(AlertType.ERROR);
		this.alert.setTitle(MEX_ERRORE);
		this.alert.setResizable(false);
		this.alert.setHeaderText(mex);
		this.alert.showAndWait();
	}
	
}
