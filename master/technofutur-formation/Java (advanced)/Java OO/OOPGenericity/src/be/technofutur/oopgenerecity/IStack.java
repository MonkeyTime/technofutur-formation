package be.technofutur.oopgenerecity;

import java.util.EmptyStackException;

public interface IStack<T> {

	void push(T item) throws FullStackException, Exception;
	T pop() throws EmptyStackException;
	boolean isEmpty();
	boolean isFull();
	Iterator<T> iterator();
}
