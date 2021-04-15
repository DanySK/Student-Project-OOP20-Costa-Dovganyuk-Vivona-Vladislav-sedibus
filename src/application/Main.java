package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataBaseModel.GestoreDB;
import dataBaseModel.ImplGestoreDB;
import javafx.application.Application;
import javafx.stage.Stage;
import model.utili.Cliente;
import model.piantina.Prenotazione;
import model.piantina.ImplRistorante;
import model.utili.Periodo;
import model.piantina.PrenotazioneEstesa;
import model.piantina.Ristorante;
import model.piantina.Tavolo;
import model.utili.Utente;
import view.cercaprenotazione.CercaPrenotazione;
import view.cercaprenotazione.CercaPrenotazione;
import view.adminuser.LoaderAdminUserSelection;
import view.piantina.LoaderTableView;
import model.piantina.MainTableModel;


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
		LoaderTableView view = new LoaderTableView();
		view.loadView(Utente.ADMIN);
		//view.start(new Stage());
		
		

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
		
		
		/*
		GestoreDB db = new ImplGestoreDB();
				
		Ristorante risto = new ImplRistorante();
		List<Cliente> list = new ArrayList<>();
		
		
		Cliente p1 = new Cliente("Mirko", "Viroli", "mirko.viroli@unibo.it","326598485");
		Cliente p2 = new Cliente("Roberta", "Lelli", "robbyLelli@gmail.com","659845213");
		Cliente p3 = new Cliente("Franco", "Renzi", "RenziFranco@gmail.com","2130548787");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		//System.out.println(list.toString());
		
		Tavolo t1 = new Tavolo(1, 8);
		Tavolo t2 = new Tavolo(2,10);
		Tavolo t3 = new Tavolo(3, 4);
		
		LocalDate data = LocalDate.parse("2021-04-08");
		
		PrenotazioneEstesa prenotazione1 = new PrenotazioneEstesa(Periodo.CENA, data,"AA3200", p1, t3, 8);
		*/
		
		//risto.nuovaPrenotazione(prenotazione1);
		
		//db.getMapPrenotazioni(Periodo.PRANZO);
		
		
		
		//risto.nuovaPrenotazione(prenotazione1);
		
		
	}

	

}
