package be.contact.manager.model;

import java.time.LocalDate;

public class Contact {

	private String name;
	private String firstname;
	private LocalDate birthdate;
	private String email;
	private String address;
	private String telephone;
	
	public Contact() {
		this("","",1900, 1, 1,"","","");
	}
	
	public Contact(String name, String firstname, int year, int month, int dayOfMonth,
			String email, String address, String telephone) {
		setName(name);
		setFirstname(firstname);
		setBirthdate(LocalDate.of(year, month, dayOfMonth));
		setEmail(email);
		setAddress(address);
		setTelephone(telephone);
	}
	
	@Override
	public String toString() {
		return getName() + " - " + getFirstname();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
