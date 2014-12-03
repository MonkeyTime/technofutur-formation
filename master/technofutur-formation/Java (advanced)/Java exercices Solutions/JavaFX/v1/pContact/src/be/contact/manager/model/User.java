package be.contact.manager.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	private String username;
	private String password;
	private List<Contact> contacts;
	
	public User() {
		this("","");
		
	}
	
	public User(String name, String pwd) {
		setUsername(name);
		setPassword(pwd);
		setContacts(new ArrayList<Contact>());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
