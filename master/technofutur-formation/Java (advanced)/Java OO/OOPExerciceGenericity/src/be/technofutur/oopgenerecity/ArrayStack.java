package be.technofutur.oopgenerecity;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<T> implements IStack<T> {

	protected ArrayList<T> list;
	protected static int _count;
		
	/**
	 * Constructor
	 */
	public ArrayStack() {}
	
	/**
	 * Constructor
	 * 
	 * @param q 	Quantity of elements
	 * 
	 */
	public ArrayStack(int q) {
		
		this.list = new ArrayList<T>(q);
		_count = 0;
	}

	@Override
	public void push(T item) throws Exception, FullStackException {
		
		if(item == null) {
				
			throw new Exception("Can't be null.");
		}
		
		if(this.isFull()) {
			
			throw new FullStackException("Array full.");
		}
		
		this.list.add(item);
		
		_count++;
	}

	@Override
	public T pop() {
	
		_count--;
		
		if(this.isEmpty()) {
			
			throw new EmptyStackException();
		}
		
		T item = this.list.get(_count);
		
		this.list.remove(_count);
		
		return item;
	}

	@Override
	public boolean isEmpty() {
	
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
	
		return _count > this.list.size();
	}

	@Override
	public Iterator<T> iterator() {
		
		Iterator<T> iterator = new ArrayStackIterator() {};
		
		return iterator;
	}
	
	protected class ArrayStackIterator implements Iterator<T> {

		protected int _current = 0;
		
		@Override
		public T next() {
			
			return ArrayStack.this.list.get(_current++);
		}

		@Override
		public boolean hasNext() {

			return _current < ArrayStack.this.list.size() && ArrayStack.this.list.get(_current) != null;
		}
		
	}

}
