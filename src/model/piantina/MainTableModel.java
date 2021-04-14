package model.piantina;

import java.time.LocalDate;
import java.util.List;

import model.utili.Periodo;

public interface MainTableModel {

	/**
	 * 
	 * @param date
	 * @param p
	 * @return la lista degli ID dei tavoli prenotati 
	 */
	List<Integer> tavoliPrenotati(LocalDate date, Periodo p);
	
	int getPostiMax(int ID);
	
	String getCodicePrenotazione(int idTavolo);
	
	String getCognomeNomeCliente(int idTavolo);
	
	String getPostiPrenotati(int idTavolo);
	
	String getNumTelefonoCliente(int idTavolo);
	
	String getEmailCliente(int idTavolo);
}
