package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Ristorante {

	/**
	 * 
	 * @return la lista di tutti i tavoli del ristorante
	 */
	List<Tavolo> tavoliRistorante();
	
	/**
	 * 
	 * @param date
	 * @return la lista dei tavoli prenotati per quella data
	 */
	List<Tavolo> tavoliPrenotati(LocalDate date, Periodo p);
	
	public void nuovaPrenotazione(PrenotazioneEstesa prenotazione);
	
	public Map<String,List<Prenotazione>> getPrenotazioni(Periodo p);
	
}
