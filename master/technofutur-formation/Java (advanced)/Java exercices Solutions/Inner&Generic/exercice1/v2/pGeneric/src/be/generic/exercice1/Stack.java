package be.generic.exercice1;

public interface Stack {
	public void push(Object o) throws FullStackException;
	public Object pop() throws EmptyStackException;
	public boolean isEmpty();
	public boolean isFull();
	
	public Iterator iterator();
}
