package model.creaprenotazione;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelPrenotazione {
	
	private int nPosti;
	private Random rand = new Random();
	private int numeroCod = 0;
	private final String lettereCod = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Pattern pattern;
	private Matcher matcher;
	
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
		this.numeroCod++;
		return this.lettereCod.charAt(this.rand.nextInt(this.lettereCod.length())) + String.valueOf(this.numeroCod);
	}
	
}
