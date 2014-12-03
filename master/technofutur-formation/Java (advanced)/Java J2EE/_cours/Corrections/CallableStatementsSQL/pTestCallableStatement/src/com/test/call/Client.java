package com.test.call;

public class Client {

	private int id;
	private String firstName;
	private String lastName;
	
	public Client() {
		
	}
	
	@Override
	public String toString() {
		return "Client[id:" + getId() + ", firstName:" + getFirstName() + ", lastName:" + getLastName() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
