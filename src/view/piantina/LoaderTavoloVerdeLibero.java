package view.piantina;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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
            final Scene scene = new Scene(root);
            
            
            this.testoSuperiore = (Text) loader.getNamespace().get("testoSuperiore");
            this.testoPeriodo = (Text) loader.getNamespace().get("testoPeriodo");
            this.testoData = (Text) loader.getNamespace().get("testoData");
            
            this.testoSuperiore.setText(TESTO_SUPERIORE);
            this.testoPeriodo.setText(this.periodo.toString());
            this.testoData.setText(this.data.toString());
            
            primaryStage.setResizable(false);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setOpacity(OPACITY);
            primaryStage.setTitle("Tavolo LIBERO");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
	public void loadView() {
		launch();
	}



}
