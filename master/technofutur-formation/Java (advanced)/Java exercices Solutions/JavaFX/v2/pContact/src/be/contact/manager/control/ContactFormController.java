package be.contact.manager.control;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ContactFormController {

	@FXML private TextField nameField;
	@FXML private TextField firstNameField;
	@FXML private DatePicker birthdatePicker;
	@FXML private TextField phoneField;
	@FXML private TextField addressField;
	@FXML private TextField emailField;
	
	
	@FXML
	public void handleNameFieldClick(MouseEvent e) {
		System.out.println("name click " + nameField.getText());
	}
	
	
	
}
