package be.contact.manager.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.Scene;
import javafx.stage.Stage;
import be.contact.manager.exception.CloneContactException;
import be.contact.manager.model.Contact;
import be.contact.manager.model.User;
import be.contact.manager.view.LoginView;
import be.contact.manager.view.RepositoryView;

public class ContactController {

	private List<User> storage;
	private User authUser;
	
	private Stage primaryStage;
	private LoginView loginView;
	private RepositoryView repositoryView;
	
	public ContactController(Stage s) {
		setPrimaryStage(s);
		getStorage();
	}

	public void startApp() {
		this.loginView = new LoginView(this);
		
		Scene scene = new Scene(loginView);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		
	}
	
	public void switchLoginView() {
		repositoryView = new RepositoryView(this);
		Scene scene = new Scene(repositoryView);
		this.primaryStage.setScene(scene);
		
	}
	
	public void loginUser(String username, String password) {
		System.out.println("tentative de login");
		this.authUser = userValid(username, password);
		if(this.authUser!=null)
			this.switchLoginView();
	}
	
	public User userValid(String username, String password) {
		for(User u : storage) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public void addContact(String name, String firstname, LocalDate birthdate,
			String email, String address, String telephone) {
		//validation: doublons, validation email,...
		
		
		this.authUser.getContacts().add(new Contact());
	}
	
	public void addContact(Contact c) throws CloneContactException {
		Contact old = getContact(c.getName(), c.getFirstname());
		if(old!=null) throw new CloneContactException("Contact already in repository");
		
		this.authUser.getContacts().add(c);
	}
	
	public boolean deleteContact(Contact c) {
		return this.authUser.getContacts().remove(c);	
	}
	
	public boolean updateContact(String name, String firstName, Contact draft) {
		Contact c = getContact(name, firstName);
		if(c==null)
			return false;
		
		c.setAddress(draft.getAddress());
		c.setEmail(draft.getEmail());
		c.setBirthdate(draft.getBirthdate());
		c.setTelephone(draft.getTelephone());
		c.setName(draft.getName());
		c.setFirstname(draft.getFirstname());
		return true;
	}
	
	public Contact getContact(String name, String firstName) {
		for(Contact contact : authUser.getContacts()) {
			if(contact.getName().equals(name) && contact.getFirstname().equals(firstName));
				return contact;
		}
		return null;
	}
	
	public User getAuthUser() {
		return authUser;
	}
	
	public List<User> getStorage() {
		if(storage == null) {
			storage = new ArrayList<User>();
			User u = new User("admin", "admin");
			u.getContacts().add(new Contact("Snow", "John", 1990, 5, 1, "snow@mail.us", "Wall's street", "000/000000"));
			u.getContacts().add(new Contact("Stark", "Robb", 1991, 8, 2, "robb@mail.us", "Wall's street", "000/000000"));
			storage.add(u);
			
		}
		return storage;
	}

	public void setStorage(List<User> storage) {
		this.storage = storage;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
}
