package dataBaseModel;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import model.Cliente;
import model.ClienteImpl;
import model.ImplPrenotazione;
import model.Periodo;
import model.PrenotazioneBase;
import model.PrenotazioneCompleta;
import model.ImplTavolo;

public class ImplGestoreDB implements GestoreDB, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private FileWriter fw;
	
	
	public ImplGestoreDB() {
		try {
			this.fw = new FileWriter("res/prenotazione.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean creazionePrenotazione(PrenotazioneCompleta p) {
		
		/*
		try {
			gson.toJson(p,fw);
			System.out.println("Stampa avvenuta");
		} catch (JsonIOException e) {
			e.printStackTrace();
		} 
		*/
		
		
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

}
