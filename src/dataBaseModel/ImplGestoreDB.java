package dataBaseModel;

import java.time.LocalDate;


import com.google.gson.Gson;

import model.Periodo;
import model.Prenotazione;

public class ImplGestoreDB implements GestoreDB {

	private Gson gson = new Gson();
	
	@Override
	public boolean creazionePrenotazione(Prenotazione p) {
		
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
		
		
		return false;
	}

}
