package packexercice3;

public class Main {

	public static void main(String[] args)  {		
		Etudiant et = new Etudiant("Toto","Dupont");
		
		try{
			et.ajouterCours(new Cours("Java", 2014, 10));
			et.ajouterCours(new Cours("C", 2014, 8));
			et.ajouterCours(new Cours("MySQL", 2014, 5));
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
		try {
			et.ajouterCours(new Cours("Java",2014,24));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(et.getCours(-1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(et.getCours(10));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(et.getCours(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(et.getCours(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try{
			et.ajouterCours(new Cours("Oracle", 2014, 12));
			et.ajouterCours(new Cours("C++", 2014, 80));
			et.ajouterCours(new Cours("XML", 2014, 5));
			et.ajouterCours(new Cours(".NET", 2014, 12));
			et.ajouterCours(new Cours("PHP", 2014, 80));
			et.ajouterCours(new Cours("HTML", 2014, 5));
			et.ajouterCours(new Cours("CSS", 2014, 12));
			et.ajouterCours(new Cours("Javascript", 2014, 80));
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
}
