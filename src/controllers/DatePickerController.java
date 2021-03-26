package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

public class DatePickerController implements Initializable {

	@FXML private DatePicker datePicker;
	private LocalDate ld = LocalDate.now();
	private MainTableController controller = new MainTableController();
	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Date Picker is aviable!!!");
        this.datePicker.setValue(ld);
        //prelevo la data corrente
        this.ld = datePicker.getValue();
    	System.out.println(ld.toString());
    	
    	//gia da qui devo caricare i dati
    	
    	
    }
    
    public LocalDate getCurrentDate() {
    	return this.ld;
    }
    
    
    
    public void dateHandler() {
    	this.ld = datePicker.getValue();
    	controller.CambioData(ld);
    	System.out.println(ld.toString());
    	
    }
    
}
