package be.wavenet.web.servlet;

import java.io.IOException;
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
@WebServlet(urlPatterns={"/LottoServlet"}, loadOnStartup=1)
public class LottoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MyLotto myLotto;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoServlet() {
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
		request.setAttribute("lotto", myLotto.toArray());
		
		if(request.getSession().getAttribute("numbers")==null) {
		
			try {
				Integer[] playerNumbers = getNumberParameters(request);
				Integer[] winningNumbers = myLotto.getWinningNumbers(playerNumbers);
				
				request.getSession().setAttribute("numbers", playerNumbers);
				request.getSession().setAttribute("winningNumbers", winningNumbers);
				request.getSession().setAttribute("winningCount", winningNumbers.length);
				
				request.getRequestDispatcher("LottoServlet").forward(request, response);
			} catch (InvalidNumbersException e) {
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("error.jspx").forward(request, response);
			}
		}
		else {
			//already played
			request.getRequestDispatcher("result.jspx").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

