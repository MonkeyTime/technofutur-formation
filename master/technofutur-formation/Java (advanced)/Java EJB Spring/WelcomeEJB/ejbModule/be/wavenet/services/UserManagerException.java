package be.wavenet.services;

public class UserManagerException extends Exception {
 
	public UserManagerException(Throwable cause) {
		super(cause);
	}
	
	public UserManagerException(String message) {
		super(message);
	}
	
	public UserManagerException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
