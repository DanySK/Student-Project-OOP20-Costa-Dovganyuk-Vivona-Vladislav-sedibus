package model.creaprenotazione;

import java.time.LocalDate;
import java.util.*;

import dataBaseModel.*;
import model.piantina.ImplMainTableModel;
import model.piantina.ImplRistorante;
import model.piantina.MainTableModel;
import model.piantina.PrenotazioneEstesa;
import model.piantina.Ristorante;
import model.piantina.Tavolo;
import model.utili.Cliente;
import model.utili.Periodo;

public class ModelPrenotazioneImpl implements ModelPrenotazione {
	
	private Cliente cliente;
	private int idTavolo = 0;
	private Tavolo tavoloScelto;
	private MainTableModel mtm = new ImplMainTableModel();
	private Ristorante ristorante = new ImplRistorante();
	
	public ModelPrenotazioneImpl() { }
	
	@Override
	public void aggiungiPrenotazione(Periodo periodo, LocalDate data, int postiPrenotati) {
		this.tavoloScelto = new Tavolo(this.idTavolo, this.getMaxPosti());
		this.ristorante.nuovaPrenotazione(new PrenotazioneEstesa(periodo, data, this.generaCodice(), this.cliente, this.tavoloScelto, postiPrenotati));
		
	}
	
	@Override
	public boolean prendiDati(String nome, String cognome, String email, String telefono) {
		this.cliente = new Cliente(nome, cognome, email, telefono);
		return this.cliente.rispettaControlli();
	}
	
	private String generaCodice() {
		return new GeneratoreCodice().ottieni();
	}

	@Override
	public void prelevaIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	@Override
	public int getMaxPosti() {
		return mtm.getPostiMax(this.idTavolo);
	}
	
}
