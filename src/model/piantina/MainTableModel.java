package model.piantina;

import java.time.LocalDate;
import java.util.List;

import model.utili.Cliente;
import model.utili.Periodo;

public interface MainTableModel {

	/**
	 * 
	 * @param date
	 * @param p
	 * @return la lista degli ID dei tavoli prenotati 
	 */
	List<Integer> tavoliPrenotati(LocalDate date, Periodo p);
	
	/**
	 * 
	 * @param ID
	 * @return max numero di posti
	 */
	int getPostiMax(int ID);
	
	/**
	 * 
	 * @param idTavolo
	 * @return il codice prenotazione inerente a quel tavolo
	 */
	String getCodicePrenotazione(int idTavolo);
	
	/**
	 * 
	 * @param idTavolo
	 * @return Cognome e Nome del cliente come unica Stringa
	 */
	String getCognomeNomeCliente(int idTavolo);
	
	/**
	 * 
	 * @param idTavolo
	 * @return il numero di posti prenotati per quel tavolo
	 */
	String getPostiPrenotati(int idTavolo);
	
	/**
	 * 
	 * @param idTavolo
	 * @return il numero di telefono del Cliente che si e prenotato per tale tavolo
	 */
	String getNumTelefonoCliente(int idTavolo);
	
	/**
	 * 
	 * @param idTavolo
	 * @return la mail del cliente che si e prenotato per tale tavolo
	 */
	String getEmailCliente(int idTavolo);
	
	Cliente getCliente(int idTavolo);
	
	/**
	 * 
	 * @param codicePrenotazione
	 * @return la prenotazione completa avente come codicePrenotazione lo stesso passatogli in funzione
	 */
	Prenotazione getPrenotazione(String codicePrenotazione);
	
	int getIdTavolo(String codicePrenotazione);
}
