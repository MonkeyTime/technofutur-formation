package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.User;

@LocalBean
public interface IUserRepository {

	List<User> findAll();

	User findById(final int id);
	
	User findByUsername(final String username);

	User save(final User usr);

	void delete(final User usr);
	
	void delete(final int id);
}
