package dataBaseModel;

import model.PrenotazioneCompleta;

public interface GestoreDB {

	/**
	 * 
	 * @return true se l'inserimento nel DB e andato a buon fine
	 */
	boolean creazionePrenotazione(PrenotazioneCompleta p);

	
	
	
	
	
}
