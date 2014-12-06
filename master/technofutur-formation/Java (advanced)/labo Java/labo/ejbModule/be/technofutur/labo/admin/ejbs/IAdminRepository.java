package be.technofutur.labo.admin.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Admin;

@LocalBean
public interface IAdminRepository {

	List<Admin> findAll();

	Admin findByNickame(final String nickname);

	Admin saveAdmin(final Admin admin);

	void deleteAdmin(final Admin admin);
}
