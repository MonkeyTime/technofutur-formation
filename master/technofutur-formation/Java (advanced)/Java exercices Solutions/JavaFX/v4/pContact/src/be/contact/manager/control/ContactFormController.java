package be.contact.manager.control;

import java.time.LocalDate;

import be.contact.manager.model.Contact;
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
	
	public void updateContactInformation(Contact c) {
		nameField.setText(c.getName());
		firstNameField.setText(c.getFirstname());
		birthdatePicker.setValue(c.getBirthdate());
		phoneField.setText(c.getTelephone());
		emailField.setText(c.getEmail());
		addressField.setText(c.getAddress());
		
	}
	
	public Contact getContactInformation() {
		Contact c = new Contact();
		c.setName(nameField.getText());
		c.setFirstname(firstNameField.getText());
		c.setBirthdate(birthdatePicker.getValue());
		c.setAddress(addressField.getText());
		c.setEmail(emailField.getText());
		c.setTelephone(phoneField.getText());
		return c;
	}
	
}
