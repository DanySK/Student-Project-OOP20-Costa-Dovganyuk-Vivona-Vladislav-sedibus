package model.piantina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import model.utili.Cliente;
import model.utili.Periodo;

public class ImplMainTableModel implements MainTableModel {

	private Ristorante ristorante = new ImplRistorante();
	//lista totale dei Tavoli
	private List<Tavolo> listaTavoli = new ArrayList<>();
	
	public ImplMainTableModel() {
		this.listaTavoli = this.ristorante.tavoliRistorante();
	}
	
	
	
	@Override
	public List<Integer> tavoliPrenotati(LocalDate date, Periodo p) {
		List<Integer> listaID = new ArrayList<>();
		ristorante.tavoliPrenotati(date, p).forEach(t ->{
			listaID.add(t.getName());
		});
		
		return listaID;
	}
	
	
	private Stream<Prenotazione> streamPrenotazioni(LocalDate data, Periodo p){
		return ristorante.getListPrenotazioni(data, p).stream();
	}
	
	public int getPostiMax(int ID) {
		return this.listaTavoli.stream().filter(t -> t.getName() == ID).mapToInt(e -> e.getMaxPosti()).findFirst().getAsInt();
	}
	
	@Override
	public String getCodicePrenotazione(Periodo p, LocalDate data, int idTavolo) {
		return ristorante.getListPrenotazioni(data, p).stream().filter(e -> e.getTavolo().getName() == idTavolo).findFirst().get().getCodicePrenotazione();
	}

	@Override
	public String getCognomeNomeCliente(Periodo periodo, LocalDate data, int idTavolo) {
		Cliente c = getCliente(periodo, data, idTavolo);
		return c.getNome().concat(" "+c.getCognome());
	}
	
	private Optional<Prenotazione> getInformazioniPrenotazione(Periodo periodo, LocalDate data, int idTavolo) {
		return streamPrenotazioni(data, periodo).filter(p -> p.getTavolo().getName() == idTavolo).findFirst();
	}
	
	public String getPostiPrenotati(Periodo p, LocalDate data, int idTavolo) {
		return String.valueOf(getInformazioniPrenotazione(p, data, idTavolo).get().getPrenotazione().getPostiPrenotati());
	}
	
	private Cliente getCliente(Periodo periodo, LocalDate data, int idTavolo) {
		return getInformazioniPrenotazione(periodo, data, idTavolo).get().getCliente();
	}
	
	

}
