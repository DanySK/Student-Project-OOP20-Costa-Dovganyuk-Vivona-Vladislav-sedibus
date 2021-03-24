package model;

import java.time.LocalDate;

public interface Prenotazione {

	
	/**
	 * 
	 * @return Tavolo inerente alla prenotazione
	 */
	Tavolo getTavolo();
	
	/**
	 * 
	 * @return Cliente inerente prenotazione
	 */
	Cliente getCliente();
	
	/**
	 * 
	 * @return il codice della prenotazione
	 */
	String getCodicePrenotazione();
	
	/**
	 * 
	 * @return data della prenotazione
	 */
	LocalDate getDataPrenotazione();
	
	/**
	 * 
	 * @return il periodo per il quale e stata fatta la prenotazione
	 */
	Periodo getPeriodo();
	
	/**
	 * 
	 * @return il numero di posti prenotati
	 */
	int getPostiPrenotati();
}
