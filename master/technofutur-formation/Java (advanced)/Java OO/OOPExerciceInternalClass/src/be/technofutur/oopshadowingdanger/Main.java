package be.technofutur.oopshadowingdanger;

public class Main {

	public static void main(String[] args) {
		
		Lion lion1 = new Lion();
		Lion lion2 = new Lion() {
			
			@Override
			public void eat() {
				//super.eat();
				System.out.println("Je mange comme une biche");
			}
		};
		
		lion1.eat();
		lion2.eat();
	}

}
