package model.piantina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

}
