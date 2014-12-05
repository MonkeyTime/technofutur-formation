package be.wavenet.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROMAN")
public class Roman extends Book {

	private static final long serialVersionUID = 1L;

	@Column(name = "BOOK_NBPAGES")
	private int nbPages;

	public Roman() {
		super();
	}

	public Roman(String author, String title, int nbPages) {
		super(author, title);
		this.nbPages = nbPages;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Roman [nbPages=" + nbPages + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
}
