package model.cercaprenotazione;

import dataBaseModel.*;
import model.utili.Periodo;

public class ModelCercaPrenotazioneImpl implements ModelCercaPrenotazione {

	private GestoreDB db = new  ImplGestoreDB();
	private boolean prenotazTrovata;
	
	public ModelCercaPrenotazioneImpl() {
		this.prenotazTrovata = false;
	}
	
	@Override
	public boolean cercaDati(String codice, String cognome, Periodo turno) {
		db.getMapPrenotazioni(turno).entrySet().forEach(elem -> {
			elem.getValue().forEach(pren -> {
				if(pren.getCodicePrenotazione().equals(codice) && pren.getCliente().getCognome().equals(cognome)) {
					this.prenotazTrovata = true;
				}
			});
		});
		return this.prenotazTrovata;
	}

}