package be.technofutur.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6979110410444008380L;
	protected String firstName, lastName, birthDate, job;
	
	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param job
	 * 
	 */
	public Person(String firstName, String lastName, String birthDate, String job) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.job = job;
	}

	/**
	 * save
	 * 
	 * Save object in file
	 * 
	 */
	protected void save() {
		
		ObjectOutputStream out = null;
		
		try {
			
			out = new ObjectOutputStream(new FileOutputStream("datas/Persons.dat"));
			out.writeObject(this);
			  
		} catch(Exception e) {
			
			  e.printStackTrace();  
			  
		} finally {
			
			try {
				
				if(out != null) {
					
					out.close();
				}
				
			} catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * read
	 * 
	 * read object from saved file
	 * 
	 */
	protected void read() {
		
		ObjectInputStream in = null;
		Person person = null;
		
		try {
		      in = new ObjectInputStream(new FileInputStream("datas/Persons.dat"));
		      person = (Person)in.readObject();
		      System.out.println(person.firstName + " " + person.lastName + " " + person.birthDate + " " + person.job);
		      
		} catch(Exception e) {
		      
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(in != null) {
					
					in.close();
				}
				
			} catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Person person = new Person("Laurent", "Bertrand", "27/11/1977", "Developer");
		person.save();
		person.read();
		
		Person person2 = new Person("Georges", "Clooney", "01/01/1960", "Actor");
		person2.save();
		person2.read();
	}
}
