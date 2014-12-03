package be.generic.exercice1;

public class ArrayStack<T> implements Stack<T> {

	private T[] store;
	private int cpt;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		store = (T[]) new Object[size];
		cpt=0;
	}
	
	@Override
	public void push(T o) throws FullStackException {
		if(isFull())
			throw new FullStackException("Stack is full (" + store.length + ")");
		
		store[cpt] = o;
		cpt++;
	}

	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Stack is empty");
		T o = store[cpt-1];
		store[cpt-1] = null;
		cpt--;
		return o;
	}

	@Override
	public boolean isEmpty() {
		if(cpt==0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(cpt==store.length)
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
			this.it = ArrayStack.this.cpt-1;
		}
		
		@Override
		public T next() throws NoSuchElementException {
			if(!hasNext())
				throw new NoSuchElementException("No next element");
			//it--;
			return ArrayStack.this.store[it--]; //it
		}

		@Override
		public boolean hasNext() {
			if(it>=0) //it>0
				return true;
			return false;
		}
		
	}
}
