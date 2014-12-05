package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.User;

@LocalBean
public interface IUserRepository {

	List<User> findAll();

	User findByNickname(final String nickname);

	User saveUser(final User user);

	void deleteUser(final User user);
}
