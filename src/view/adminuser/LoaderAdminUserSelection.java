package view.adminuser;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;




public class LoaderAdminUserSelection extends Application {
	
	public static void inizia() {
		launch();
	}
	@Override
    public void start(Stage stage) {
	   try {
          Parent root = FXMLLoader.load(getClass().getResource("/layouts/AdminUserSelection.fxml"));
    
           Scene scene = new Scene(root, 600, 500);
    
           stage.setTitle("Sedibus");
           stage.setScene(scene);
           stage.show();
      } catch(Exception e) {
    	e.printStackTrace();
      }
 
   }
}
