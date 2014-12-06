package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.Forum;

@Local
public interface IForumRepository {

	List<Forum> findAll();

	Forum findById(int id);

	Forum save(final Forum forum);

	void delete(final Forum forum);
	
	void delete(int id);
}
