package be.technotic.monitoring.model;

import java.io.Serializable;
import java.util.Date;

public class RequestInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String method;
	private String url;
	private String userAgent;
	private int status;
	private int nbParams ;
	
	public RequestInfo() {
		this.method = "GET";
		this.url = "/";
		this.userAgent = "none";
		this.status = 200;
		this.nbParams = 0;
	}
	
	public RequestInfo(String method, String url, String ua, int status, int nbParams) {
		this.method = method;
		this.url = url;
		this.userAgent = ua;
		this.status = status;
		this.nbParams = nbParams;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNbParams() {
		return nbParams;
	}

	public void setNbParams(int nbParams) {
		this.nbParams = nbParams;
	}
	
	
}
