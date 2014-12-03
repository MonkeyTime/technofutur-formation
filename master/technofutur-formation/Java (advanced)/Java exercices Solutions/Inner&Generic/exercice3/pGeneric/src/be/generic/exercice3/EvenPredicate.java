package be.generic.exercice3;

public class EvenPredicate<E extends Integer> implements Predicate<E> {

	@Override
	public boolean match(E elem) {
		//elem.getClass().equals(Integer.class)
		
		if(elem instanceof Integer) {
			if((int)elem%2 == 0)
				return true;
		}
		return false;
	}

}
