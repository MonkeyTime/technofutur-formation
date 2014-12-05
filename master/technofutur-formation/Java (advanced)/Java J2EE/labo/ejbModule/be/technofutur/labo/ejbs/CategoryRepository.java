package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Category;

public class CategoryRepository implements ICategoryRepository {

	private List<Category> categories;
	
	public CategoryRepository() {
		
		this.categories = new ArrayList<Category>();
	}
	
	@Override
	public List<Category> findAll() {

		return this.categories;
	}

	@Override
	public Category findById(int id) {
		
		for(Category category : this.categories) {
			
			if(category.getId() == id) {
				
				return category;
			}
		}
		
		return null;
	}

	@Override
	public Category save(Category category) {

		this.categories.add(category);
		
		return category;
	}

	@Override
	public void delete(Category category) {
		
		this.categories.remove(category);
	}
	
	@Override
	public void delete(int id) {
		
		this.categories.remove(id);
	}
}
