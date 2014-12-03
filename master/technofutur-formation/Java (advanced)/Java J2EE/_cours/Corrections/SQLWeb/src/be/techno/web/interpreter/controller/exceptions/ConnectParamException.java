package be.techno.web.interpreter.controller.exceptions;

public class ConnectParamException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectParamException(String url, String user, String pwd) {
		super("Some connection params are incorrect (url:" + url + " user:" + user + " pwd:" + pwd + ")");
	}
}
