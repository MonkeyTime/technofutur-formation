package be.generic.exercice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> input = Arrays.asList(10,20,20,3,2,2,4);
		List<String> inputStr = Arrays.asList("1", "2", "3", "4");
		
		Predicate<Integer> predicat = new EvenPredicate<Integer>();
		
		Predicate<String> predicatNeg = new NegativePredicate<String>();
		
		List<String> outputStr = Lists.select(inputStr, predicatNeg);
		System.out.println(outputStr);
		
		List<Integer> output = Lists.select(input, predicat);
		System.out.println(output.toString());
		
		//List<Integer> negOutput = Lists.select(input, predicatNeg);
		
		//List<Integer> input = Arrays.asList(10,20,20,3,2,2,4);
		//Lists.print(input);
		
		Main.iteration(5,10,20);
		Main.iteration();
		Main.iteration(1);
	}
	
	public static void iteration(Integer... array) {
		for(Integer i : array) {
			System.out.println(i);
		}
		System.out.println();
	}

}
