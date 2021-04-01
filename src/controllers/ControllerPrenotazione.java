package controllers;

import model.ModelPrenotazione;
import view.ViewPrenotazione;

public class ControllerPrenotazione {
	
	private ViewPrenotazione vista;
	private ModelPrenotazione modello;
	
	public ControllerPrenotazione(ViewPrenotazione vista, ModelPrenotazione modello) {
		this.vista = vista;
		this.modello = modello;
	}
	
	public void assegnaGestori() {
		this.vista.getBottonePiuPosti().setOnAction(e -> {
			this.modello.aggiungiPosto();
			this.aggiornaVista();
		});
		
		this.vista.getBottoneMenoPosti().setOnAction(e -> {
			this.modello.togliPosto();
			this.aggiornaVista();
		});
		
		this.vista.getBottonePrenota().setOnAction(e -> {
			//
			this.aggiornaVista();
		});
		
		this.vista.getBottoneReset().setOnAction(e -> {
			this.vista.pulisciCampi();
			this.modello.azzeraPosti();
			this.aggiornaVista();
		});
		
		this.vista.getBottoneAnnulla().setOnAction(e -> {
			//ritorna alla gui dei tavoli
		});
	}
	
	private void aggiornaVista() {
		this.vista.setCampoPosti(Integer.toString(this.modello.getNumeroPosti()));
	}
	
}
