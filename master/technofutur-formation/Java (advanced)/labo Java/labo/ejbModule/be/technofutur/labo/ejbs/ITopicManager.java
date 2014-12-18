package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.labo.entities.Topic;

@Local
public interface ITopicManager {
	
	Topic create(final Topic topic);

	List<Topic> findAll();

	Topic findById(final int id);

	Topic save(final Topic topic);

	void delete(final Topic topic);
	
	void delete(final int id);
}
