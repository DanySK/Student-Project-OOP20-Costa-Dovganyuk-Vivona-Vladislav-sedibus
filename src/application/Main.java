package application;

import java.time.LocalDate;
import java.util.List;

import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteImpl;
import model.ImplPrenotazione;
import model.ImplRistorante;
import model.Periodo;
import model.Prenotazione;
import model.PrenotazioneEstesa;
import model.Ristorante;
import model.Tavolo;
import model.Utente;
import view.CercaPrenotazione;
import view.CercaPrenotazioneImpl;
import view.LoaderAdminUserSelection;
import view.LoaderTableView;
import model.ImplTavolo;
import model.MainTableModel;


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
		/**
		 * Variante 1):
		 * 			Controller si occupa di caricare la view
		 */
		/*
		LocalDate data = LocalDate.now();
		MainTableController c = new MainTableController(data);
		*/
		
		/**
		 * Variante 2):	
		 * 			Carico la view, e lei si occupa di caricare il controller
		 */
		
		//LoaderTableView view = new LoaderTableView();
		//view.loadView(Utente.ADMIN);
		
		/*
		CercaPrenotazione p = new CercaPrenotazioneImpl();
		p.inizia();
		*/
		
		//prove del DB
		//prenotazione prelevata dalla form
		/*
		Cliente cliente = new ClienteImpl("Mario", "Draghi", "draghi.mario@ita.com", "3265984578");
		Ristorante risto = new ImplRistorante();
		List<Tavolo> tavoli = risto.tavoliRistorante();
		LocalDate data = LocalDate.now();
		GestoreDB db = new ImplGestoreDB();
		
		
		PrenotazioneBase p = new ImplPrenotazione("AA11", cliente, tavoli.get(2), 8);
		
		PrenotazioneEstesa prenotazione1 = new PrenotazioneEstesa(Periodo.PRANZO,data, "AA11", cliente, tavoli.get(2), 8);
		db.creazionePrenotazione(prenotazione1);
		*/
		
		GestoreDB db = new ImplGestoreDB();
				
		Ristorante risto = new ImplRistorante();
		
		Cliente p1 = new ClienteImpl("Mirko", "Viroli", "mirko.viroli@unibo.it","326598485");
		Cliente p2 = new ClienteImpl("Roberta", "Lelli", "robbyLelli@gmail.com","659845213");
		Cliente p3 = new ClienteImpl("Franco", "Renzi", "RenziFranco@gmail.com","2130548787");
		
		Tavolo t1 = new ImplTavolo(1, 8);
		Tavolo t2 = new ImplTavolo(2,10);
		Tavolo t3 = new ImplTavolo(3, 4);
		
		LocalDate data = LocalDate.parse("2021-04-07");
		
		PrenotazioneEstesa prenotazione1 = new PrenotazioneEstesa(Periodo.PRANZO, data,"AA1100", p1, t2, 8);
		
		risto.nuovaPrenotazione(prenotazione1);
		
		
	}

	

}
