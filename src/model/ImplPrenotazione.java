package model;

import java.time.LocalDate;

public class ImplPrenotazione implements Prenotazione {

	private Cliente cliente;
	private Tavolo tavolo;
	private String codicePrenotazione;
	private LocalDate dataPrenotazione;
	private Periodo periodo;
	private int postiPrenotati;
	
	public ImplPrenotazione(Periodo periodo, LocalDate data,String codice, Cliente cliente, Tavolo tavolo, int postiPrenotati) {
		this.cliente = cliente;
		this.tavolo = tavolo;
		this.codicePrenotazione = codice;
		this.dataPrenotazione = data;
		this.periodo = periodo;
		this.postiPrenotati = postiPrenotati;
	}
	
	
	@Override
	public Tavolo getTavolo() {
		return this.tavolo;
	}

	@Override
	public Cliente getCliente() {
		return this.cliente;
	}

	@Override
	public String getCodicePrenotazione() {
		return this.codicePrenotazione;
	}

	@Override
	public LocalDate getDataPrenotazione() {
		return this.dataPrenotazione;
	}


	@Override
	public Periodo getPeriodo() {
		return this.periodo;
	}


	@Override
	public int getPostiPrenotati() {
		return this.postiPrenotati;
	}

}
