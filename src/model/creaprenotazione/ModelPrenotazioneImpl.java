package model.creaprenotazione;

import java.time.LocalDate;
import model.piantina.ImplRistorante;
import model.piantina.PrenotazioneEstesa;
import model.piantina.Ristorante;
import model.piantina.Tavolo;
import model.utili.Cliente;
import model.utili.Periodo;

public class ModelPrenotazioneImpl implements ModelPrenotazione {
	
	private Cliente cliente;
	private Ristorante ristorante = new ImplRistorante();
	private Tavolo tavoloScelto;
	private PilotaPosti gestorePosti;
	private Periodo periodoScelto;
	
	public ModelPrenotazioneImpl() { }
	
	@Override
	public void prendiTavolo(String idTavolo) {
		int id = Integer.parseInt(idTavolo);
		this.ristorante.tavoliRistorante().forEach(t -> {
			if(t.getName() == id) {
				this.tavoloScelto = new Tavolo(id, t.getMaxPosti());
			}
		});
		this.gestorePosti = new PilotaPosti(this.tavoloScelto.getMaxPosti());
	}

	@Override
	public void incrementaPosti() {
		this.gestorePosti.aggiungiPosto();
	}

	@Override
	public void decrementaPosti() {
		this.gestorePosti.togliPosto();
	}

	@Override
	public void inizializzaPosti() {
		this.gestorePosti.azzeraPosti();
	}

	@Override
	public int postiCorrenti() {
		return this.gestorePosti.getNumeroPosti();
	}

	@Override
	public boolean prendiDatiCliente(String nome, String cognome, String email, String telefono) {
		this.cliente = new Cliente(nome, cognome, email, telefono);
		return this.cliente.rispettaControlli();
	}

	@Override
	public void prendiPeriodo(String periodo) {
		this.periodoScelto = periodo.equalsIgnoreCase(Periodo.PRANZO.toString()) ? Periodo.PRANZO : Periodo.CENA;
	}
	
	@Override
	public void aggiungiPrenotazione(LocalDate data) {
		this.ristorante.nuovaPrenotazione(new PrenotazioneEstesa(this.periodoScelto, data, 
				this.generaCodice(), this.cliente, this.tavoloScelto, this.postiCorrenti()));
	}
	
	private String generaCodice() {
		return new GeneratoreCodice().ottieni();
	}
	
}
