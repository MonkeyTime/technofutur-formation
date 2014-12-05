package be.technofutur.labo.admin.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Admin;

public class AdminRepository implements IAdminRepository {

	private List<Admin> admins;
	
	public AdminRepository() {
		
		this.admins = new ArrayList<Admin>();
	}
	
	@Override
	public List<Admin> findAll() {

		return this.admins;
	}

	@Override
	public Admin findByNickame(String nickname) {
		
		for(Admin admin : this.admins) {
			
			if(admin.getNickname() == nickname) {
				
				return admin;
			}
		}
		
		return null;
	}

	@Override
	public Admin saveAdmin(Admin admin) {

		this.admins.add(admin);
		
		return admin;
	}

	@Override
	public void deleteAdmin(Admin admin) {
		
		this.admins.remove(admin);
	}

}
