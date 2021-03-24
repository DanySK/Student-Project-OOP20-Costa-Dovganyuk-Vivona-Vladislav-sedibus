package dataBaseModel;

import model.Prenotazione;

public interface GestoreDB {

	/**
	 * 
	 * @return true se l'inserimento nel DB e andato a buon fine
	 */
	boolean creazionePrenotazione(Prenotazione p);

	
	
	
	
	
}
