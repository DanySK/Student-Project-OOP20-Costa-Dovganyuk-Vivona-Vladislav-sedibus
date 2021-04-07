package model;

import java.time.LocalDate;


public class PrenotazioneEstesa extends Prenotazione {

	private String data;
	private Periodo periodo;
	
	
	public PrenotazioneEstesa(Periodo periodo, LocalDate data,String codicePrenotazione, Cliente cliente, Tavolo tavolo, int nPostiPrenotati) {
		super(codicePrenotazione, cliente, tavolo, nPostiPrenotati);
		this.periodo = periodo;
		this.data = data.toString();
	}
	
	public String getLocalData() {
		return this.data;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}
	
	
	
}
