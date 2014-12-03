package be.wavenet.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProcessor {
	private Lotto lotto = new Lotto();
	private ArrayList<Integer> myNumbers = new ArrayList<Integer>();

	public LottoProcessor() {
		this.lotto.draw();
	}

	public List<Integer> getResult() {
		return this.lotto.getResult();
	}

	public ArrayList<Integer> getMyNumbers() {
		return this.myNumbers;
	}

	public void setMyNumbers(ArrayList<Integer> myNumbers) {
		this.myNumbers = myNumbers;
	}

	public ArrayList<Integer> getMyWinningNumbers() {
		return this.lotto.getWinningNumbers(this.myNumbers);
	}

	public int getMyWinningNumbersCount() {
		return this.lotto.getWinningCount(this.myNumbers);
	}
}
