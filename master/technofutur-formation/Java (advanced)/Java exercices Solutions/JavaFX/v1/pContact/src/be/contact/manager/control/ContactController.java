package be.contact.manager.control;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.stage.Stage;

import be.contact.manager.model.User;
import be.contact.manager.view.LoginView;

public class ContactController {

	private List<User> storage;
	private User authUser;
	
	private Stage primaryStage;
	private LoginView loginView;
	
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
		//Scene scene = new Scene();
	}
	
	public void loginUser(String username, String password) {
		System.out.println("tentative de login");
		this.authUser = userValid(username, password);
		if(this.authUser!=null)
			this.switchLoginView();
		else System.out.println("Login incorrect");
	}
	
	public User userValid(String username, String password) {
		for(User u : storage) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public List<User> getStorage() {
		if(storage == null) {
			storage = new ArrayList<User>();
			User u = new User("admin", "admin");
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
