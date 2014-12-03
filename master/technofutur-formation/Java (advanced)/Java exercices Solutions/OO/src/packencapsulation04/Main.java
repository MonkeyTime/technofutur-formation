package packencapsulation04;

public class Main {

	public static void main(String[] args) {

		Jour j1 = new Jour("Vendredi");
		System.out.println(j1);		
		
		j1.nextDay();
		System.out.println(j1);
		
		Jour j2 = j1.getPreviousDay();
		System.out.println(j2);
	}

}
