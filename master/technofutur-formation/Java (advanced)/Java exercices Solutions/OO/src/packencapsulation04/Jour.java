package packencapsulation04;

public class Jour {

	private int num;
	private static String CODE = "DILUMAMEJEVESA";
	private static String []NOMS = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	
	public Jour() {
		num = 0;
	}
	
	public Jour(String chaine) {
		// Sans chaîne vide (""): addition des codes ASCII => retourne un int
		chaine = chaine.charAt(0) + "" + chaine.charAt(1);
		String abrev;
		
		for (int i = 0 ; i < (CODE.length() / 2) ; i++) {
			// Sans chaîne vide (""): addition des codes ASCII => retourne un int
			abrev = CODE.charAt(2 * i) + "" + CODE.charAt((2 * i) + 1);
			
			// Equivalence en ignorant la casse (min/MAJ)
			if (chaine.equalsIgnoreCase(abrev)) {
				num = i;
				break;
			}
		}
	}
	
	public void nextDay() {
		if (num != 6) {
			num++;
		} else {
			num = 0;
		}
	}
	
	public Jour getPreviousDay() {
		Jour j;
		if (num != 0) {
			j = new Jour(NOMS[num - 1]);
		} else {
			j = new Jour(NOMS[6]);
		}
		return j;
	}
	
	public String toString() {
		return NOMS[num];
	}
}
