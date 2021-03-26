package view;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import controllers.DatePickerController;
import controllers.MainTableController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	private static final int PROPORTION = 2;

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	private static String TAVOLO_VERDE_STYLE_PATH = "layouts/tavoloLibero.css";
	private static String TAVOLO_ROSSO_STYLE_PATH = "layouts/tavoloOccupato.css";
	
	private List<Button> listaBottoni = new ArrayList<>();
	private MainTableController controllerTable = new MainTableController();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Sample.fxml"));
            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
            //tavoliView.start(primaryStage);
            
            
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root, 800, 500);
            
            //coloro i tavoli
            colorTable(scene);
           
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(scene);
	        primaryStage.show();
          

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	private void colorTable(Scene scene) {
		controllerTable.idTavoliTotale().forEach(e -> {
			Button b = (Button)scene.lookup("#"+e); 
			if(this.controllerTable.idTavoliPrenotati().contains(e)) {
				b.getStylesheets().add(TAVOLO_ROSSO_STYLE_PATH);
			}else {
				b.getStylesheets().add(TAVOLO_VERDE_STYLE_PATH);	
			}
			
			
		});
	}
	
	
	
	
}
