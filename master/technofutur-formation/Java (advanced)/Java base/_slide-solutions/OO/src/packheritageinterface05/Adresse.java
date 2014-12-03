package packheritageinterface05;

public class Adresse {

	private String rue;
	private int numero;
	private String boite;
	private int cp;
	private String ville;
	
	public Adresse(String rue, int numero, String boite, int cp, String ville) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.boite = boite;
		this.cp = cp;
		this.ville = ville;
	}

	public Adresse(String rue, int numero, int cp, String ville) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.boite = null;
		this.cp = cp;
		this.ville = ville;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder(rue);
		buffer.append(" ");
		buffer.append(numero);
		if (boite != null) {
			buffer.append(boite);
		}
		buffer.append(" ");
		buffer.append(cp);
		buffer.append(" ");
		buffer.append(ville);
		return buffer.toString();
	}
}
