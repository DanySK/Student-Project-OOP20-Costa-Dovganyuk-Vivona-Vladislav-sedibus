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
	
	String getCodicePrenotazione(Periodo p, LocalDate data, int idTavolo);
	
	String getCognomeNomeCliente(Periodo p, LocalDate data, int idTavolo);
	
	String getPostiPrenotati(Periodo p, LocalDate data, int idTavolo);
	
	String getNumTelefonoCliente(Periodo p, LocalDate data, int idTavolo);
	
	String getEmailCliente(Periodo p, LocalDate data, int idTavolo);
}
