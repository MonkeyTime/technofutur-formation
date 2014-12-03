package packheritageinterface03;

public class Personne implements EtatCivil {

	private String numeroRegistreNational;
	private String nom;
	
	public Personne(String numero, String nom) {		
		this.numeroRegistreNational = PREFIXE_NUMERO_REGISTRE + numero;
		this.nom = nom;
	}

	public String getNumeroRegistreNational() {
		return numeroRegistreNational;
	}
	
	public String toString() {
		return nom + ": " + numeroRegistreNational;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Personne) {
			Personne p = (Personne) o;
			return p.nom.equals(nom) && p.numeroRegistreNational.equals(numeroRegistreNational);
		}
		return false;
	}
}
