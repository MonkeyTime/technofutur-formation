package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Response;

@LocalBean
public interface IResponseRepository {

	List<Response> findAll();

	List<Response> findByContent(final String content);

	Response saveResponse(final Response response);

	void deleteResponse(final Response response);
}
