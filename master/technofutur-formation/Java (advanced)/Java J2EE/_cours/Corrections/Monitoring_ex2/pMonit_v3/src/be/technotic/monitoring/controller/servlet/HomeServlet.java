package be.technotic.monitoring.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technotic.monitoring.model.RequestInfo;

/**
 * Servlet implementation class HomeServlet
 */

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Methode : " + request.getMethod() + "\n");
		sb.append("URL : " + request.getRequestURL() + "\n");
		sb.append("Status : " + response.getStatus() + "\n");
		sb.append("User-Agent : " + request.getHeader("User-Agent") + "\n");
		
		Enumeration<String> params = request.getParameterNames();
		int nbParams = 0;
		while(params.hasMoreElements()) {
			String paramName = params.nextElement();
			/*String paramValue = */request.getParameter(paramName);
			nbParams ++;
		}
		
		sb.append("Nb Params : " + nbParams + "\n");
		
		//this.getServletContext().log(sb.toString());
		System.out.println(sb.toString());
		
		RequestInfo ri = new RequestInfo(request.getMethod(), 
				request.getRequestURL().toString(),
				request.getHeader("User-Agent"),
				response.getStatus(),
				nbParams
		); 
		
		ArrayList<RequestInfo> historique = (ArrayList<RequestInfo>) this.getServletContext().getAttribute("historique");
		if(historique==null) {
			historique = new ArrayList<RequestInfo>();
			this.getServletContext().setAttribute("historique", historique);
		}
		
		historique.add(ri);
		
		System.out.println("Current request count in historique : " + historique.size());
		
		
		ArrayList<String> infos = new ArrayList<String>();
		infos.add(request.getMethod());
		infos.add(request.getRequestURL().toString());
		infos.add(String.valueOf(response.getStatus()));
		infos.add(request.getHeader("User-Agent"));
		infos.add(String.valueOf(nbParams));
		
		request.setAttribute("infos", infos);
		
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
