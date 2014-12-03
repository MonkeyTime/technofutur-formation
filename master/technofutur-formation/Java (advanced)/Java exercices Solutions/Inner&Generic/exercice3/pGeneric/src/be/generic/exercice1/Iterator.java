package be.generic.exercice1;

public interface Iterator<E> {
	public E next() throws NoSuchElementException;
	public boolean hasNext();
}
