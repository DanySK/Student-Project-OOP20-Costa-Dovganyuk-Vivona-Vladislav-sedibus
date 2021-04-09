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
	public List<Integer> tavoliPrenotati(LocalDate date, Periodo p);
	
	
	
	
}
