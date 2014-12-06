package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Role;

public class RoleRepository implements IRoleRepository {

	private List<Role> roles;
	
	public RoleRepository() {
		
		this.roles = new ArrayList<Role>();
	}
	
	@Override
	public List<Role> findAll() {

		return this.roles;
	}

	@Override
	public Role findById(int id) {
		
		for(Role role : this.roles) {
			
			if(role.getId() == id) {
				
				return role;
			}
		}
		
		return null;
	}

	@Override
	public Role save(Role role) {

		this.roles.add(role);
		
		return role;
	}

	@Override
	public void delete(Role role) {
		
		this.roles.remove(role);
	}

	@Override
	public void delete(int id) {
		
		this.roles.remove(id);
	}

}
