package be.technotic.monitoring.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technotic.monitoring.model.RequestInfo;

public class Profiler extends HttpServlet {

	/**
	 * 
	 * Cette Servlet a pour but d'utiliser l'ArrayList de RequestInfo afin d'en calculer des statistiques
	 * Exercice 3.a
	 * 
	 * Une fois les statistiques calcul�e, la servlet passera les donn�es � la jsp statistiques.jsp
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		ArrayList<RequestInfo> historique = (ArrayList<RequestInfo>) this.getServletContext().getAttribute("historique");
		
		if(historique!=null) {
			long totalRequests = historique.size();
			
			if(totalRequests!=0) {
				long getRequestCount = this.countGetRequests(historique);
				long postRequestCount = this.countPostRequests(historique);
				
				double getRequestAvg = 0;
				if(getRequestCount!=0)
					getRequestAvg = totalRequests / getRequestCount;
				
				double postRequestAvg = 0;
				if(postRequestCount!=0)
					postRequestAvg = totalRequests / postRequestCount;
				
				double getUsage = (100*getRequestCount)/totalRequests;
				double postUsage = (100*postRequestCount)/totalRequests;
				
				double paramsAvg = this.averageParams(historique);
				
				HashMap<String,Long> browsers = this.browsers(historique);
				
				System.out.println("total(" + totalRequests + ") get(" + getRequestCount + ") avg(" + getRequestAvg + ") use(" + getUsage + ")");
				System.out.println("total(" + totalRequests + ") post(" + postRequestCount + ") avg(" + postRequestAvg + ") use(" + postUsage + ")");
			
				System.out.println(paramsAvg);
				
				req.setAttribute("totalRequests", totalRequests);
				req.setAttribute("getRequests", getRequestCount);
				req.setAttribute("postRequests", postRequestCount);
				
				req.setAttribute("getRequestAvg", getRequestAvg);
				req.setAttribute("postRequestAvg", postRequestAvg);
				
				req.setAttribute("getUsage", getUsage);
				req.setAttribute("postUsage", postUsage);
				
				req.setAttribute("paramsAvg", paramsAvg);
				
				req.setAttribute("browsers", browsers);
				
				req.getRequestDispatcher("/jsp/statistiques.jsp").forward(req, resp);
			}
			else {
				// pas de stats
				System.out.println("No stats");
				req.getRequestDispatcher("/main/index").forward(req, resp);
			}
		}
		else {
			req.getRequestDispatcher("/main/index").forward(req, resp);
		}
		
	}
	
	private long countGetRequests(ArrayList<RequestInfo> historique) {
		return countRequestsOnType(historique, "GET");
	}
	
	private long countPostRequests(ArrayList<RequestInfo> historique) {
		return countRequestsOnType(historique, "POST");
	}
	
	/**
	 * Cette m�thode renvoie le nombre de requetes pour un type donn�.
	 * 
	 * @param historique	ArrayList<RequestInfo> utilis� comme datastore
	 * @param methodType	String d�finissant le type (GET / POST)
	 * @return	Long repr�sentant le nb de requetes du type donn�
	 */
	private long countRequestsOnType(ArrayList<RequestInfo> historique, String methodType) {
		long count = 0;
		for(RequestInfo ri : historique) {
			if(ri.getMethod().equals(methodType))
				count++;
		}
		return count;
	}
	
	/**
	 * Cette m�thode construit une Hashmap qui contiendra comme cl� le nom des browsers,
	 * et en valeur le nombre de fois qu'ils ont �t� utilis�.
	 * 
	 * Exemple du contenu de la map:
	 * 	Mozilla	2
	 * 	IE		1
	 * 	Chrome	3
	 * 
	 * @param historique	ArrayList<RequestInfo> utilis� comme datastore
	 * @return Hashmap compl�t�e avec les browsers utilis�s
	 */
	private HashMap<String, Long> browsers(ArrayList<RequestInfo> historique) {
		HashMap<String, Long> browsers = new HashMap<>();
		
		for(RequestInfo ri : historique) {
			String browser = ri.getUserAgent();
			Long l = browsers.get(browser);
			
			//Si le nombre stock� est null, cela signifie que le User-Agent
			//n'�tait pas encore dans la Hashmap, c'est la premi�re fois qu'on le compte
			if(l==null) {
				browsers.put(browser, 1L);
			}
			//Si le nombre n'est pas null, il faut incr�ment� sa valeur
			//car le User-Agent a d�j� �t� compt� une fois
			else {
				browsers.put(browser, l+1);
			}
		}
		
		return browsers;
	}
	
	/**
	 * Cette m�thode permet de r�cup�rer le nombre moyen de param�tres pour les requ�tes re�ues
	 * 
	 * @param historique	ArrayList<RequestInfo> utilis� comme datastore
	 * @return Long repr�sentant la moyenne calcul�e de params
	 */
	private double averageParams(ArrayList<RequestInfo> historique) {
		if(historique.size()==0)
			return 0.;
		
		long reqCount = 0;
		long paramsCount = 0;
		for(RequestInfo ri : historique) {
			reqCount++;
			paramsCount += ri.getNbParams();
		}
		if(reqCount==0)
			return 0.;
		return paramsCount/reqCount;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
