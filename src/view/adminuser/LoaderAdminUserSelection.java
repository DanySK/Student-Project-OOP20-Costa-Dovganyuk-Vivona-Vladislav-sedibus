package view.adminuser;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public final class LoaderAdminUserSelection extends Application {
	
	private static final String PERC_ADMINUSER= "/layouts/AdminUserSelection.fxml";
	
	public static void inizia() {
		launch();
	}
	
	@Override
    public void start(Stage stage) {
		try {
			final Parent root = FXMLLoader.load(getClass().getResource(PERC_ADMINUSER));
		
			final Scene scene = new Scene(root, 600, 500);
	
			stage.setTitle("Sedibus");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
