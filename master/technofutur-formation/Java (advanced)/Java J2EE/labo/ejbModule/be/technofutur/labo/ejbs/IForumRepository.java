package be.technofutur.labo.ejbs;

import java.util.List;
import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Forum;

@LocalBean
public interface IForumRepository {

	List<Forum> findAll();

	Forum findById(int id);

	Forum save(final Forum cat);

	void delete(final Forum cat);
	
	void delete(int id);
}
