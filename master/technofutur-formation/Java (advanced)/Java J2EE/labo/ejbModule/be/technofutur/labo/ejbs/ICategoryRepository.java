package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Category;

@LocalBean
public interface ICategoryRepository {
	
	List<Category> findAll();

	Category findById(int id);

	Category save(final Category cat);

	void delete(final Category cat);
	
	void delete(int id);
}
