package dataBaseModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.Prenotazione;
import model.Periodo;
import model.Prenotazione;
import model.PrenotazioneEstesa;

public interface GestoreDB {


	/**
	 * 
	 * @param p
	 * @return la mappa delle prenotazioni in un dato periodo
	 */
	public Map<String, List<Prenotazione>> getMapPrenotazioni(Periodo p);
	
	
	/**
	 * 
	 * @param prenotazione
	 * aggiunge al file la prenotazione passatagli
	 */
	public void addToFile(PrenotazioneEstesa prenotazione);
	
	
	
}
