package dataBaseModel;

import java.util.List;
import java.util.Map;

import model.piantina.Prenotazione;
import model.utili.Periodo;
import model.piantina.PrenotazioneEstesa;

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
