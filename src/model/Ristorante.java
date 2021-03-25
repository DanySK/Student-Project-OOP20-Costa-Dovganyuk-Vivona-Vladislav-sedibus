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
	List<Tavolo> tavoliPrenotati(LocalDate date);
	
	/**
	 * @param p
	 * @return la lista di tutte le prenotazioni
	 */
	List<Map<LocalDate,List<PrenotazioneCompleta>>> tuttePrenotazioni(Periodo p);
	
	/**
	 * 
	 * @param date
	 * @param p
	 * @return la lista di prenotazioni in una certa data e in un certo periodo
	 */
	List<PrenotazioneBase> prenotazioniInData(LocalDate date, Periodo p);
	
}
