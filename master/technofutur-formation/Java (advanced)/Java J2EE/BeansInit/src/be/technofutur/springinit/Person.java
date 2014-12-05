package be.technofutur.springinit;

import java.util.List;

public class Person {

	private String lastname;
	private String firstname;
	private Address address;
	private List<Person> children;
	
	public Person() {}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Person> getChildren() {
		return children;
	}
	
	public void setChildren(List<Person> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return lastname + " " + firstname + "\r\n";
	}
}
