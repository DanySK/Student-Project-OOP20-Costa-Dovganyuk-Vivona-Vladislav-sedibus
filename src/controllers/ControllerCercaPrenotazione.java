package controllers;

import model.ModelCercaPrenotazione;
import view.CercaPrenotazione;

public class ControllerCercaPrenotazione {

	private CercaPrenotazione vista;
	private ModelCercaPrenotazione modello;
	
	public ControllerCercaPrenotazione() {
		
	}
	
	public void gestisciEventi() {
		this.vista.getBottoneAnnulla().setOnAction(e -> {
			this.vista.precedentePagina();
		});
		
		this.vista.getBottoneConferma().setOnAction(e -> {
			if(this.modello.cercaDati(this.vista.getCodice(), this.vista.getCognome())) {
				this.vista.prossimaPagina();
			} else {
				this.vista.datiIncorretti();
			}
		});
	}
	
}
