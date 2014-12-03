package be.wavenet.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MyLotto {
	private static final int MAX = 42;
	private static final int SIZE = 6;
	private HashSet<Integer> lottoNumbers;
	
	public MyLotto() { }
	
	public void draw() {
		Random rand = new Random();
		lottoNumbers = new HashSet<Integer>();
		
		while(lottoNumbers.size()!=SIZE) {
			lottoNumbers.add(rand.nextInt(MAX));
		}
	}
	
	public Integer[] getWinningNumbers(Integer[] numbers) {
		List<Integer> winning = new ArrayList<Integer>();
		for(Integer i : numbers) {
			if(lottoNumbers.contains(i))
				winning.add(i);
		}
		return (Integer[]) winning.toArray(new Integer[winning.size()]);
	}
	
	public Integer[] toArray() {
		Integer[] n = lottoNumbers.toArray(new Integer[lottoNumbers.size()]);
		Arrays.sort(n);
		return n;
	}
	
	@Override
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		out.append("[");
		Integer[] numbers = toArray();
		for(Integer number : numbers) {
			if(number!=numbers[numbers.length-1])
				out.append(number + ",");
			else
				out.append(number);
		}
		out.append("]");
		return out.toString();
	}
}
