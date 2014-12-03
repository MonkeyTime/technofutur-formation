package be.wavenet.servlet;

import be.wavenet.services.UserManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class ServiceLocator {

    private ServiceLocator() {
        // hidden
    }

    public static UserManager getUserManager() throws NamingException {
        Context context = new InitialContext();
        return (UserManager) context.lookup("java:global/Welcome/WelcomeEJB/UserManager");
    }

}
