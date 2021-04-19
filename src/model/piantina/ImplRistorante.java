package model.piantina;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;
import model.utili.Periodo;

public class ImplRistorante implements Ristorante {

	
	private static String FILE_PATH = "res/restourant-conf/tavoli.txt";
	private static final int POS_ID_TAVOLO = 0;
	private static final int POS_MAX_POSTI_TAVOLO = 1;
	private List<Tavolo> tavoli = new ArrayList<>();
	private GestoreDB getsoreDB =  new ImplGestoreDB();
	private Optional<Periodo> periodoAttuale = Optional.empty();
	Map<String,List<Prenotazione>> prenotazioni = new HashMap<>();
	
	public ImplRistorante() {
		try {
			loadTavolifromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void nuovaPrenotazione(PrenotazioneEstesa prenotazione) {
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
			FileReader f = new FileReader(FILE_PATH);
		    BufferedReader b = new BufferedReader(f);
		    String s;
		    while(true) {
		    	s = b.readLine();
		    	if(s == null) {
		    		break;
		    	}
		    	tavoli.add(new Tavolo(Integer.parseInt(s.split(",")[POS_ID_TAVOLO]),Integer.parseInt(s.split(",")[POS_MAX_POSTI_TAVOLO])));
		    }
		    b.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Tavolo> tavoliPrenotati(LocalDate data, Periodo p) {
		
		var mappa = getPrenotazioni(p);
		List<Tavolo> list = new ArrayList<>();
		
		if(!mappa.isEmpty()) {
			mappa.keySet().forEach(k -> {
				if(k.equals(data.toString())) {
					mappa.get(k).forEach(e -> {
						list.add(e.getTavolo());
					});
				}
			});
		}
		
		
		return list;
		
	}
	
	
	public List<Prenotazione> getListPrenotazioni(LocalDate data, Periodo p){
		
		if(this.periodoAttuale.isEmpty()) {
			this.prenotazioni = getPrenotazioni(p);
			this.periodoAttuale = Optional.of(p);
		}
		
		
		
		for (var entry : prenotazioni.entrySet()) {
			if(entry.getKey().equals(data.toString())) {
				return entry.getValue();
				
			}
		}
		
		return new ArrayList<Prenotazione>();
	}


	@Override
	public boolean eliminaPrenotazione(Periodo p, String codicePrenotazione) {
		
		var map = getPrenotazioni(p);
		int size = map.values().size();
		
		map.entrySet().forEach(v -> v.getValue().removeIf(e -> e.getCodicePrenotazione().equals(codicePrenotazione)));
		
		if(size - map.values().size() > 0) {
			this.getsoreDB.loadMapOnFile(map, p);
			return true;
		}else {
			return false;
		}
			
		
		
	}
	
	
	
}
