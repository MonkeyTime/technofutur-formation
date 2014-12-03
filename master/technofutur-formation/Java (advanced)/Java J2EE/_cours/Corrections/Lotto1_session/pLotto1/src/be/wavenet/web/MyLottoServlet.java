package be.wavenet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.wavenet.lotto.InvalidNumbersException;
import be.wavenet.lotto.MyLotto;

/**
 * Servlet implementation class MyLottoServlet
 */
@WebServlet(urlPatterns={"/myResult"}, loadOnStartup=1)
public class MyLottoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MyLotto myLotto;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLottoServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	myLotto = new MyLotto();
    	myLotto.draw();
    	System.out.println(myLotto.toString());
    	log(myLotto.toString());
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("numbers")==null) {
		
			try {
				Integer[] playerNumbers = getNumberParameters(request);
				Integer[] winningNumbers = myLotto.getWinningNumbers(playerNumbers);
				
				printHeader(out);
				out.print("<h1>Lotto numbers :</h1>");
				printTable(out, myLotto.toArray());
				out.print("<h1>Player numbers :</h1>");
				printTable(out, playerNumbers);
				out.print("<h1>Player's winning numbers (" + winningNumbers.length + "):</h1>");
				printTable(out, winningNumbers);
				printFooter(out);
				
				request.getSession().setAttribute("numbers", playerNumbers);
			} catch (InvalidNumbersException e) {
				out.print(e.getMessage());
			}
		}
		else {
			//already played
			Integer[] playerNumbers = (Integer[]) request.getSession().getAttribute("numbers");
			Integer[] winningNumbers = myLotto.getWinningNumbers(playerNumbers);
			printHeader(out);
			out.print("<h1>You already played Lotto :</h1>");
			out.print("<h1>Lotto numbers :</h1>");
			printTable(out, myLotto.toArray());
			out.print("<h1>Player numbers :</h1>");
			printTable(out, playerNumbers);
			out.print("<h1>Player's winning numbers (" + winningNumbers.length + "):</h1>");
			printTable(out, winningNumbers);
			printFooter(out);
		}
	}
	
	private Integer[] getNumberParameters(HttpServletRequest request) throws InvalidNumbersException {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int i=1 ; i<=42 ; i++) {
			String n = request.getParameter("n"+i);
			if(n!=null)
				liste.add(i);
			if(liste.size()==6)
				break;
		}
		if(liste.size() != 6)
			throw new InvalidNumbersException("Illegal game : you didn't provide enough number to participate");
		
		Integer[] out = new Integer[liste.size()];
		return (Integer[]) liste.toArray(out);
	}
	
	private void printHeader(PrintWriter out) {
		out.print("<html><body>");
	}
	
	private void printFooter(PrintWriter out) {
		out.print("</body></html>");
	}
	
	private void printTable(PrintWriter out, Integer[] numbers) {
		out.println("<table border=\"1\">");
		out.println(" <tr>");
		for (int i = 0; i < numbers.length; i++)
			out.println("  <td>" + numbers[i] + "</td>");
		out.println(" </tr>");
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
