package dataBaseModel;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.piantina.Prenotazione;
import model.utili.Periodo;
import model.piantina.PrenotazioneEstesa;

public class ImplGestoreDB implements GestoreDB {


	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	//private static String PRANZO_FILE_PATH = "res/pranzo.json";
	//private static String CENA_FILE_PATH = "res/cena.json";

	private static String PRANZO_FILE_PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "pranzo.json";  
	private static String CENA_FILE_PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "cena.json";
	
	/**
	 *  System.getProperty("user.home")
            + System.getProperty("file.separator")
            + BadIOGUI.class.getSimpleName() + ".txt";
	 */
	
	
	public ImplGestoreDB() {
		createFiles();
	}

	private void createFiles() {
		if(!new File(PRANZO_FILE_PATH).exists()) {
			createNewFile(PRANZO_FILE_PATH);
		}else if(!new File(CENA_FILE_PATH).exists()) {
			createNewFile(CENA_FILE_PATH);
		}
	}
	
	private void createNewFile(String path) {
		try {
			new File(path).createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getPath(Periodo p) {
		return p.equals(Periodo.PRANZO) ? PRANZO_FILE_PATH : CENA_FILE_PATH;
	}

	// ritorna la mappa dove la chiave e la data(in formato Stringa) e la lista di prenotazioni1
	// associati alla data
	public Map<String, List<Prenotazione>> getMapPrenotazioni(Periodo p) {
		// variabile "nuova" che conterra la mappa aggiornata
		Map<String, List<Prenotazione>> mappa = new HashMap<>();
		try {
			// reader che permette di leggere dal file
			Reader reader = Files.newBufferedReader(Paths.get(getPath(p)));
			
			/*
			 * Parte della type trovata qua:
			 *  
			 * https://stackoverflow.com/questions/24765039/gson-deserialize-into-map
			 */
			Type type = new TypeToken<Map<String, List<Prenotazione>>>(){}.getType();
			Map<String, List<Prenotazione>> map =  gson.fromJson(reader, type) ;
			//se il file e vuoto il map sara null e non empty
			mappa = map == null ? mappa : map;

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return mappa;
	}

	
	public void addToFile(PrenotazioneEstesa prenotazione) {
		// viene prelevata la mappa dal file giusto, cosi per poi aggiungere il nuovo elemento
		var map = getMapPrenotazioni(prenotazione.getPeriodo());
		
		if (map.isEmpty() || !map.keySet().contains(prenotazione.getLocalData())) {
			map.put(prenotazione.getLocalData(), Arrays.asList(prenotazione.getPrenotazione()));
		} else {
			map.get(prenotazione.getLocalData()).add(prenotazione.getPrenotazione());
		}
		
		loadMapOnFile(map, prenotazione.getPeriodo());

	}

	/**
	 * 
	 * @param map
	 * @param p   carica su file giusto(in base al periodo) la mappa passatagli
	 */
	private void loadMapOnFile(Map<String, List<Prenotazione>> map, Periodo p) {

		try {
			Writer writer = Files.newBufferedWriter(Paths.get(getPath(p)));
			gson.toJson(map, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
