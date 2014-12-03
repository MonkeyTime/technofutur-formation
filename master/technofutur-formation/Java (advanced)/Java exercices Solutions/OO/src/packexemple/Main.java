package packexemple;

public class Main {

	public static void main(String[] args) {
		Personne p1 = new Personne("Toto", "Tutu", "Homme", 5);
		Personne p2 = new Personne("Titi", "Tata", 10, "Femme", 5);
		
		p1.dormir();
//		System.out.println(Personne.getNbPersonnes());
		
//		System.out.println(p1.getNom());
		System.out.println(p1.getAge());
		p1.setAge(1000);
		System.out.println(p1.getAge());
		p1.setAge(10);
		System.out.println(p1.getAge());
	}

}
