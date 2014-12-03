package ex4;

public class FullStackException extends RuntimeException {

   	private static final long serialVersionUID = 1L;

	public FullStackException() {
        super();
    }

    public FullStackException(String message) {
        super(message);
    }

    public FullStackException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
