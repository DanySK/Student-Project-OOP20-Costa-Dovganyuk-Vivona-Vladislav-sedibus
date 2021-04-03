package model;


public class ImplPrenotazione implements PrenotazioneBase, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codicePrenotazione;
	private Cliente cliente;
	private Tavolo tavolo;
	private int nPostiPrenotati;

	
	
	public ImplPrenotazione(String codicePrenotazione, Cliente cliente, Tavolo tavolo, int nPostiPrenotati) {
		super();
		this.codicePrenotazione = codicePrenotazione;
		this.cliente = cliente;
		this.tavolo = tavolo;
		this.nPostiPrenotati = nPostiPrenotati;
	}	

	@Override
	public String getCodicePrenotazione() {
		return this.codicePrenotazione;
	}

	@Override
	public Cliente getCliente() {
		return this.cliente;
	}

	@Override
	public Tavolo getTavolo() {
		return this.tavolo;
	}

	@Override
	public int getPostiPrenotati() {
		return this.nPostiPrenotati;
	}


	//ritorna la prenotazione base corrente
	public PrenotazioneBase prenotazioneBase() {
			return new ImplPrenotazione(getCodicePrenotazione(),getCliente(), getTavolo(), getPostiPrenotati());
	}

	
}
