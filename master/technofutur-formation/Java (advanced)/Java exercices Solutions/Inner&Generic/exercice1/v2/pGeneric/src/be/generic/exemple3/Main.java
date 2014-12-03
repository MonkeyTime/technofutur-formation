package be.generic.exemple3;

import java.util.ArrayList;

import be.generic.exercice1.ArrayStack;
import be.generic.exercice1.EmptyStackException;
import be.generic.exercice1.FullStackException;
import be.generic.exercice1.Iterator;
import be.generic.exercice1.NoSuchElementException;
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
		
		
		System.out.println("----");
		Stack stack2 = new ArrayStack(5);
		
		try {
			stack2.push("e1");
			stack2.push("e2");
		} catch (FullStackException e) {
			e.printStackTrace();
		}
		
		Iterator iterator = stack2.iterator();
		//System.out.println(iterator.hasNext());
		
		while(iterator.hasNext()) {
			try {
				System.out.println(iterator.next());
				
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		
	}

}
