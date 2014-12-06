package be.technofutur.labo.ejbs;

import java.util.List;
import be.technofutur.labo.entities.Post;

public interface IPostManager {
	
	Post create(final Post post);

	List<Post> findAll();

	Post findById(int id);

	Post save(final Post post);

	void delete(final Post post);
	
	void delete(int id);
}
