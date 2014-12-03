package be.wavenet.services;

import be.wavenet.domain.User;
import javax.ejb.Local;

@Local
public interface UserManager {

    User login(String login, String password) throws UserManagerException;

    User createUser(final User user) throws UserManagerException;
}
