package dataBaseModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonWriter;

import model.Cliente;
import model.ClienteImpl;
import model.ImplPrenotazione;
import model.Periodo;
import model.PrenotazioneBase;
import model.PrenotazioneCompleta;
import model.PrenotazioneEstesa;
import model.ImplTavolo;

public class ImplGestoreDB implements GestoreDB, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private String PRANZO_FILE_PATH = "res/pranzo.json";
	private String CENA_FILE_PATH = "res/cena.json";
	private OutputStreamWriter streamWriter ;
	private JsonWriter writer;
	private File file;
    
			
			
	
	public ImplGestoreDB() {
		
		
	}
	
	
	@Override
	public boolean creazionePrenotazione(PrenotazioneEstesa p) {
		
		//scelta del file sul quale scrivere
		System.out.println("Periodo prenotazione: " + p.getPeriodo());
		
		
		try {		
			impostaJsonWriter(p.getPeriodo());
			writer.beginArray();
			writer.beginObject();
			writer.name("data").value(p.getLocalData());
			//writer.name("prenotazione").jsonValue(gson.toJson(p.prenotazioneBase()));
			
			writer.name("prenotazione");
			
			writer.beginArray();
			
			//writer.beginObject();
			//writer.name("prenotazioneinterna").jsonValue(gson.toJson(p.prenotazioneBase()));
			writer.jsonValue(gson.toJson(p.prenotazioneBase()));
			
			//writer.endObject();
			
			writer.endArray();
			
			
			writer.endObject();
			writer.endArray();
			
			writer.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    //gson.toJson(p,p.getClass(),writer);
	    
		System.out.println(gson.toJson(p));
		/*
		Periodo periodo = p.getPeriodo();
		System.out.println(periodo);
		//ho il periodo...vado a cercare il file giusto
		
		LocalDate data = p.getDataPrenotazione();
		System.out.println(data);
		//dalla data, cerco se e presente nel file
			//NO --> la creo 
		
			//SI --> vado nella sezione giusta
		
		System.out.println(gson.toJson(p.getCodicePrenotazione()));
		System.out.println(gson.toJson(p.getCliente()));
		System.out.println(gson.toJson(p.getTavolo()));
		System.out.println(gson.toJson(p.getPostiPrenotati()));
		*/
		
		return false;
	}
	
	private void impostaJsonWriter(Periodo p) throws UnsupportedEncodingException, FileNotFoundException {
		//imposto anche la variabile file, per vedere se il file esiste effettivamente
		String PATH = "";
		if(p.equals(Periodo.PRANZO)) {
			PATH = PRANZO_FILE_PATH;
		}else {
			PATH = CENA_FILE_PATH;
		}
		streamWriter = new OutputStreamWriter(new FileOutputStream(PATH),"UTF-8");
		file = new File(PATH);
		writer = new JsonWriter(streamWriter);
		
	}



	
	
	@Override
	public List<PrenotazioneBase> listaPrenotazioni(Periodo periodo, LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
