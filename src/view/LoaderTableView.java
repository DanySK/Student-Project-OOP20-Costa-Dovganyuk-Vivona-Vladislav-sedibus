package view;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MainTableModel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	private static final int PROPORTION = 2;

	/*
	public static void main(String[] args) {
		launch(args);
	}
	*/
	
	
	
	
	/*
	public LoaderTableView(List<Integer> idPrenotati, List<Integer> idTavoli) {
		this.idTavoliRossi = controller.idTavoliPrenotati();
		this.idTavoli = controller.idTavoliTotale();
		System.out.println("[LoaderTableView] Tavoli totali: " + this.idTavoli + " Tavoli Rossi:" + this.idTavoliRossi);
	}
	*/
	
	public void loadView() {
		launch();
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/MappaTavoli.fxml"));
            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
            //tavoliView.start(primaryStage);
            
            
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root);
            
           
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
           
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	
	
}
