package controllers.riepilogo;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.riepilogo.*;

public class ControllerRiepilogo implements Initializable {

	@FXML private BorderPane pannello;
	private List<Label> spazi = new ArrayList<>();
	private ModelRiepilogo modello = new ModelRiepilogoImpl();
	
	public ControllerRiepilogo() {
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.pannello.getChildren().forEach(ap -> {
			final AnchorPane ancpan = (AnchorPane)ap;
			ancpan.getChildren().forEach(elem -> {
				final Optional<String> id = Optional.ofNullable(elem.getId());
				if(elem.getClass() == Label.class && id.isPresent()) {
					this.spazi.add((Label)elem);
				}
			});
		});
		this.riempiCampi();
	}
	
	public void handlerFine() {
		//riporta alla selezione admin/utente
	}
	
	private void riempiCampi() {
		this.spazi.forEach(l -> {
			l.setText("?");  //cosa mi ritorna la model?
		});
	}
	
}
