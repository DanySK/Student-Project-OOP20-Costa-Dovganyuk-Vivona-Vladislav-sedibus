package model;

import java.util.Date;

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
	Date getDataPrenotazione();
	
	/**
	 * 
	 * @return il periodo per il quale e stata fatta la prenotazione
	 */
	Periodo getPeriodo();
	
}
