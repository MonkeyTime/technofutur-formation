package packheritageinterface04;

public class Carre implements Form {

	private double cote;

	public Carre(double cote) {		
		this.cote = cote;
	}

	public double perimetre() {
		return 4 * cote;
	}

	public double aire() {
		return cote * cote;
	}
	
	public String toString() {
		return "Côté: " + cote;
	}
}
