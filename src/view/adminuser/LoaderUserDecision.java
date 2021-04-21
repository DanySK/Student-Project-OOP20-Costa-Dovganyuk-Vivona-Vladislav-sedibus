package view.adminuser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoaderUserDecision extends Application{
	
	private static final String PER_USERDECISION= "/layouts/UserDecision.fxml";
	
	public void start(Stage stage) {
		try {
		
		  final Parent root = FXMLLoader.load(getClass().getResource(PER_USERDECISION));
          final Scene scene = new Scene(root, 600, 500);
    
           stage.setTitle("Sedibus");
           stage.setScene(scene);
           stage.show();
	    } catch(Exception e) {
    	e.printStackTrace();
	}
	}

}
