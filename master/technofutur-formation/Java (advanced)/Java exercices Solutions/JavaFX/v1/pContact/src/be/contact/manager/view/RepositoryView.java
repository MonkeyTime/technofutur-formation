package be.contact.manager.view;

import be.contact.manager.control.ContactController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RepositoryView extends VBox {
	
	private ContactController cc;
	
	private HBox header;
	private Label WelcomeMsg;
	private Button disconnectBt;
	
	private HBox content;
	private ListView contactsList;
	private VBox crudControls;
	private GridPane contactForm;
	
	private Button addBt;
	private Button delBt;
	private Button upBt;
	
	public RepositoryView(ContactController cc){
		this.cc = cc;
		
		init();
	}
	
	public void init(){
		
	}
}
