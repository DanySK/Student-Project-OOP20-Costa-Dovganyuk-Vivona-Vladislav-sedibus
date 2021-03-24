package model;

import java.util.Date;

public class ImplPrenotazione implements Prenotazione {

	private Cliente cliente;
	private Tavolo tavolo;
	private String codicePrenotazione;
	private Date dataPrenotazione;
	private Periodo periodo;
	
	public ImplPrenotazione(Cliente cliente, Tavolo tavolo, String codice, Date data, Periodo periodo) {
		this.cliente = cliente;
		this.tavolo = tavolo;
		this.codicePrenotazione = codice;
		this.dataPrenotazione = data;
		this.periodo = periodo;
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
	public Date getDataPrenotazione() {
		return this.dataPrenotazione;
	}


	@Override
	public Periodo getPeriodo() {
		return this.periodo;
	}

}
