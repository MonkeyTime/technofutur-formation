package be.techno.web.interpreter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHelper {

	private ServletHelper() {

	}

	public static void errorForwarding(HttpServletRequest req,
			HttpServletResponse res, Exception exception, String redirectUrl)
			throws ServletException, IOException {
		req.setAttribute("exception", exception);
		req.setAttribute("redirectURL", redirectUrl);
		req.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(req, res);
	}
}
