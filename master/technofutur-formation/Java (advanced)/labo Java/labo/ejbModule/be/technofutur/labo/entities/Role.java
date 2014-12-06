package be.technofutur.labo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="name", nullable = false, length = 55)
    private String name;
	
	@Column(name="description", nullable = true, length = 255)
    private String desciption;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
}
