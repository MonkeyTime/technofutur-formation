package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Topic;

public class TopicRepository implements ITopicRepository {

	private List<Topic> topics;
	
	public TopicRepository() {
		
		this.topics = new ArrayList<Topic>();
	}
	
	@Override
	public List<Topic> findAll() {

		return this.topics;
	}

	@Override
	public Topic findById(int id) {
		
		for(Topic topic : this.topics) {
			
			if(topic.getId() == id) {
				
				return topic;
			}
		}
		
		return null;
	}
	
	@Override
	public List<Topic> findByForumId(int id) {

		List<Topic> list = new ArrayList<Topic>();
		
		for(Topic topic : this.topics) {
			
			if(topic.getForumId() == id) {
				
				list.add(topic);
			}
		}
		
		return list;
	}

	@Override
	public Topic save(Topic topic) {

		this.topics.add(topic);
		
		return topic;
	}
	
	@Override
	public void delete(Topic topic) {
		
		this.topics.remove(topic);
	}

	@Override
	public void delete(int id) {
		
		this.topics.remove(id);
	}
}
