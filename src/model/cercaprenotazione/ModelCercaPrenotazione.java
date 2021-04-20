package model.cercaprenotazione;

import java.time.LocalDate;

import model.piantina.Prenotazione;
import model.utili.Periodo;

public interface ModelCercaPrenotazione {

	/**
	 * @param cod e' il codice inserito
	 * @param cognome e' il cognome inserito
	 * @param turno e' il turno scelto
	 */
	void prendiDati(String cod, String cognome, Periodo periodo);
	
	/**
	 * cerca i dati nel database
	 * @return vero se vengono trovati nel db, falso altrimenti
	 */
	boolean cercaDati();
	
	/**
	 * @return la prenotazione fatta dal cliente
	 */
	Prenotazione getPrenotazione();
	
	/**
	 * @return il nome preso dalla prenotazione del cliente
	 */
	String getNome();
	
	/**
	 * @return l'email presa dalla prenotazione del cliente
	 */
	String getEmail();
	
	/**
	 * @return il telefono preso dalla prenotazione del cliente
	 */
	String getTelefono();
	
	/**
	 * @return la data della prenotazione fatta dal cliente
	 */
	LocalDate getData();
	
	/**
	 * @return il numero dei posti prenotati dal cliente
	 */
	String getPosti();
	
	/**
	 * @return l'id/nome del tavolo occupato dal cliente
	 */
	String getIdTavolo();

	/**
	 * elimina la prenotazione 
	 */
	boolean eliminaPrenotazione();
	
}
