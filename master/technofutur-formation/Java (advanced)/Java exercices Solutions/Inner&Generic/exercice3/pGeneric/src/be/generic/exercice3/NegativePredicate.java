package be.generic.exercice3;

public class NegativePredicate<T> implements Predicate<T> {

	@Override
	public boolean match(T elem) {
		if(elem instanceof Integer) {
			if((int)elem<0)
				return true;
		}
		return false;
	}

}
