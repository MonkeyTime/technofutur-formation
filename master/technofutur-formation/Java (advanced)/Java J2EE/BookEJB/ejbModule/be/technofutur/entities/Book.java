package be.technofutur.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4633922312636613064L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="title", nullable = false)
    private String title;
	
	@Column(name="author", nullable = false)
    private String author;

    public Book(){}

    public int getId() {
    	return id;
    }

    public void setId(int id) {
    	this.id = id;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getAuthor() {
    	return this.author;
    }
    
 
    public void setAuthor(String author) {
    	this.author = author;
    }
}
