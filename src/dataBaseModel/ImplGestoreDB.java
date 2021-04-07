package dataBaseModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import model.Cliente;
import model.Cliente;
import model.Prenotazione;
import model.Periodo;
import model.Prenotazione;
import model.PrenotazioneEstesa;
import model.Tavolo;

public class ImplGestoreDB implements GestoreDB {


	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static String PRANZO_FILE_PATH = "res/pranzo.json";
	private static String CENA_FILE_PATH = "res/cena.json";
	private File f;

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

	/*
	 * public void loadOnFile(PrenotazioneEstesa prenotazione) {
	 * 
	 * Map<String,List<Prenotazione>> map = new HashMap<>(); List<Prenotazione> list
	 * = new ArrayList<>(); list.add(prenotazione.getPrenotazione());
	 * map.put(prenotazione.getData(), list);
	 * 
	 * try { Writer writer =
	 * Files.newBufferedWriter(Paths.get(getPath(prenotazione.getPeriodo())));
	 * gson.toJson(map,writer); writer.close(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	/**
	 * 
	 * @param p
	 * @return il path del file in base a p
	 */
	private String getPath(Periodo p) {
		return p.equals(Periodo.PRANZO) ? PRANZO_FILE_PATH : CENA_FILE_PATH;
	}

	// ritorna la mappa dove la chiave è la data(in formato Stringa) e la lista
	// associata alla data
	public Map<String, List<Prenotazione>> getMapPrenotazioni(Periodo p) {

		// variabile "nuova" che conterrà la mappa aggiornata
		Map<String, List<Prenotazione>> mappa = new HashMap<>();
		
		
		try {
			// reader che permette di leggere dal file
			Reader reader = Files.newBufferedReader(Paths.get(getPath(p)));
			
			/*
			 * Parte della type trovata qua:
			 *  
			 * https://stackoverflow.com/questions/24765039/gson-deserialize-into-map
			 */
			
			//Type type = new TypeToken<Map<String, List<Prenotazione>>>(){}.getType();
			Type type = new TypeToken<Map<String, List<Prenotazione>>>(){}.getType();
			Map<String, List<Prenotazione>> map =  gson.fromJson(reader, type) ;
			//se il file è vuoto il map sara null e non empty
			mappa = map == null ? mappa : map;

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return mappa;
	}

	
	/**
	 * 
	 * @param prenotazione Aggiunge al file la prenotazione passata
	 */
	
	public void addToFile(PrenotazioneEstesa prenotazione) {
		// viene prelevata la mappa dal file giusto, cosi per poi aggiungere il nuovo
		// elemento
		var map = getMapPrenotazioni(prenotazione.getPeriodo());
		
		/*
		if(map.isEmpty()) {
			map.put(prenotazione.getData(), Arrays.asList(prenotazione.getPrenotazione()));
		}else {
			if(map.keySet().contains(prenotazione.getData())) {
				map.get(prenotazione.getData()).add(prenotazione.getPrenotazione());
			}else {
				map.put(prenotazione.getData(), Arrays.asList(prenotazione.getPrenotazione()));
			}
		}
		*/
		// se la mappa e vuota, o non contiene la chiave
		// faccio una put
		// altrimenti
		
		if (map.isEmpty() || !map.keySet().contains(prenotazione.getLocalData())) {
			map.put(prenotazione.getLocalData(), Arrays.asList(prenotazione.getPrenotazione()));
		} else {
			map.get(prenotazione.getLocalData()).add(prenotazione.getPrenotazione());
		}
		
		// nel set delle chiavi controllo se non è gia presente la data della
		// prenotazione
		/*
		 * if(map.keySet().contains(prenotazione.getData())) { //se la
		 * contiene allora aggiungo alla lista solo la prenotazione
		 * map.get(prenotazione.getData()).add(prenotazione.getPrenotazione()); }else {
		 * Se non esiste allora faccio una put con k=data della prenotazione e una lista
		 * contente attualmente una sola prenotazione
		 * 
		 * map.put(prenotazione.getData(),
		 * Arrays.asList(prenotazione.getPrenotazione())); }
		 */

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * private Gson gson = new GsonBuilder().setPrettyPrinting().create(); private
	 * String PRANZO_FILE_PATH = "res/pranzo.json"; private String CENA_FILE_PATH =
	 * "res/cena.json"; //private OutputStreamWriter streamWriter; //private
	 * JsonWriter writer; private File file;
	 * 
	 * public ImplGestoreDB() { createFiles(); }
	 * 
	 * private void createFiles() { if(!new File(PRANZO_FILE_PATH).exists()) {
	 * createNewFile(PRANZO_FILE_PATH); }else if(!new File(CENA_FILE_PATH).exists())
	 * { createNewFile(CENA_FILE_PATH); } }
	 * 
	 * private void createNewFile(String path) { try { new
	 * File(path).createNewFile(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * 
	 * public void loadOnFile(PrenotazioneEstesa prenotazione) {
	 * 
	 * Map<String,List<Prenotazione>> map = new HashMap<>(); List<Prenotazione> list
	 * = new ArrayList<>(); list.add(prenotazione.getPrenotazione());
	 * map.put(prenotazione.getData(), list);
	 * 
	 * try { Writer writer =
	 * Files.newBufferedWriter(Paths.get(getPath(prenotazione.getPeriodo())));
	 * gson.toJson(map,writer); writer.close(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 *//**
		 * 
		 * @param p
		 * @return il path del file in base a p
		 */
	/*
	 * private String getPath(Periodo p) { return p.equals(Periodo.PRANZO) ?
	 * PRANZO_FILE_PATH : CENA_FILE_PATH; }
	 * 
	 * 
	 * // ritorna la mappa dove la chiave è la data(in formato Stringa) e la lista
	 * // associata alla data public Map<String, List<Prenotazione>>
	 * getMapPrenotazioni(Periodo p) {
	 * 
	 * // variabile "nuova" che conterrà la mappa aggiornata Map<String,
	 * List<Prenotazione>> mappa = new HashMap<>();
	 * 
	 * 
	 * try { // reader che permette di leggere dal file Reader reader =
	 * Files.newBufferedReader(Paths.get(getPath(p)));
	 * 
	 * 
	 * Parte della type trovata qua:
	 * 
	 * https://stackoverflow.com/questions/24765039/gson-deserialize-into-map
	 * 
	 * 
	 * //Type type = new TypeToken<Map<String,
	 * List<ImplPrenotazione>>>(){}.getType();
	 * 
	 * //System.out.println("Type = " + type);
	 * 
	 * Map<String, List<Prenotazione>> map = gson.fromJson(reader, new
	 * TypeToken<Map<String, List<ImplPrenotazione>>>(){}.getType()) ; //se il file
	 * è vuoto il map sara null e non empty mappa = map == null ? mappa : map;
	 * 
	 * 
	 * 
	 * reader.close();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * return mappa;
	 * 
	 * 
	 * Map<String, List<Prenotazione>> mappa = new HashMap<>();
	 * 
	 * try { // reader che permette di leggere dal file Reader reader =
	 * Files.newBufferedReader(Paths.get(getPath(p)));
	 * 
	 * Type type = new TypeToken<Map<String, List<Prenotazione>>>(){}.getType();
	 * 
	 * Map<String, List<Prenotazione>> map = gson.fromJson(reader, type); //se il
	 * file è vuoto il map sara null e non empty mappa = map == null ? mappa : map;
	 * 
	 * reader.close();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * return mappa;
	 * 
	 * }
	 * 
	 * 
	 * 
	 *//**
		 * 
		 * @param prenotazione Aggiunge al file la prenotazione passata
		 */
	/*
	 * public void addToFile(PrenotazioneEstesa prenotazione) { // viene prelevata
	 * la mappa dal file giusto, cosi per poi aggiungere il nuovo // elemento var
	 * map = getMapPrenotazioni(prenotazione.getPeriodo());
	 * 
	 * if (map.isEmpty() || !map.keySet().contains(prenotazione.getLocalData())) {
	 * map.put(prenotazione.getLocalData(),
	 * Arrays.asList(prenotazione.getPrenotazione())); } else {
	 * map.get(prenotazione.getLocalData()).add(prenotazione.getPrenotazione()); }
	 * 
	 * 
	 * loadMapOnFile(map, prenotazione.getPeriodo());
	 * 
	 * }
	 * 
	 *//**
		 * 
		 * @param map
		 * @param p   carica su file giusto(in base al periodo) la mappa passatagli
		 *//*
			 * private void loadMapOnFile(Map<String, List<Prenotazione>> map, Periodo p) {
			 * 
			 * try { Writer writer = Files.newBufferedWriter(Paths.get(getPath(p)));
			 * gson.toJson(map, writer); writer.close(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } }
			 */

}
