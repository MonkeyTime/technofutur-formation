package be.technofutur.oopgenerecity;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayStack<String> stack = new ArrayStack<String>(10);
		
		stack.push("Elem 1");
		stack.push("Elem 2");
		stack.push("Elem 3");
		stack.push("Elem 4");
		stack.push("Elem 5");
		
		String elemPop1 = stack.pop();
		String elemPop2 = stack.pop();
		
		System.out.println("Element deleted: " + elemPop1 + ", " + elemPop2);
		
		Iterator<String> iterator = stack.iterator();
		
		while(iterator.hasNext()) {
			
			String str = iterator.next();
			
			System.out.println(str);
			
		}
		
	}
}
