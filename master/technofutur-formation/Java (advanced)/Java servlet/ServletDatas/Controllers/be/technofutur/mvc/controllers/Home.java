package be.technofutur.mvc.controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	/**
	 * HomeServlet implementation class HomeServlet
	 */
	@WebServlet(
			name = "Home", 
			description = "servlet appelé comme index pour la web app", 
			urlPatterns = {
					"/"
			})
	
public class Home extends HttpServlet {

	private static final long serialVersionUID = 517114534519610686L;
		
	private static be.technofutur.mvc.models.Home Model = null;
	private static be.technofutur.mvc.models.Home model = null;
	private int key;
		
	public Home() {
		
		super();
		
		model = Model.getInstance();
		this.key = 0;
	}
	
	/**
	 * @see HomeServlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//statistics
		model.setStatKey(++this.key);
		model.postStatRequest(request);
		
		//test statistics
		ObjectOutputStream req = model.getStatRequest(model.getStatKey());
		System.out.println(req.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
