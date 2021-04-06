package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;

public class ImplRistorante implements Ristorante {

	
	private static String FILE_PATH = "res/restourant-conf/tavoli.txt";
	private List<Tavolo> tavoli = new ArrayList<>();
	private GestoreDB getsoreDB =  new ImplGestoreDB();
	
	
	
	public ImplRistorante() {
		try {
			loadTavolifromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void nuovaPrenotazione(PrenotazioneEstesa prenotazione) {
		//db.loadOnFile(prenotazioneEstesa);
		this.getsoreDB.addToFile(prenotazione);
	}
	
	
	public Map<String,List<Prenotazione>> getPrenotazioni(Periodo p){
		return this.getsoreDB.getMapPrenotazioni(p);
	}
	
	
	
	@Override
	public List<Tavolo> tavoliRistorante() {
		return this.tavoli;
	}

	private void loadTavolifromFile() throws IOException {
		try {
			//InputStream str = new FileInputStream(new File("res/restourant-conf/tavoli.txt"));
			FileReader f = new FileReader(FILE_PATH);
		    BufferedReader b = new BufferedReader(f);
		    String s;
		    while(true) {
		    	s = b.readLine();
		    	if(s == null) {
		    		break;
		    	}
		    	tavoli.add(new ImplTavolo(Integer.parseInt(s.split(",")[0]),Integer.parseInt(s.split(",")[1])));
		    }
		    b.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Tavolo> tavoliPrenotati(LocalDate date, Periodo p) {
		return null;
	}
	
}
