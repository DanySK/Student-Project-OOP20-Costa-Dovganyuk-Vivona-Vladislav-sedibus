package dataBaseModel;

import java.time.LocalDate;
import java.util.List;

import model.Periodo;
import model.PrenotazioneBase;
import model.PrenotazioneCompleta;
import model.PrenotazioneEstesa;

public interface GestoreDB {

	/**
	 * 
	 * @return true se l'inserimento nel DB e andato a buon fine
	 */
	boolean creazionePrenotazione(PrenotazioneEstesa p);

	/**
	 * 
	 * @param periodo
	 * @param data
	 * @return la lista delle prenotazioni per una certa data
	 */
	List<PrenotazioneBase> listaPrenotazioni(Periodo periodo,LocalDate data);
	
	
	
	
	
}
