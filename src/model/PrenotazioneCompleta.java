package model;

import java.time.LocalDate;

public interface PrenotazioneCompleta {

	/**
	 * 
	 * @return la prenotazione base
	 */
	PrenotazioneBase prenotazione();
	
	/**
	 * 
	 * @return la data delle prenotazioni
	 */
	LocalDate dataPrenotazioni();
	
	/**
	 * 
	 * @return il periodo della prenotazione
	 */
	Periodo periodoPrenotato();
	
}
