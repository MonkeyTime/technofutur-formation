package be.technofutur.labo.ejbs;

import java.util.List;

import be.technofutur.labo.entities.Category;
import be.technofutur.labo.entities.Forum;

public interface IForumManager {
	
	Forum create(final Forum forum);

	List<Forum> findAll();

	Forum findById(int id);

	Forum save(final Forum cat);

	void delete(final Forum cat);
	
	void delete(int id);
}
