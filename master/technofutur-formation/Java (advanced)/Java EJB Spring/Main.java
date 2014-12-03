package be.techno;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

	public static void main(String[] args) throws NamingException {
		
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		jndiProps.put("jboss.naming.client.ejb.context", true);
		
		Context ctx = new InitialContext(jndiProps);
		
		
		MyRemote remote = (MyRemote) ctx.lookup("MyRemoteProjectEAR/MyRemoteProject/MyRemoteImpl!be.techno.MyRemote");
	
		System.out.println(remote.testRemote());
	}
	
}



