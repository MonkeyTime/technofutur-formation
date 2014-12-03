package be.technotic.monitoring.controller.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import be.technotic.monitoring.model.RequestInfo;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Demarrage");
        String serialPath = servletContextEvent.getServletContext().getInitParameter("serial");
        
        try {
	        FileInputStream fis = new FileInputStream(new File(serialPath + "\\data.obj"));
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        ArrayList<RequestInfo> historique = (ArrayList<RequestInfo>) ois.readObject();
	        servletContextEvent.getServletContext().setAttribute("historique", historique);
	        
	        fis.close();
	        ois.close();
        }
        catch(Exception e) {
        	System.out.println("ERROR DESERIALISATION HISTORIQUE (" + e.getMessage() + ")");
        	
        }
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @SuppressWarnings("unchecked")
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Arret");
        
        String serialPath = servletContextEvent.getServletContext().getInitParameter("serial");
        try {
	        FileOutputStream fos = new FileOutputStream( new File(serialPath + "\\data.obj"));
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        
	        ArrayList<RequestInfo> historique = (ArrayList<RequestInfo>) servletContextEvent.getServletContext().getAttribute("historique");
	        
	        if(historique!=null) {
	        	oos.writeObject(historique);
	        	//oos.flush();
	        	System.out.println("ecriture");
	        }
	        
	        oos.close();
	        fos.close();
        }
        catch(Exception e) {
        	System.out.println("ERROR SERIALISATION HISTORIQUE (" + e.getMessage() + ")");
        }
    }
	
}
