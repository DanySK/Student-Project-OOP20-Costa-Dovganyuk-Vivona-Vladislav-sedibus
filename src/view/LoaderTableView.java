package view;
	
import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;


public class LoaderTableView extends Application {
	
	private static final int PROPORTION = 2;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		/*
		try {
			
		
			//Parent root = FXMLLoader.load(getClass().getResource("/res/Sample.fxml"));
			//final FXMLLoader loader = new FXMLLoader(getClass().getResource("res/layouts/Sample.fxml"));
			final FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/Sample.fxml"));
			
			final Parent root = loader.load();
	        primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(new Scene(root, 800, 420));
	        primaryStage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Sample.fxml"));
            //final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/prova.fxml"));
            
            final Parent root = loader.load();
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            final Scene scene = new Scene(root, sw / PROPORTION, sh / PROPORTION);
            primaryStage.setTitle("Table Top View");
	        primaryStage.setScene(scene);
	        primaryStage.show();
          

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	
}
