package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import model.ImplRistorante;
import model.Ristorante;
import model.Tavolo;

public class MainTableController {
	
	
	private Ristorante ristorante = new ImplRistorante();
	private List<Tavolo> listTavoli = new ArrayList<>();
	private List<Tavolo> listTavoliPrenotati = new ArrayList<>();
	
	
	public MainTableController() {
		this.listTavoli = ristorante.tavoliRistorante();
		refreshList(LocalDate.now());
	}
	
	
	private List<Integer> getIDTable(List<Tavolo> list){
		List<Integer> id = new ArrayList<>();
		if(!list.isEmpty()) {
			list.forEach(t -> {
				id.add(t.getName());
			});
		}
		return id;
	}
	
	public List<Integer> idTavoliTotale(){
		return getIDTable(this.listTavoli);
		
	}
	
	public List<Integer> idTavoliPrenotati(){
		return getIDTable(this.listTavoliPrenotati);
		
	}
	
	private void refreshList(LocalDate date) {
		this.listTavoliPrenotati = this.ristorante.tavoliPrenotati(date);
	}
	
	public void CambioData(LocalDate data) {
		//chiamo il refresh sulla table view
		refreshList(data);
	}
	

}
