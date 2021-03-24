package application;

import java.time.LocalDate;

import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;
import model.Cliente;
import model.ClienteImpl;
import model.ImplPrenotazione;
import model.ImplTavolo;
import model.Periodo;
import model.Prenotazione;
import model.Tavolo;


public class Main {

	//classe di Debug
	
	//se avete bisogno di provare delle vostre classi 
	//create gli oggetti nel main sottostante e provate se funziona 
	
	public static void main(String[] args) {
		
		LocalDate data = LocalDate.now();
		
		Cliente cliente = new ClienteImpl("Mirko", "Viroli", "marco.viroli@gmail.com", "3258621104");
		Tavolo tavolo1 = new ImplTavolo(1, 8);
		
		
		Prenotazione p1 = new ImplPrenotazione(Periodo.CENA, data, "ABCD", cliente, tavolo1, 8);
		

		GestoreDB db = new ImplGestoreDB();
		db.creazionePrenotazione(p1);
		
	}

}
