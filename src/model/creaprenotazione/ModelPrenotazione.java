package model.creaprenotazione;

import java.time.LocalDate;

import model.piantina.PrenotazioneEstesa;
import model.piantina.Tavolo;
import model.utili.Periodo;

public interface ModelPrenotazione {

	/**
	 * Dal nome/id viene ricavato il tavolo scelto dall'utente
	 * @param idTavolo
	 */
	void prendiTavolo(String idTavolo);
	
	/**
	 * Aumenta di 1 i posti che il cliente vuole occupare
	 */
	void incrementaPosti();
	
	/**
	 * Diminuisce di 1 i posti che il cliente vuole occupare
	 */
	void decrementaPosti();
	
	/**
	 * Porta i posti che il cliente puo' occupare al minimo
	 */
	void inizializzaPosti();
	
	/**
	 * @return i posti che il cliente vuole occupare
	 */
	int postiCorrenti();
	
	/**
	 * @param nome che l'utente ha inserito
	 * @param cognome che l'utente ha inserito
	 * @param email che l'utente ha inserito
	 * @param telefono che l'utente ha inserito
	 * @return vero se i dati in ingresso rispettano i controlli, falso altrimenti
	 */
	boolean prendiDatiCliente(String nome, String cognome, String email, String telefono);
	
	/**
	 * Estrapola il periodo dalla stringa in input
	 * @param periodo
	 */
	void prendiPeriodo(String periodo);
	
	/**
	 * Aggiunge una nuova prenotazione
	 * @param data
	 */
	void aggiungiPrenotazione(LocalDate data);
	
	void eleminaVecchiaPrenotazione(PrenotazioneEstesa pe);
	
}
