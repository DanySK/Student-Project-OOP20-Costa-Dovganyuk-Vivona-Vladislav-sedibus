package model.creaprenotazione;

import java.time.LocalDate;

import model.utili.Cliente;
import model.utili.Periodo;

public interface ModelPrenotazione {

	/**
	 * Dal nome/id viene ricavato il tavolo scelto dall'utente
	 * @param idTavolo
	 */
	void prendiTavolo(String idTavolo);
	
	/**
	 * Necessario ad istanziare PilotaPosti (quando si modifica una prenotazione)
	 * @param posti i posti che voleva occupare il cliente
	 */
	void settaPostiModifica(int posti);
	
	/**
	 * Necessario ad istanziare PilotaPosti (quando si crea una prenotazione)
	 */
	void settaPostiCreazione();
	
	/**
	 * Prende i parametri necessari ad identificare la vecchia prenotazione
	 * @param codice il codice della vecchia prenotazione
	 * @param periodo il periodo della vecchia prenotazione
	 */
	void prendiVecchiaPrenotazione(String codice, Periodo periodo, LocalDate data);
	
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
	 * @param dataScelta la data che ha scelto il cliente
	 */
	void prendiData(LocalDate dataScelta);
	
	/**
	 * Aggiunge una nuova prenotazione
	 */
	void aggiungiPrenotazione();
	
	/**
	 * Affida al cliente il primo tavolo della piantina con le caratteristiche volute
	 * @return vero se e' stato trovato un tavolo, falso altrimenti
	 */
	boolean cercaTavolo();
	
	/**
	 * Modifica una prenotazione esistente, eliminando la vecchia ma preservando il codice
	 */
	void modificaPrenotazione();
	
}
