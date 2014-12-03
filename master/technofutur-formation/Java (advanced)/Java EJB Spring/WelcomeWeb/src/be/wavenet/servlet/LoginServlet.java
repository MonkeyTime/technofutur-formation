package be.wavenet.servlet;

import be.wavenet.domain.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.wavenet.services.UserManager;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
		
        try {	
            UserManager userManager = ServiceLocator.getUserManager();
            User user = userManager.login(login, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                request.getRequestDispatcher("/welcome.do").forward(request, response);
            } else {
                request.setAttribute("errors", "Invalid login or password");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errors", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
