package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Forum;

public class ForumRepository implements IForumRepository {

	private List<Forum> forums;
	
	public ForumRepository() {
		
		this.forums = new ArrayList<Forum>();
	}
	
	@Override
	public List<Forum> findAll() {

		return this.forums;
	}

	@Override
	public Forum findById(int id) {
		
		for(Forum forum : this.forums) {
			
			if(forum.getId() == id) {
				
				return forum;
			}
		}
		
		return null;
	}

	@Override
	public Forum save(Forum forum) {

		this.forums.add(forum);
		
		return forum;
	}

	@Override
	public void delete(Forum forum) {
		
		this.forums.remove(forum);
	}

	@Override
	public void delete(int id) {
		
		this.forums.remove(id);
		
	}

}
