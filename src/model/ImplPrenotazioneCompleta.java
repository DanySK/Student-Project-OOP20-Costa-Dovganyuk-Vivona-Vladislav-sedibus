package model;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class ImplPrenotazioneCompleta implements PrenotazioneCompleta {

	
	private LocalDate data;
	private Periodo periodo;
	@SerializedName("Prenotazione")
	private PrenotazioneBase prenotazionebase;
	
	public ImplPrenotazioneCompleta(LocalDate data, Periodo periodo,PrenotazioneBase prenotazionebase) {
		super();
		this.data = data;
		this.periodo = periodo;
		this.prenotazionebase = prenotazionebase;
	}
	
	
	
	@Override
	public PrenotazioneBase prenotazione() {
		return this.prenotazionebase;
	}

	@Override
	public LocalDate dataPrenotazioni() {
		return this.data;
	}

	@Override
	public Periodo periodoPrenotato() {
		return this.periodo;
	}

}
