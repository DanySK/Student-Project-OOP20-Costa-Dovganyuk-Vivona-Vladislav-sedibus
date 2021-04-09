package view.cercaprenotazione;

import javafx.scene.control.Button;

public interface CercaPrenotazione {
	
	/**
	 * mostra la schermata per cercare una prenotazione
	 */
	void inizia();
	
	/**
	 * mostra il messaggio di errore nella schermata
	 */
	void datiIncorretti();
	
	/**
	 * permette di collegarsi alla schermata riepilogativa
	 */
	void prossimaPagina();
	
	/**
	 * permette di collegarsi alla schermata precedente a questa
	 */
	void precedentePagina();
	
	/**
	 * @return il codice inserito dall'utente
	 */
	String getCodice();
	
	/**
	 * @return il cognome inserito dal'utente
	 */
	String getCognome();
	
	/**
	 * @return il bottone che conferma i dati inseriti
	 */
	Button getBottoneConferma();
	
	/**
	 * @return il bottone che riporta alla schermata precedente
	 */
	Button getBottoneAnnulla();
	
}
