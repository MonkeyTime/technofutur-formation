package ex4;

import java.util.LinkedList;
import java.util.List;

public class ArrayStack implements Stack {

    private List<Object> elements;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.elements = new LinkedList<Object>();
    }

    @Override
    public void push(Object value) {
        if (isFull()) {
            throw new FullStackException();
        }

        elements.add(value);
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (elements.remove(elements.size() - 1));
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (elements.get(elements.size() - 1));
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean isFull() {
        return elements.size() == capacity;
    }
}
