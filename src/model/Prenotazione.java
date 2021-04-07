package model;


public class Prenotazione  {

	private String codicePrenotazione;
	private Cliente cliente;
	private Tavolo tavolo;
	private int nPostiPrenotati;

	
	
	public Prenotazione(String codicePrenotazione, Cliente cliente, Tavolo tavolo, int nPostiPrenotati) {
		super();
		this.codicePrenotazione = codicePrenotazione;
		this.cliente = cliente;
		this.tavolo = tavolo;
		this.nPostiPrenotati = nPostiPrenotati;
	}	

	
	public String getCodicePrenotazione() {
		return this.codicePrenotazione;
	}

	
	public Cliente getCliente() {
		return this.cliente;
	}

	
	public Tavolo getTavolo() {
		return this.tavolo;
	}

	
	public int getPostiPrenotati() {
		return this.nPostiPrenotati;
	}

	//ritorna la prenotazione base corrente
		public Prenotazione getPrenotazione() {
				return new Prenotazione(getCodicePrenotazione(),getCliente(), getTavolo(), getPostiPrenotati());
		}
	

}
