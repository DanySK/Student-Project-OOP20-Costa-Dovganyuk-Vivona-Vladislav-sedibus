package view.riepilogo;

import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import model.piantina.Prenotazione;
import model.utili.Periodo;

public class ViewAlert {

	private String TITOLO_ELIMINAZIONE = "Conferma Eliminazione Prenotazione";
	private String HEADER_ELIMINAZIONE = "Confermi voler eliminare la prenotazione";
	
	public ButtonType alertEliminazionePrenotazione(Prenotazione p, LocalDate data, Periodo periodo) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(TITOLO_ELIMINAZIONE);
		alert.setHeaderText(HEADER_ELIMINAZIONE);
		alert.setContentText(getContenentText(p, data, periodo));
		alert.getButtonTypes().clear();
		
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.CANCEL);
		alert.showAndWait();
		
		return alert.getResult();
	}
	
	
	private String getContenentText(Prenotazione p, LocalDate data, Periodo periodo) {
		return "Codice Prenotazione: " + p.getCodicePrenotazione() + 
				"\ndel: " + data.toString() + " per " + periodo.toString() +
				"\na nome di " + p.getCliente().getNome() + " " + p.getCliente().getCognome();
	}
	
}
