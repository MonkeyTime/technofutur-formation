package be.wavenet.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import be.wavenet.domain.exceptions.ValidationException;

@Entity
@Table(name = "BOOK")
// Requêtes JPQL
@NamedQueries({
		@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b ORDER BY b.title"),
		@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title LIKE :title ORDER BY b.title"),
		@NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id") })
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Integer id;
	
	// title correspond à la colonne BOOK_TITLE, ne peut être null (255 car.
	// max)
	@Column(name = "BOOK_TITLE", nullable = false, length = 255)
	private String title;
	
	// author correspond à la colonne BOOK_AUTHOR
	@Column(name = "BOOK_AUTHOR")
	private String author;

	public Book() {
		
	}

	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return 31 + ((id == null) ? 0 : id.hashCode());
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;

		if (object == null)
			return false;

		if (this.getClass() != object.getClass())
			return false;

		Book other = (Book) object;

		if (id == null) {
			if (other.id != null)
				return false;
		} else {
			if (!id.equals(other.id))
				return false;
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder(this.id + ": " + this.title);
		b.append(" by " + this.author);

		return b.toString();
	}

	// Méthode automatiquement exécutée avant chaque persistence et avant chaque
	// mise à jour dans la DB
	@PrePersist
	@PreUpdate
	public void validate() {
		if (title == null || title.trim().length() == 0)
			throw new ValidationException("Invalid title");
	}
}
