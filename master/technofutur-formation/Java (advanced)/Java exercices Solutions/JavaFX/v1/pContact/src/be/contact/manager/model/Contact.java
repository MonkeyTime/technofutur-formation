package be.contact.manager.model;

import java.util.Date;

public class Contact {

	private String name;
	private String firstname;
	private Date birthdate;
	private String email;
	private String address;
	private String telephone;
	
	
	public Contact(){
		
	}
	
	public Contact(String name, String firstname, Date birthdate, String email, String adress, String telephone){
		
		setName(name);
		setFirstname(firstname);
		setBirthdate(birthdate);
		setEmail(email);
		setAddress(adress);
		setTelephone(telephone);
	}
	
	public String toString(){
		return getName()+" "+getFirstname();
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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

