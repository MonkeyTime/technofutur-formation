package be.generic.exemple3;

import java.util.ArrayList;
import java.util.Iterator;

import be.generic.exercice1.ArrayStack;
import be.generic.exercice1.EmptyStackException;
import be.generic.exercice1.FullStackException;
import be.generic.exercice1.Stack;

public class Main {

	public static void main(String[] args) {
		/*ArrayList<String> liste = new ArrayList<String>();
		liste.add("elem1");
		liste.add("elem2");
		liste.add("elem3");
		
		System.out.println("size : " + liste.size());
		
		for(int i=0 ; i<liste.size() ; i++)
			System.out.println(liste.get(i));
		
		for(String e : liste) {
			System.out.println(e);
		}
		
		Iterator<String> iterator = liste.iterator();
		while(iterator.hasNext()) {
			String elem = iterator.next();
			System.out.println(elem);
		}*/
		/**********************************************/
		
		Stack stack = new ArrayStack(2);
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		try {
			stack.push("elem1");
			stack.push("elem2");
			//stack.push("elem3");
		} catch (FullStackException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			/*String s = (String) stack.pop();
			System.out.println(s);*/
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		
		/*Object o = stack.pop();
		
		Iterator iterator = stack.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
		}*/
		
	}

}
