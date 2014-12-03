package be.generic.exercice1;

public class ArrayStack implements Stack {

	private Object[] store;
	private int cpt;
	
	public ArrayStack(int size) {
		store = new Object[size];
		cpt=0;
	}
	
	@Override
	public void push(Object o) throws FullStackException {
		if(isFull())
			throw new FullStackException("Stack is full (" + store.length + ")");
		
		store[cpt] = o;
		cpt++;
	}

	@Override
	public Object pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Stack is empty");
		Object o = store[cpt-1];
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
	public Iterator iterator() {
		return new ArrayStackIterator();
	}
	
	public class ArrayStackIterator implements Iterator {

		private int it;
		
		public ArrayStackIterator() {
			this.it = ArrayStack.this.cpt-1;
		}
		
		@Override
		public Object next() throws NoSuchElementException {
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
