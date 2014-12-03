package be.technotic.monitoring.model;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Stats
 */
public class Stats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stats() {
        super();
     
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			//FileOutputStream fos = new FileOutputStream( new File(serialPath + "\\data.obj"));
	        //ObjectOutputStream oos = new ObjectOutputStream(fos);

		    FileInputStream fis = new FileInputStream("c:\\temp\\data.obj");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    
		    int nbMoyenParam = 0;
		    int nbGetMethod = 0;
		    int nbGetPost = 0;
		    int nombreReqs = 0;
		
		    
		    
		    try {
				@SuppressWarnings("unchecked")
				ArrayList<RequestInfo> historiques = (ArrayList<RequestInfo>) ois.readObject();
				
				  
			    for (int i = 0; i < historiques.size(); i++) {
			    	nombreReqs ++;
			    	if (historiques.get(i).getMethod().equals("GET")){
			    		nbGetMethod++;
			    	}else {
			    		nbGetPost++;
			    	}
			    	nbMoyenParam += historiques.get(i).getNbParams();
					
				}
			    
			    
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		   finally {
			   ois.close();
		   }
	
		   nbMoyenParam = nbMoyenParam /  nombreReqs;
		    
		    
		     request.setAttribute("nbGet", nbGetMethod);
		     request.setAttribute("nbPost", nbGetPost);
		     request.setAttribute("nbReqs", nombreReqs);
		     request.setAttribute("moyenParam", nbMoyenParam);
		
		    request.getRequestDispatcher("/jsp/Stats.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
