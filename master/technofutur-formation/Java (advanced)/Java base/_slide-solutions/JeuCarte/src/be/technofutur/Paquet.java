package jeucarte;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Paquet {
	private List<Carte> cartes;
	
	public Paquet(){
		this.cartes = new LinkedList<Carte>();		
	}
	
	public void remplirPaquet(){
		for(Couleur couleur : Couleur.values()){
			for(Rang rang : Rang.values()){
				this.cartes.add(new Carte(couleur,rang));
			}
		}
		Collections.shuffle(this.cartes);
	}

	public void fusionerPaquet(Paquet paquet){
		this.cartes.addAll(paquet.cartes);
		melanger();
	}
	
	public Carte jouerCarte(){
		if (!estVide()){
			Carte carte = this.cartes.get(taille() - 1);
			this.cartes.remove(carte);
			
			return carte;
		} else {
			return null;
		}
	}
	
	public void ajouterCarte(Carte carte){
		this.cartes.add(carte);
	}
	
	public void melanger(){
		Collections.shuffle(this.cartes);
	}
	
	public boolean estVide(){
		return this.cartes.isEmpty();
	}
	
	public void viderPaquet(){
		this.cartes.clear();
	}
	
	public Integer taille(){
		return this.cartes.size();
	}
}
