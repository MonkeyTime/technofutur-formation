package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Post;

@LocalBean
public interface IPostRepository {

	List<Post> findAll();

	Post findById(int id);

	Post save(final Post post);

	void delete(final Post post);
	
	void delete(int id);
}
