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
			//this.vista.setCampoPosti(Integer.toString(this.modello.getNumeroPosti()));
		});
		
		this.vista.getBottoneMenoPosti().setOnAction(e -> {
			this.modello.togliPosto();
			//this.vista.setCampoPosti(Integer.toString(this.modello.getNumeroPosti()));
		});
		
		this.vista.getBottonePrenota().setOnAction(e -> {
			
		});
		
		this.vista.getBottoneReset().setOnAction(e -> {
			
		});
		
		this.vista.getBottoneAnnulla().setOnAction(e -> {
			
		});
	}
	
}
