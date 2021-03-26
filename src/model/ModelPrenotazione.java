package model;

import java.util.Random;

public class ModelPrenotazione {
	
	private int nPosti;
	private Random rand = new Random();
	private int numeroCod = 0;
	private final String lettereCod = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public ModelPrenotazione() {
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

	
	
	
	
	private String generaCodice() {
		this.numeroCod++;
		return this.lettereCod.charAt(this.rand.nextInt(this.lettereCod.length())) + String.valueOf(this.numeroCod);
	}
	
}
