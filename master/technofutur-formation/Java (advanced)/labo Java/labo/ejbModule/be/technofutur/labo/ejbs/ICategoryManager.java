package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.Category;

@Local
public interface ICategoryManager {
	
	Category create(final Category cat);

	List<Category> findAll();

	Category findById(int id);

	Category save(final Category cat);

	void delete(final Category cat);
	
	void delete(int id);
}
