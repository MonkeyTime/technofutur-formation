package be.techno.web.interpreter.controller.listener;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
    	super();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @SuppressWarnings("unchecked")
	public void contextDestroyed(ServletContextEvent event)  {
    	System.out.println("Context destroyed");
    	
    	Object o = event.getServletContext().getAttribute("storedSessions");
    	if( o!=null && (o instanceof ConcurrentHashMap) ) {
    		
    		ConcurrentHashMap<HttpSession, Connection> storedUserSessions = (ConcurrentHashMap<HttpSession, Connection>) o;
    		
    		Iterator<Entry<HttpSession, Connection>> it = storedUserSessions.entrySet().iterator();
	    	int i=0;
	    	while(it.hasNext()) {
	    		Entry<HttpSession, Connection> entry = it.next();
	    		Connection c = entry.getValue();
	    		if(c!=null) {
		    		try {
						c.close();
						System.out.println("Session's connection[" + i + "] successfully closed");
					} catch (SQLException e) {
						e.printStackTrace();
					}
	    		}
	    		i++;
	    	}
    		
    	}
    	
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  {
    	System.out.println("Context initialized");
    	
    	event.getServletContext().setAttribute("storedSessions", new ConcurrentHashMap<HttpSession, Connection>());
    	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
    }

}
