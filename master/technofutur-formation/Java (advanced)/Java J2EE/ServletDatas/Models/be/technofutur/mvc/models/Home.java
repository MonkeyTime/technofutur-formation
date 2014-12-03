package be.technofutur.mvc.models;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Home {

	protected Map<Integer, ObjectOutputStream> headers;
	protected int statKey;
	
	private Home() {}
	
	public Home getInstance() {
		
		this.headers = new HashMap<Integer, ObjectOutputStream>();
		
		return new Home();
	}

	public void setStatKey(int i) {
		
		this.statKey = i;
	}
	
	public int getStatKey() {
		
		return this.statKey;
	}

	public void postStatRequest(HttpServletRequest request) throws IOException {
		
		FileOutputStream fileOut = new FileOutputStream("/tmp/request.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(request);

		this.headers.put(++this.statKey, out);
		
		out.close();
		fileOut.close();
	}
	
	public ObjectOutputStream getStatRequest(int i) throws IOException {
		
		return this.headers.get(i);
	}
}
