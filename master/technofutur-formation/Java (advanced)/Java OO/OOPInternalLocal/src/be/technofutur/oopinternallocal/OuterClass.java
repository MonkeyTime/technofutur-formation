package be.technofutur.oopinternallocal;

public class OuterClass {

	private String outAttribut;
	
	public OuterClass() {}
	
	public void externalMethod(String arg) {
		
		//starting of method
		final String arg2 = "final arg2";
		
		//declare internal local class
		class InnerLocalClass {
			
			public String helloWorld() {
				
				return "Helo world " + OuterClass.this.outAttribut;
			}
		}
		
		//ending of method
		InnerLocalClass ilc = new InnerLocalClass();
		
		ilc.helloWorld();
		
	}
}
