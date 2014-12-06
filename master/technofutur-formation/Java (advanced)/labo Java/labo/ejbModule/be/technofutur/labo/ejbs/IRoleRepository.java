package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.Role;

@Local
public interface IRoleRepository {

	List<Role> findAll();

	Role findById(final int id);

	Role save(final Role role);

	void delete(final Role role);
	
	void delete(final int id);
	
}
