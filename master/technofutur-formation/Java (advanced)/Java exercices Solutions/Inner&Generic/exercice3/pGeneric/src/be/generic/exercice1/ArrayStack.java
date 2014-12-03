package be.generic.exercice1;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> implements Stack<T> {

	private List<T> store;
	private int capacity;
	
	public ArrayStack(int size) {
		store = new ArrayList<T>();
		this.capacity = size;
	}
	
	@Override
	public void push(T o) throws FullStackException {
		if(isFull())
			throw new FullStackException("Stack is full (" + store.size() + "/" + capacity + ")");
		
		store.add(o);
	}

	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Stack is empty");
		
		return store.remove(store.size()-1);
	}

	@Override
	public boolean isEmpty() {
		/*if(store.size()==0)
			return true;
		return false;*/
		return store.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(capacity==store.size())
			return true;
		return false;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ArrayStackIterator();
	}
	
	public class ArrayStackIterator implements Iterator<T> {

		private int it;
		
		public ArrayStackIterator() {
			this.it = ArrayStack.this.store.size()-1;
		}
		
		@Override
		public T next() throws NoSuchElementException {
			if(!hasNext())
				throw new NoSuchElementException("No next element");
			//it--;
			return ArrayStack.this.store.get(it--); //it
		}

		@Override
		public boolean hasNext() {
			if(it>=0) //it>0
				return true;
			return false;
		}
		
	}
}
