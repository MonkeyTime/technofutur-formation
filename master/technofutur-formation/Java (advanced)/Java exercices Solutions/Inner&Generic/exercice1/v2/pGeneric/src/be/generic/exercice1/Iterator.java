package be.generic.exercice1;

public interface Iterator {
	public Object next() throws NoSuchElementException;
	public boolean hasNext();
}
