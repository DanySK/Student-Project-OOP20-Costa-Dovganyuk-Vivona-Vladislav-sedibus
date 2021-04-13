package model.creaprenotazione;

import java.time.LocalDate;
import model.piantina.Tavolo;
import model.utili.Periodo;

public interface ModelPrenotazione {
	
	/**
	 * Aggiunge una nuova prenotazione
	 * @param periodo
	 * @param data
	 * @param tavolo
	 * @param postiPrenotati
	 */
	void aggiungiPrenotazione(Periodo periodo, LocalDate data, int postiPrenotati);
	
	/**
	 * @param nome che l'utente ha inserito
	 * @param cognome che l'utente ha inserito
	 * @param email che l'utente ha inserito
	 * @param telefono che l'utente ha inserito
	 * @return vero se i dati in ingresso rispettano i controlli, falso altrimenti
	 */
	boolean prendiDati(String nome, String cognome, String email, String telefono);
	
	void prelevaIdTavolo(int idTavolo);
	
	int getMaxPosti();
	
}
