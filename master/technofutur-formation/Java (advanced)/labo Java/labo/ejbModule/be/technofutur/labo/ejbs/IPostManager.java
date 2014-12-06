package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.Post;

@Local
public interface IPostManager {
	
	Post create(final Post post);

	List<Post> findAll();

	Post findById(int id);

	Post save(final Post post);

	void delete(final Post post);
	
	void delete(int id);
}
