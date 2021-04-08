package controllers.piantina;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.piantina.ImplMainTableModel;
import model.piantina.MainTableModel;
import model.utili.Periodo;
import model.utili.Utente;
import view.adminuser.LoaderAdminUserSelection;

public class Controller implements Initializable {

	
	private static String TAVOLO_VERDE_STYLE_PATH = "layouts/tavoloLibero.css";
	private static String TAVOLO_ROSSO_STYLE_PATH = "layouts/tavoloOccupato.css";
	
	@FXML private DatePicker datePicker;
	@FXML private ChoiceBox<Periodo> periodBox;
	@FXML private AnchorPane paneTavoli;
	private LocalDate localDate = LocalDate.now() ;
	private List<Button> listButton = new ArrayList<>();
	private List<Button> listRedButton = new ArrayList<>();
	private MainTableModel model = new ImplMainTableModel();
	private Periodo periodo;
	private boolean primaChiamata = true;
	//boolean per la visualizzazione dei tavoli ROSSI
	private boolean admin = false;
	
	
	public Controller() {
		
	}
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	setPeriodBox();
    	this.datePicker.setValue(localDate);
    	getIDTavoliPrenotati(this.localDate, this.periodo);
    	handlerTavolo();

    }
    
   
    
    private void coloraTavoli(List<Integer> l) {
  
    	this.paneTavoli.getChildren().forEach(e -> {
        	Button b = (Button)e;
        	
        	b.getStylesheets().clear();
        	this.listRedButton.clear();
        	
        	if(l.contains(Integer.parseInt(b.getId()))) {
        		b.getStylesheets().add(TAVOLO_ROSSO_STYLE_PATH);
        		listRedButton.add(b);
        		
        		if(!admin) {
        			b.setDisable(true);
        		}
        		
        	}else {
        		b.setDisable(false);
        		b.getStylesheets().add(TAVOLO_VERDE_STYLE_PATH);
        	}
        
        	
        	this.listButton.add(b);
        });
    }
    
    private void handlerTavolo() {
    	this.listButton.forEach(b -> {
    		b.setOnAction(e -> {
    			System.out.println("Stato premuto il Tavolo " + b.getId());
    			
    			if(this.listRedButton.contains(b) && admin) {
    				//apro la view dell'admin
    			}else {
    				
    			}
    			
    		});
    	});
    }
   
    
    public void topMenuHandler() {
    	if(this.primaChiamata) {
    		this.primaChiamata = false;
    	}else {
    		this.periodo = this.periodBox.getValue();
	    	this.localDate = this.datePicker.getValue() == null ? LocalDate.now() : this.datePicker.getValue();
	    	getIDTavoliPrenotati(localDate, periodo);
    	}
    }
    
    private void setPeriodBox() {
    	this.periodBox.getItems().addAll(Periodo.PRANZO, Periodo.CENA);
    	this.periodBox.setValue(Periodo.PRANZO);
    	this.periodo = this.periodBox.getValue();
    }
    
    
    
    private void getIDTavoliPrenotati(LocalDate data, Periodo p) {
    	System.out.print("ID dei Tavoli prenotati - ");
    	System.out.println("Per la data " + data + " e Periodo: " + p);
    	
    	if(primaChiamata) {
    		primaChiamata = false;
    	}else {
    		coloraTavoli(this.model.tavoliPrenotati(localDate, periodo));	
    	}
    	
    }
    
    
    public void tornaIndietroHandler() {
    	LoaderAdminUserSelection view = new LoaderAdminUserSelection();
    	Stage currentStage = (Stage) this.datePicker.getScene().getWindow();
    	try {
			view.start(new Stage());
			currentStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

}