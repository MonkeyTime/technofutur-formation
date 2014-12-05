package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Post;

public class PostRepository implements IPostRepository {

	private List<Post> posts;
	
	public PostRepository() {
		
		this.posts = new ArrayList<Post>();
	}
	
	@Override
	public List<Post> findAll() {

		return this.posts;
	}

	@Override
	public Post findById(int id) {
		
		for(Post post : this.posts) {
			
			if(post.getId() == id) {
				
				return post;
			}
		}
		
		return null;
	}

	@Override
	public Post save(Post post) {

		this.posts.add(post);
		
		return post;
	}

	@Override
	public void delete(Post post) {
		
		this.posts.remove(post);
	}

	@Override
	public void delete(int id) {
		
		this.posts.remove(id);
	}

}
