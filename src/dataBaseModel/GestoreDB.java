package dataBaseModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.Periodo;
import model.Prenotazione;
import model.PrenotazioneEstesa;

public interface GestoreDB {

	/**
	 * 
	 * @return true se l'inserimento nel DB e andato a buon fine
	 */
	//boolean creazionePrenotazione(PrenotazioneEstesa p);

	/**
	 * 
	 * @param periodo
	 * @param data
	 * @return la lista delle prenotazioni per una certa data
	 */
	//List<Prenotazione> listaPrenotazioni(Periodo periodo,LocalDate data);
	
	public Map<String, List<Prenotazione>> getMapPrenotazioni(Periodo p);
	
	public void addToFile(PrenotazioneEstesa prenotazione);
	
	
	
}
