package view.adminuser;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public final class LoaderAdminUserSelection extends Application {
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	private static final String PERC_ADMINUSER= "/layouts/AdminUserSelection.fxml";
	private final double resize= 2.6;
	private int width = gd.getDisplayMode().getWidth();
	private int height = gd.getDisplayMode().getHeight();
	
	
	public static void inizia() {
		launch();
	}
	
	@Override
    public void start(Stage stage) {
		try {
			final Parent root = FXMLLoader.load(getClass().getResource(PERC_ADMINUSER));
		
			final Scene scene = new Scene(root, width/resize, height/resize);
	
			stage.setTitle("Sedibus");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
