package be.techno.web.interpreter.controller.wrapper;

import java.io.Serializable;
import java.sql.Connection;

public class ConnectionWrapper implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * This field won't be serialized
	 * (
	 * 	ConnectionWrapper can be used to store Not-Serializable objects into sessions
	 * 	so when container will try to serialize attributes, this won't generate errors
	 * )
	 * 
	 */
	private transient Connection connection;
	
	public ConnectionWrapper() {
		
	}
	
	public ConnectionWrapper(Connection newConnection) {
		this.setConnection(newConnection);
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Getter's alias
	 * @return
	 */
	public Connection conn() {
		return connection;
	}
}
