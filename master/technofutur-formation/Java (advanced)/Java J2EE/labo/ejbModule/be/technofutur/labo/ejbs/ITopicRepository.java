package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Topic;

@LocalBean
public interface ITopicRepository {

	List<Topic> findAll();

	Topic findById(final int id);

	Topic save(final Topic topic);

	void delete(final Topic topic);
	
	void delete(final int id);
}
