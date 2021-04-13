package view.piantina;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoaderTavoloRossoOccupato extends Application {

	private final double OPACITY = 0.95;
	//DA FXML
	private Text testoSuperiore;
	private Text textCodice;
	
	private String TESTO_SUPERIORE;
	private String codicePrenotazione;
	
	public LoaderTavoloRossoOccupato(String idTavolo, String codicePrenotazione) {
		TESTO_SUPERIORE = "Tavolo " + idTavolo + " - PRENOTATO";
		this.codicePrenotazione = codicePrenotazione;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TavoloRossoOccupato.fxml"));
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root);
            
            this.testoSuperiore = (Text) loader.getNamespace().get("testoSuperiore");
            this.testoSuperiore.setText(TESTO_SUPERIORE);
            
            this.textCodice = (Text) loader.getNamespace().get("textCodice");
            this.textCodice.setText(this.codicePrenotazione);
            
            
            
            primaryStage.setOpacity(OPACITY);
            primaryStage.setTitle("Tavolo OCCUPATO");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        //setUser(utente);
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
