package be.generic.exemple3;

import be.generic.exercice1.ArrayStack;
import be.generic.exercice1.EmptyStackException;
import be.generic.exercice1.FullStackException;
import be.generic.exercice1.Stack;

public class Main {

	public static void main(String[] args) {

		Stack<Integer> stack = new ArrayStack<Integer>(2);
		try {
			stack.push(20);
			Integer o = stack.pop();
			System.out.println(o);
			System.out.println(stack.isEmpty());
			System.out.println(stack.isFull());
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} catch (FullStackException e) {
			e.printStackTrace();
		}
		
	}

}
