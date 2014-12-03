package be.wavenet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletHelper {

	public static void redirectErrors(HttpServletRequest request,
			HttpServletResponse response, Exception exception,
			String redirectUrl) throws IOException, ServletException {
		request.setAttribute("javax.servlet.jsp.jspException", exception);
		request.setAttribute("redirectUrl", redirectUrl); 
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	public static void redirectErrors(HttpServletRequest request,
			HttpServletResponse response, Exception exception)
			throws IOException, ServletException {
		redirectErrors(request, response, exception, null);
	}

}