package model.creaprenotazione;

import java.time.LocalDate;
import java.util.*;

import dataBaseModel.*;
import model.piantina.PrenotazioneEstesa;
import model.piantina.Tavolo;
import model.utili.Cliente;
import model.utili.Periodo;

public class ModelPrenotazioneImpl implements ModelPrenotazione {
	
	private Cliente cliente;
	private GestoreDB db = new ImplGestoreDB();
	
	public ModelPrenotazioneImpl() { }
	
	@Override
	public void aggiungiPrenotazione(Periodo periodo, LocalDate data, Tavolo tavolo, int postiPrenotati) {
		this.db.addToFile(new PrenotazioneEstesa(periodo, data, this.generaCodice(), this.cliente, tavolo, postiPrenotati));
	}
	
	@Override
	public boolean prendiDati(String nome, String cognome, String email, String telefono) {
		this.cliente = new Cliente(nome, cognome, email, telefono);
		return this.cliente.rispettaControlli();
	}
	
	private String generaCodice() {
		return new GeneratoreCodice().ottieni();
	}
	
}
