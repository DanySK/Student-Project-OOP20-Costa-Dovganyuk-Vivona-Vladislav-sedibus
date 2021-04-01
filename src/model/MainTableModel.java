package model;

import java.time.LocalDate;
import java.util.List;

public interface MainTableModel {

	/**
	 * 
	 * @param date
	 * @param p
	 * @return la lista degli ID dei tavoli prenotati 
	 */
	public List<Integer> tavoliPrenotati(LocalDate date, Periodo p);
	
	
	
	
}
