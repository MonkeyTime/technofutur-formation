package be.wavenet.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.wavenet.domain.User;
import be.wavenet.repository.RepositoryException;
import be.wavenet.repository.UserRepository;
import be.wavenet.services.UserManager;
import be.wavenet.services.UserManagerException;

@Stateless(name="UserManager")
public class UserManagerBean implements UserManager {
	
	@EJB(beanName = "UserRepositoryJdbc")
    private UserRepository userRepository;
	
    public User login(String login, String password) throws UserManagerException {
        if (login == null || login.trim().length() == 0) {
            throw new UserManagerException("Invalid login");
        }

        if (password == null || password.trim().length() == 0) {
            throw new UserManagerException("Invalid password");
        }

        try {
	        User user = userRepository.findUser(login);
	        if (user == null) {
	        	userRepository.addUser(new User(login, password));
	        }
	        if (user != null && password.equals(user.getPassword())) {
	            return user;
	        } 
        } catch (RepositoryException e) {
        	throw new UserManagerException(e);
        }

        return null;
    }
    
	public User createUser(final User user) throws UserManagerException {
		if (user == null)
			throw new UserManagerException("User cannot be null");

		try {
			if (!userRepository.addUser(user))
				throw new UserManagerException("User already registered");
		} catch (RepositoryException e) {
			throw new UserManagerException(e);
		}
		
		return user;
	}
}
