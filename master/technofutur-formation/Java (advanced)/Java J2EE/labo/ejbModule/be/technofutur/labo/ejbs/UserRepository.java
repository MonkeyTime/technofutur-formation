package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.User;

public class UserRepository implements IUserRepository {

	private List<User> users;
	
	public UserRepository() {
		
		this.users = new ArrayList<User>();
	}
	
	@Override
	public List<User> findAll() {

		return this.users;
	}

	@Override
	public User findByNickname(String name) {
		
		for(User user : this.users) {
			
			if(user.getNickname() == name) {
				
				return user;
			}
		}
		
		return null;
	}

	@Override
	public User saveUser(User user) {

		this.users.add(user);
		
		return user;
	}

	@Override
	public void deleteUser(User user) {
		
		this.users.remove(user);
	}

}
