package be.contact.manager.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.Scene;
import javafx.stage.Stage;
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
	
	public User getAuthUser() {
		return authUser;
	}
	
	public List<User> getStorage() {
		if(storage == null) {
			storage = new ArrayList<User>();
			User u = new User("admin", "admin");
			u.getContacts().add(new Contact("Snow", "John", new Date(), "snow@mail.us", "Wall's street", "000/000000"));
			u.getContacts().add(new Contact("Stark", "Robb", new Date(), "robb@mail.us", "Wall's street", "000/000000"));
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
