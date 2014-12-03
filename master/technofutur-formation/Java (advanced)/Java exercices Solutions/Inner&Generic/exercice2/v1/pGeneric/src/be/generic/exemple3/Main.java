package be.generic.exemple3;

import java.util.ArrayList;
import java.util.HashMap;

import be.generic.exercice1.ArrayStack;
import be.generic.exercice1.EmptyStackException;
import be.generic.exercice1.FullStackException;
import be.generic.exercice1.Iterator;
import be.generic.exercice1.NoSuchElementException;
import be.generic.exercice1.Stack;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> map;
		
		Stack<Integer> stack = new ArrayStack<Integer>(2);
		try {
			stack.push(20);
			Integer o = stack.pop();
			System.out.println(o);
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} catch (FullStackException e) {
			e.printStackTrace();
		}
		
	}

}
