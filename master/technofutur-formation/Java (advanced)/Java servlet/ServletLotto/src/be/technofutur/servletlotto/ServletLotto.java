package be.technofutur.servletlotto;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 	/**
 	 * HomeServlet implementation class HomeServlet
 	 */
 	@WebServlet(
 			name = "ServletLotto", 
 			description = "servlet appelé comme index pour la web app", 
 			urlPatterns = {
 					"/index.html"
 			}, 
 			initParams = { 
 					@WebInitParam(name = "db_hostname", value = "localhost")
 			})
 	public class ServletLotto extends HttpServlet {
 	   

 		/**
		 * 
		 */
		private static final long serialVersionUID = -4244923300508727809L;

		/**
 	     * @see HttpServlet#HttpServlet()
 	     */
 	    public ServletLotto() {
 	        super();
 	        // TODO Auto-generated constructor stub
 	        System.out.println("Constructor");
 	    }

 		/**
 		 * @see HomeServlet#init(ServletConfig)
 		 */
 		public void init(ServletConfig config) throws ServletException {
 			// TODO Auto-generated method stub
 			System.out.println("Init");
 		}

 		/**
 		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 		 */
 		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 			// TODO Auto-generated method stub
 			System.out.println("Get");
 			response.setContentType("text/html");
 	 		response.getWriter().print("<html><head></head>"
 	 				+ "<body><form method=\"POST\" action=\"\">"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"1\">01"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"2\">02"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"3\">03"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"4\">04"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"5\">05"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"6\">06"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"7\">07"
 	 				+ "<br />"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"8\">08"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"9\">09"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"10\">10"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"11\">11"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"12\">12"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"13\">13"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"14\">14"
 	 				+ "<br />"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"15\">15"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"16\">16"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"17\">17"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"18\">18"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"19\">19"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"20\">20"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"21\">21"
 	 				+ "<br />"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"22\">22"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"23\">23"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"24\">24"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"25\">25"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"26\">26"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"27\">27"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"28\">28"
 	 				+ "<br />"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"29\">29"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"30\">30"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"31\">31"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"32\">32"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"33\">33"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"34\">34"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"35\">35"
 	 				+ "<br />"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"36\">36"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"37\">37"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"38\">38"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"39\">39"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"40\">40"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"41\">41"
 	 				+ "<input type=\"checkbox\" name=\"lotto\" value=\"42\">42"
 	 				+ "<br />"
 	 				+ "<input type=\"submit\" value=\"ok\" />"
 	 				+ "<input type=\"reset\" value=\"reset\" />"
 	 				+ "</form></body></html>");
 		}

 		/**
 		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 			// TODO Auto-generated method stub
 			
 			System.out.println("Post");
 			
 			String[] numbers = request.getParameterValues("lotto");
 			
 			if(numbers != null && numbers.length == 6) {
	 			
	 			buildView("<html><head></head><body><h1>Vous avez joué</h1><br>", response);
				
	 			buildView("<table><tr>", response);
	 			
	 			//code clarification @static
	 			loopUser(numbers, response);
	 			
	 			buildView("</tr></table>", response);
	 			
	 			String[][] lotto =  {
	 				{"1", "4", "27", "35", "39", "42"}, 
	 				{"5", "3", "15", "29", "33", "41"},
	 				{"8", "19", "33", "40", "42", "6"},
	 				{"14", "42", "13", "2", "23", "7"},
	 				{"5", "41", "36", "18", "12", "1"}
	 			};
	 			
	 			buildView("<h1>Les nombres gagnant étaient</h1><br>", response);
	 			
	 			buildView("<table><tr>", response);
	 			
	 			int i = (int)(3 * Math.random());
	 			
	 			//code clarification @static
	 			loopDisplay(lotto[i], response);
	 			
	 			buildView("</tr></table>", response);
	 			
	 			buildView("<h1>Comparaisons</h1><br>", response);
	 			
	 			buildView("<table><tr>", response);
	 			
	 			//code clarification @static
	 			int count = loopEquals(lotto[i], numbers, response);
	 			
	 			buildView("</tr></table>", response);
	 			
	 			buildView("<br>Total: " + count + " nombre" + (count > 1 ? "s" : "") + " gagnant</body></html>", response);
	 			
 			} else {
 				
 				buildView("<html><head></head><body>Nombre insuffisant ou trop de nombres sélectionnés, veuillez en choisir 6</body></html>", response);
 			}
 		}
		
		/**
		 * loopUser
		 * 
		 * display numbers from user
		 * 
		 * @param numbers
		 * @param response
		 * 
		 * @throws IOException
		 */
		private static void loopUser(String[] numbers, HttpServletResponse response) throws IOException {
			
			for(int i = 0; i < numbers.length; i++) {
					
				buildView("<td>" + numbers[i] + "</td>", response);
 			}
		}

		/**
		 * loopDisplay
		 * 
		 * display lotto numbers
		 * 
		 * @param lotto
		 * @param response
		 * 
		 * @throws IOException
		 */
		private static void loopDisplay(String[] lotto, HttpServletResponse response) throws IOException {
			
			for(int i = 0; i < lotto.length; i++) {
 				
				buildView("<td>" + lotto[i] + "</td>", response);
 			}
		}

		/**
		 * loopEquals
		 * 
		 * to verify user numbers vs lotto numbers
		 * 
		 * @param lotto
		 * @param numbers
		 * @param response
		 * 
		 * @return
		 * 
		 * @throws IOException
		 */
		private static int loopEquals(String[] lotto, String[] numbers, HttpServletResponse response) throws IOException {
			
			int count = 0;
			
			for(int i = 0; i < lotto.length; i++) {
 				
 				for(int k = 0; k < numbers.length; k++) {
 				
 					if(lotto[i].equalsIgnoreCase(numbers[k])) {
 						
 						count++;
 						buildView("<td>" + numbers[k] + "</td>", response);
 					}
 				}
 			}
			
			return count;
		}
		
		/**
		 * buildView
		 * 
		 * @param str
		 * @param response
		 * 
		 * @throws IOException
		 */
		private static void buildView(String str, HttpServletResponse response) throws IOException {
			
			int test = 0;
			
			if(test == 0) {
				test++;
				response.setContentType("text/html");
			}
			
			response.getWriter().print(str);
		}
 	}

