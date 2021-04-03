package model;

import java.time.LocalDate;

public interface PrenotazioneBase {

	
	/**
	 * 
	 * @return il codice della prenotazione
	 */
	String getCodicePrenotazione();
	
	
	/**
	 * 
	 * @return Cliente inerente prenotazione
	 */
	Cliente getCliente();
	
	
	/**
	 * 
	 * @return Tavolo inerente alla prenotazione
	 */
	Tavolo getTavolo();

	
	/**
	 * 
	 * @return il numero di posti prenotati
	 */
	int getPostiPrenotati();
	
	public PrenotazioneBase prenotazioneBase();
	
}
