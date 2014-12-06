package be.technofutur.labo.ejbs;

import java.util.List;

import be.technofutur.labo.entities.Forum;

public interface IForumManager {
	
	Forum create(final Forum forum);

	List<Forum> findAll();

	Forum findById(int id);

	Forum save(final Forum forum);

	void delete(final Forum forum);
	
	void delete(int id);
}
