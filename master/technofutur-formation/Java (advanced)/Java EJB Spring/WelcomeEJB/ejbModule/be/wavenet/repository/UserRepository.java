package be.wavenet.repository;

import java.util.List;

import be.wavenet.domain.User;
import javax.ejb.Local;

@Local
public interface UserRepository {

    public boolean addUser(User u) throws RepositoryException;

    public boolean deleteUser(User u) throws RepositoryException;

    public User findUser(String login) throws RepositoryException;

    public User findUser(int id) throws RepositoryException;

    public boolean updateUser(User u) throws RepositoryException;

    public List<User> findUsers() throws RepositoryException;
}
