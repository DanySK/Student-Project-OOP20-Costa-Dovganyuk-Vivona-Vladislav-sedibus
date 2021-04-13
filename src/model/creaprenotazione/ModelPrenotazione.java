package model.creaprenotazione;

import java.util.*;

import model.utili.Cliente;

public class ModelPrenotazione {
	
	private Cliente cliente;
	
	public ModelPrenotazione() {
	}
	
	
	
	private String generaCodice() {
		return new GeneratoreCodice().ottieni();
	}

	/**
	 * @param nome che l'utente ha inserito
	 * @param cognome che l'utente ha inserito
	 * @param email che l'utente ha inserito
	 * @param telefono che l'utente ha inserito
	 * @return vero se i dati in ingresso rispettano i controlli, falso altrimenti
	 */
	public boolean prendiDati(String nome, String cognome, String email, String telefono) {
		this.cliente = new Cliente(nome, cognome, email, telefono);
		return this.cliente.rispettaControlli();
	}
	
}
