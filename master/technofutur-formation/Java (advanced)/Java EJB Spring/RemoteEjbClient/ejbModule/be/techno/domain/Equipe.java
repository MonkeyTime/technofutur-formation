package be.techno.domain;

import java.io.Serializable;

public class Equipe implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nom;
	private int pts;
	
	public Equipe(){}
	
	public Equipe(String nom, int pts){
		this.nom = nom;
		this.pts = pts;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	
	
	public boolean equals(Object o){
		Equipe e = (Equipe) o;
		
		return e.nom.equals(nom);
	}
	
	
	
}
