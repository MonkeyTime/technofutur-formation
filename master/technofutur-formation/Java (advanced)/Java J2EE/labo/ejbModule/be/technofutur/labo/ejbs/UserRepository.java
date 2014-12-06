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
	public User findById(int id) {
		
		for(User user : this.users) {
			
			if(user.getId() == id) {
				
				return user;
			}
		}
		
		return null;
	}
	
	@Override
	public User findByUsername(String username) {
		
		for(User user : this.users) {
			
			if(user.getUsername() == username) {
				
				return user;
			}
		}
		
		return null;
	}

	@Override
	public User save(User user) {

		this.users.add(user);
		
		return user;
	}

	@Override
	public void delete(User user) {
		
		this.users.remove(user);
	}
	
	@Override
	public void delete(int id) {
		
		this.users.remove(id);
	}

}
