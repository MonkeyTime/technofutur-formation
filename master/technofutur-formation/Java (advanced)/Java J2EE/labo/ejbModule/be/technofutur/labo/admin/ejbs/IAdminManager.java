package be.technofutur.labo.admin.ejbs;

import java.util.List;

import be.technofutur.labo.entities.Admin;

public interface IAdminManager {
	
	Admin createAdmin(final Admin admin);

	List<Admin> findAll();
	
	Admin findByNickname(final String nickname);

	Admin saveAdmin(final Admin admin);

	void deleteAdmin(final Admin admin);
}
