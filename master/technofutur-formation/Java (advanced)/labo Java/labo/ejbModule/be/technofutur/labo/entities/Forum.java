package be.technofutur.labo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Forum")
public class Forum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="name", nullable = false, length = 50)
    private String name;
	
	@Column(name="description", nullable = true, length = 255)
    private String description;
	
	@Column(name="totalTopics", nullable = true)
	private int totalTopics;
	
	@Column(name="totalPosts", nullable = true)
	private int totalPosts;
	
	@Column(name="categoryId", nullable = false)
	private int categoryId;

	public Forum() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalTopics() {
		return totalTopics;
	}

	public void setTotalTopics(int totalTopics) {
		this.totalTopics = totalTopics;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Forum " + id + " - " + name;
	}
}
