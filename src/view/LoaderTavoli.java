package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoaderTavoli extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/MappaTavoli.fxml"));
            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
            
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root, 800, 500);
            
            System.out.println("Adesso prelevo i bottoni");
            //Set<Node> tableButton = scene.lookupAll("#Button");
            Button button = (Button) scene.lookup("#1");
            
            
            
            System.out.println("Bottoni total " + button.getText());
            
            
            //final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            /*
            primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(scene);
	        primaryStage.show();
          */

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
