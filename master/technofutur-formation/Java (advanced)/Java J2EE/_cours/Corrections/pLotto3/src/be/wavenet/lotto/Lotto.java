package be.wavenet.lotto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Lotto implements Serializable {
	private static final long serialVersionUID = -1335572423561034170L;
	private static final int MAX = 42;
	private static final int SIZE = 6;
	private HashSet<Integer> result = new HashSet<Integer>();

	public List<Integer> getResult() {
		List<Integer> l = new ArrayList<Integer>(result);
		Collections.sort(l);
		return l;
	}

	public void draw() {
		this.draw(Lotto.MAX, Lotto.SIZE);
	}

	public void draw(int max, int size) {
		Random random = new Random();
		while(result.size()!=SIZE) {
			result.add(random.nextInt(MAX));
		}
	}

	public int getWinningCount(ArrayList<Integer> numbers) {
		return this.getWinningNumbers(numbers).size();
	}

	public ArrayList<Integer> getWinningNumbers(ArrayList<Integer> numbers) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (Integer i : numbers) {
			if(result.contains(i))
				r.add(i);
			if(r.size()==SIZE)
				break;
		}
		return r;
	}
}
