package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.User;

@Local
public interface IUserManager {
	
	User create(final User usr);

	List<User> findAll();

	User findById(final int id);
	
	User findByUsername(final String username);

	User save(final User usr);

	void delete(final User usr);
	
	void delete(final int id);
}
