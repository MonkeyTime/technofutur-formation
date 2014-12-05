package be.wavenet.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BANDEDESSINEE")
public class BandeDessinee extends Book {

	private static final long serialVersionUID = 1L;

	@Column(name = "BOOK_EDITOR")
	private String editeur;

	public BandeDessinee() {
		super();
	}

	public BandeDessinee(String author, String title, String editeur) {
		super(author, title);
		this.editeur = editeur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	@Override
	public String toString() {
		return "BandeDessinee [editeur=" + editeur + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
}
