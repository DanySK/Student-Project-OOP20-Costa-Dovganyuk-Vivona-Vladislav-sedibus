package view.piantina;
	

import javafx.application.Application;
import javafx.stage.Stage;
import model.utili.Utente;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	
	private Text testoUtente;
	private static Utente utente;
	private final String PATH_LAYOUT = "/layouts/MappaTavoli.fxml";
	
	
	public static void loaderTableView(Utente utente) {
		LoaderTableView.utente = utente;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource(PATH_LAYOUT));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            
            this.testoUtente = (Text) loader.getNamespace().get("testoUtente");
            this.testoUtente.setText(LoaderTableView.utente.toString());
            
            primaryStage.setResizable(false);
            primaryStage.setTitle("Visione Tavoli - " + LoaderTableView.utente);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	
	
	
	
}
