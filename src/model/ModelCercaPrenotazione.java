package model;

public interface ModelCercaPrenotazione {

	/**
	 * cerca i dati nel database
	 * @param codice è il codice che il cliente ha inserito, quindi da cercare
	 * @param cognome è il cognome che il cliente ha inserito, quindi da cercare
	 * @return vero se li ha trovati, falso altrimenti
	 */
	boolean cercaDati(String codice, String cognome);
	
}
