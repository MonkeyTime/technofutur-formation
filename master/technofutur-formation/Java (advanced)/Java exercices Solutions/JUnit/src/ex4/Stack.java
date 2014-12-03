package ex4;

public interface Stack {

    void push(Object value);

    Object pop();

    Object peek();

    boolean isFull();

    boolean isEmpty();
}
