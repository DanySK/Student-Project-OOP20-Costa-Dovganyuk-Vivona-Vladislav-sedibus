package view.piantina;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.utili.Periodo;

public class LoaderTavoloVerdeLibero extends Application{

	
	
	private Text testoSuperiore;
	private Text testoPeriodo;
	private Text testoData;
	private String TESTO_SUPERIORE;
	private Periodo periodo;
	private LocalDate data;
	private final double OPACITY = 0.95;
	
	
	public LoaderTavoloVerdeLibero(String idTavolo, Periodo periodo, LocalDate data) {
		TESTO_SUPERIORE = "Tavolo " + idTavolo + " - LIBERO";
		this.periodo = periodo;
		this.data = data;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TavoloVerdeLibero.fxml"));
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root);
            
            
            this.testoSuperiore = (Text) loader.getNamespace().get("testoSuperiore");
            this.testoPeriodo = (Text) loader.getNamespace().get("testoPeriodo");
            this.testoData = (Text) loader.getNamespace().get("testoData");
            
            this.testoSuperiore.setText(TESTO_SUPERIORE);
            this.testoPeriodo.setText(this.periodo.toString());
            this.testoData.setText(this.data.toString());
            
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setOpacity(OPACITY);
            primaryStage.setTitle("Tavolo LIBERO");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        //setUser(utente);
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
	public void loadView() {
		launch();
	}



}
