package model.piantina;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.utili.Periodo;

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
	
	/**
	 * 
	 * @param prenotazione
	 * va a richiamare la funzione del gestore db per l'aggiunta della prenotazione al DB
	 */
	public void nuovaPrenotazione(PrenotazioneEstesa prenotazione);
	
	/**
	 * 
	 * @param p
	 * @return la mappa delle prenotazioni di un certo Periodo p
	 */
	public Map<String,List<Prenotazione>> getPrenotazioni(Periodo p);
	
	
	
	List<Prenotazione> getListPrenotazioni(LocalDate data, Periodo p);
}
