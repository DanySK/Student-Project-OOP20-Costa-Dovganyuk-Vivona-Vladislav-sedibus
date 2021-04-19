package model.cercaprenotazione;

import java.time.LocalDate;

import model.piantina.ImplRistorante;
import model.piantina.Prenotazione;
import model.piantina.Ristorante;
import model.utili.Periodo;

public class ModelCercaPrenotazioneImpl implements ModelCercaPrenotazione {

	private Ristorante ristorante = new ImplRistorante();
	private boolean prenotazTrovata;
	private LocalDate data;
	private Prenotazione prenotazione;
	
	public ModelCercaPrenotazioneImpl() {
		this.prenotazTrovata = false;
	}

	@Override
	public boolean cercaDati(String cod, String cognome, Periodo periodo) {
		this.ristorante.getPrenotazioni(periodo).entrySet().forEach(elem -> {
			elem.getValue().forEach(pren -> {
				if (pren.getCodicePrenotazione().equals(cod) && 
					pren.getCliente().getCognome().equals(cognome)) {
					this.prenotazione = pren;
					this.data = LocalDate.parse(elem.getKey());
					this.prenotazTrovata = true;
				}
			});
		});
		return this.prenotazTrovata;
	}
	
	@Override
	public String getNome() {
		return this.prenotazione.getCliente().getNome();
	}
	
	@Override
	public String getEmail() {
		return this.prenotazione.getCliente().getEmail();
	}
	
	@Override
	public String getTelefono() {
		return this.prenotazione.getCliente().getTelefono();
	}
	
	@Override
	public LocalDate getData() {
		return this.data;
	}
	
	@Override
	public String getPosti() {
		return String.valueOf(this.prenotazione.getPostiPrenotati());
	}
	
	@Override
	public String getIdTavolo() {
		return String.valueOf(this.prenotazione.getTavolo().getName());
	}

}