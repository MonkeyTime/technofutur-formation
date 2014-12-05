package be.technofutur.labo.ejbs;

import java.util.List;
import be.technofutur.labo.entities.User;

public interface IUserManager {
	
	User createUser(final User user);

	List<User> findAll();

	User findByNickname(final String nickname);

	User saveUser(final User user);

	void deleteUser(final User user);
}
