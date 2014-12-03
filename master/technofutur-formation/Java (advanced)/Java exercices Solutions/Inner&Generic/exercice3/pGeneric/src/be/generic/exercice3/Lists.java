package be.generic.exercice3;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static <E> List<E> select(List<E> input, Predicate<E> p) {
		List<E> output = new ArrayList<E>();
		for(E e : input) {
			if(p.match(e)) {
				output.add(e);
			}
		}
		return output;
	}
	
	public static <T> void print(List<T> input) {
		System.out.print("[");
		for(T t : input)
			System.out.print("(" + t.toString() + ")");
		System.out.println("]");
	}
	
}
