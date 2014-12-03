package be.contact.manager.view;

import java.io.IOException;

import be.contact.manager.control.ContactController;
import be.contact.manager.control.ContactFormController;
import be.contact.manager.exception.CloneContactException;
import be.contact.manager.model.Contact;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class RepositoryView extends VBox {
	
	private ContactController cc;
	private ContactFormController cfc;
	
	private HBox header;
	private Label welcomeMsg;
	private Button disconnectBt;
	
	private HBox content;
	private ListView<Contact> contactsList;
	private VBox crudControls;
	private GridPane contactForm;
	
	private Button addBt;
	private Button delBt;
	private Button upBt;
	
	public RepositoryView(ContactController cc) {
		this.cc=cc;
		this.setPadding(new Insets(10));
		this.setSpacing(15);
		init();
	}
	
	public void init() {
		this.getChildren().add(getHeader());
		this.getChildren().add(getContent());
	}
	
	public void updateContactForm(Contact c) {
		if(c!=null) {
			cfc.updateContactInformation(c);
		}
	}

	public HBox getHeader() {
		if(header==null) {
			header = new HBox();
			header.getChildren().add(getWelcomeMsg());
			header.getChildren().add(getDisconnectBt());
			//header.setSpacing(500);
			HBox.setHgrow(getWelcomeMsg(), Priority.ALWAYS);
		}
		return header;
	}

	public Label getWelcomeMsg() {
		if(welcomeMsg==null) {
			welcomeMsg = new Label("Bienvenue " + this.cc.getAuthUser().getUsername() + ",");
			welcomeMsg.setFont(new Font(Font.getDefault().getName(), 20));
			welcomeMsg.setMaxWidth(Double.MAX_VALUE);
		}
		return welcomeMsg;
	}

	public Button getDisconnectBt() {
		if(disconnectBt==null) {
			disconnectBt = new Button("Disconnect");
		}
		return disconnectBt;
	}

	public HBox getContent() {
		if(content == null) {
			content = new HBox();
			content.setSpacing(10);
			content.getChildren().add(getContactsList());
			content.getChildren().add(getCrudControls());
			content.getChildren().add(getContactForm());
		}
		return content;
	}

	public ListView<Contact> getContactsList() {
		if(contactsList==null) {
			contactsList = new ListView<Contact>();
			contactsList.setPrefSize(200, 450);
			
			ObservableList<Contact> items = FXCollections.observableArrayList(cc.getAuthUser().getContacts());
			contactsList.setItems(items);
			
			contactsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>(){

				@Override
				public void changed(
						ObservableValue<? extends Contact> observable,
						Contact oldValue, Contact newValue) {
					RepositoryView.this.updateContactForm(newValue);
				}
				
			});
		}
		return contactsList;
	}

	public VBox getCrudControls() {
		if(crudControls==null) {
			crudControls = new VBox();
			crudControls.setSpacing(5);
			crudControls.setFillWidth(true);
			crudControls.getChildren().add(getAddBt());
			crudControls.getChildren().add(getDelBt());
			crudControls.getChildren().add(getUpBt());
		}
		return crudControls;
	}

	public GridPane getContactForm() {
		if(contactForm==null) {
			try {
				//contactForm = (GridPane) FXMLLoader.load(getClass().getResource("/res/fxml/form.fxml"));
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/res/fxml/form.fxml"));
				contactForm = (GridPane) loader.load();
				cfc = (ContactFormController) loader.getController();
				
			} catch (IOException e) {
				e.printStackTrace();
				contactForm = new GridPane();
				contactForm.setStyle("-fx-background-color:red;");
			}
		}
		return contactForm;
	}

	public Button getAddBt() {
		if(addBt==null) {
			addBt = new Button("Ajouter");
			addBt.setMaxWidth(Double.MAX_VALUE);
			addBt.addEventHandler(MouseEvent.MOUSE_CLICKED, new CrudHandler(addBt));
		}
		return addBt;
	}

	public Button getDelBt() {
		if(delBt==null) {
			delBt = new Button("Supprimer");
			delBt.setMaxWidth(Double.MAX_VALUE);
			delBt.addEventHandler(MouseEvent.MOUSE_CLICKED, new CrudHandler(delBt));
		}
		return delBt;
	}

	public Button getUpBt() {
		if(upBt==null) {
			upBt = new Button("Editer");
			upBt.setMaxWidth(Double.MAX_VALUE);
			upBt.addEventHandler(MouseEvent.MOUSE_CLICKED, new CrudHandler(upBt));
		}
		return upBt;
	}
	
	public class CrudHandler implements EventHandler<MouseEvent> {

		private Button source;
		
		public CrudHandler(Button b) {
			this.source = b;
		}
		
		@Override
		public void handle(MouseEvent event) {
			
			if(source.equals(getUpBt())) {
				System.out.println("up");
				Contact draft = cfc.getContactInformation();
				Contact selected = getContactsList().getSelectionModel().getSelectedItem();
				
				cc.updateContact(selected.getName(), selected.getFirstname(), draft);
				
				/* Refresh toute la liste */
				//ObservableList<Contact> items = FXCollections.observableArrayList(cc.getAuthUser().getContacts());
				//getContactsList().setItems(items);
				
				/* Simuler une édition sur un Contact en particulier */
				EventType<EditEvent<Contact>> eventType = ListView.editCommitEvent();
				EditEvent<Contact> editEvent = new EditEvent<Contact>(
						getContactsList(),
						eventType,
						selected,
						getContactsList().getSelectionModel().getSelectedIndex()
						);
				getContactsList().fireEvent(editEvent);
			}
			else if(source.equals(getAddBt())) {
				System.out.println("add");
				Contact c = cfc.getContactInformation();
				try {
					cc.addContact(c);
					getContactsList().getItems().add(c);
					getContactsList().getSelectionModel().select(c);
				} catch (CloneContactException e) {
					e.printStackTrace();
				}
			}
			else if(source.equals(getDelBt())) {
				System.out.println("del");
				Contact c = getContactsList().getSelectionModel().getSelectedItem();
				if(c!=null) {
					if(cc.deleteContact(c)) {
						getContactsList().getItems().remove(c);
					}
				}
			}
		}
		
	}

}
