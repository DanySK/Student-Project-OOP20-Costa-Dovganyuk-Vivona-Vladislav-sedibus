package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

public class DatePickerController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Date Picker is aviable!!!");
    }
    
    
    @FXML private DatePicker datePicker;
    
    public void dateHandler() {
    	LocalDate ld = datePicker.getValue();
    	
    	System.out.println(ld.toString());
    	
    }
    
}
