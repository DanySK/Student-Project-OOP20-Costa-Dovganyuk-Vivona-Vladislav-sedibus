package view.piantina;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.utili.Periodo;

public class LoaderTavoloRossoOccupato extends Application {

	private final double OPACITY = 0.95;
	//DA FXML
	private Text testoSuperiore;
	private Text textCodice;
	private Text textCognomeNomeCliente;
	private Text textPostiPrenotati;
	private Text textTelefono;
	private Text textEmail;
	private Text textPeriodo;
	private Text textData;
	
	
	private String TESTO_SUPERIORE;
	private String codicePrenotazione;
	private String cognomeNomeCliente;
	private String postiPrenotati;
	private String numTelefono;
	private String email;
	private String periodo;
	private String data;
	
	public LoaderTavoloRossoOccupato(String idTavolo, 
			String codicePrenotazione, String cognomeNomeCliente,
			String postiPrenotati, String numTelefono, String email, Periodo periodo, LocalDate data) {
		TESTO_SUPERIORE = "Tavolo " + idTavolo + " - PRENOTATO";
		this.codicePrenotazione = codicePrenotazione;
		this.cognomeNomeCliente = cognomeNomeCliente;
		this.postiPrenotati = postiPrenotati;
		this.numTelefono = numTelefono;
		this.email = email;
		this.periodo = periodo.toString();
		this.data = data.toString();
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
            
            this.textCognomeNomeCliente = (Text) loader.getNamespace().get("textCognomeNomeCliente");
            this.textCognomeNomeCliente.setText(this.cognomeNomeCliente);
            
            this.textPostiPrenotati = (Text) loader.getNamespace().get("textPostiPrenotati");
            this.textPostiPrenotati.setText(this.postiPrenotati);
            
            this.textTelefono = (Text) loader.getNamespace().get("textTelefono");
            this.textTelefono.setText(this.numTelefono);
            
            this.textEmail = (Text) loader.getNamespace().get("textEmail");
            this.textEmail.setText(this.email);
            
            this.textPeriodo = (Text) loader.getNamespace().get("textPeriodo");
            this.textPeriodo.setText(this.periodo);
            
            this.textData = (Text) loader.getNamespace().get("textData");
            this.textData.setText(this.data);
            
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
