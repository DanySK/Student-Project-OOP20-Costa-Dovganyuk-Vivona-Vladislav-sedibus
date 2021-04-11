package model.creaprenotazione;

public class ModelPrenotazione {
	
	private int nPosti;
	
	public ModelPrenotazione() {
		this.azzeraPosti();
	}
	
	public void azzeraPosti() {
		this.nPosti = 0;
	}
	
	public int getNumeroPosti() {
		return this.nPosti;
	}
	
	public void aggiungiPosto() {
		this.nPosti++; //il massimo per ora non l'ho messo
	}
	
	public void togliPosto() {
		if(this.nPosti != 0) {
			this.nPosti--;
		}
	}

	public boolean controllaDati(String nome, String cognome, String email, String telefono) {
		
		
		return false;
	}
	
	private String generaCodice() {
		return new GeneratoreCodice().ottieni();
	}
	
}
