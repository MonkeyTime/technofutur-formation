package be.generic.exercice1;

public interface Stack<E> {
	public void push(E o) throws FullStackException;
	public E pop() throws EmptyStackException;
	public boolean isEmpty();
	public boolean isFull();
	
	public Iterator<E> iterator();
}
