package application;

import java.time.LocalDate;
import java.util.List;

import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;
import model.Cliente;
import model.ClienteImpl;
import model.ImplPrenotazione;
import model.ImplPrenotazioneCompleta;
import model.ImplRistorante;
import model.Periodo;
import model.PrenotazioneBase;
import model.PrenotazioneCompleta;
import model.Ristorante;
import model.Tavolo;
import model.ImplTavolo;


public class Main {

	//classe di Debug
	
	//se avete bisogno di provare delle vostre classi 
	//create gli oggetti nel main sottostante e provate se funziona 
	
	public static void main(String[] args) {
		/*
		LocalDate data = LocalDate.now();
		
		Cliente cliente = new ClienteImpl("Mirko", "Viroli", "marco.viroli@gmail.com", "3258621104");
		ImplTavolo tavolo1 = new ImplTavolo(1, 8);
		
		PrenotazioneBase pbase = new ImplPrenotazione("ABC", cliente, tavolo1, 8);
		PrenotazioneCompleta pcomp1 = new ImplPrenotazioneCompleta(data, Periodo.CENA, pbase);
		

		GestoreDB db = new ImplGestoreDB();
		db.creazionePrenotazione(pcomp1);
		
		Ristorante r = new ImplRistorante();
		List<Tavolo> list = r.tavoliRistorante();
		list.forEach(l ->{
			System.out.println(l.getName()+ " "+l.getMaxPosti());
		});
		*/
		
	}

}
