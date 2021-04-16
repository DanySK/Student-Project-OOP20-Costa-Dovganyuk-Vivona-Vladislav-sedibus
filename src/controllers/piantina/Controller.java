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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.piantina.ImplMainTableModel;
import model.piantina.MainTableModel;
import model.utili.Periodo;
import model.utili.Utente;
import view.adminuser.LoaderAdminUserSelection;
import view.piantina.LoaderTavoloRossoOccupato;
import view.piantina.LoaderTavoloVerdeLibero;

public class Controller implements Initializable {

	
	private static String TAVOLO_VERDE_STYLE_PATH = "layouts/tavoloLibero.css";
	private static String TAVOLO_ROSSO_STYLE_PATH = "layouts/tavoloOccupato.css";
	private static String ORARIO_PRANZO = "12.00 - 13.30";
	private static String ORARIO_CENA = "18.00 - 19.30";
	
	@FXML private AnchorPane panePrincipale;
	@FXML private DatePicker datePicker;
	@FXML private ChoiceBox<Periodo> periodBox;
	@FXML private AnchorPane paneTavoli;
	@FXML private AnchorPane paneData;
	@FXML private Text testoUtente;
	@FXML private Text testoOrario;
	
	private LocalDate localDate = LocalDate.now() ;
	private List<Button> listButton = new ArrayList<>();
	private List<Button> listRedButton = new ArrayList<>();
	private MainTableModel model; // = new ImplMainTableModel();
	private Periodo periodo;
	private boolean primaChiamata = true;
	//boolean per la visualizzazione dei tavoli ROSSI
	
	
	public Controller() {}
	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	setPeriodBox();
    	this.datePicker.setValue(localDate);
    	getIDTavoliPrenotati(this.localDate, this.periodo);
    	handlerTavolo();
    	
    }
    
    
    private boolean isAdmin() {
    	if(Utente.valueOf(this.testoUtente.getText()).equals(Utente.ADMIN)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    private void coloraTavoli(List<Integer> l) {
    	
    	this.listRedButton.clear();
    	this.paneTavoli.getChildren().forEach(e -> {
        	Button b = (Button)e;
        	
        	b.getStylesheets().clear();
        	
        	
        	if(l.contains(Integer.parseInt(b.getId()))) {
        		b.getStylesheets().add(TAVOLO_ROSSO_STYLE_PATH);
        		
        		this.listRedButton.add(b);
        		
        		
        	}else {
        		b.setDisable(false);
        		b.getStylesheets().add(TAVOLO_VERDE_STYLE_PATH);
        	}
        	//b.setText(b.getText().concat("\nMax posti:" + model.getPostiMax(Integer.parseInt(b.getId()))));
        	
        	this.listButton.add(b);
        });
    }
    
    private void handlerTavolo() {
    	
    	this.listButton.forEach(b -> {
    		b.setOnAction(e -> {
    			var currentStage = (Stage) this.datePicker.getScene().getWindow();
    			if(this.listRedButton.contains(b) && isAdmin()) {
    				//apro la view dell'admin
    				int idTavolo = Integer.parseInt(b.getId());
    				LoaderTavoloRossoOccupato tavoloRossoView = new LoaderTavoloRossoOccupato(b.getId(),
    						this.model.getCodicePrenotazione(idTavolo), 
    						this.model.getCognomeNomeCliente(idTavolo),
    						this.model.getPostiPrenotati(idTavolo),
    						this.model.getNumTelefonoCliente(idTavolo),
    						this.model.getEmailCliente(idTavolo), this.periodo, this.localDate,currentStage);
    				try {
						tavoloRossoView.start(new Stage());
					} catch (Exception exception) {
						exception.printStackTrace();
					}
    			}else{
    				if(this.listRedButton.contains(b)) {
    					
    				}else {
    					
    					LoaderTavoloVerdeLibero tavoloVerdeView = new LoaderTavoloVerdeLibero(b.getId(),this.periodo,this.localDate,currentStage);
        				try {
    						tavoloVerdeView.start(new Stage());
    					} catch (Exception exception) {
    						exception.printStackTrace();
    					}
    				}
    				
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
	    	setOrario(this.periodo.equals(Periodo.PRANZO)? ORARIO_PRANZO : ORARIO_CENA);
    	}
    	
    }
    
    private void setPeriodBox() {
    	this.periodBox.getItems().addAll(Periodo.PRANZO, Periodo.CENA);
    	this.periodBox.setValue(Periodo.PRANZO);
    	this.periodo = this.periodBox.getValue();
    	setOrario(this.periodo.equals(Periodo.PRANZO)? ORARIO_PRANZO : ORARIO_CENA);
    }
    
    
    
    private void getIDTavoliPrenotati(LocalDate data, Periodo p) {
    	model = new ImplMainTableModel(p,data);
    	System.out.print("ID dei Tavoli prenotati - ");
    	System.out.println("Per la data " + data + " e Periodo: " + p);    		
    	coloraTavoli(this.model.tavoliPrenotati(localDate, periodo));	

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
    
    private void setOrario(String testo) {
    	this.testoOrario.setText(testo);
    }
    

}