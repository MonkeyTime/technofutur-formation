package be.technofutur.labo.ejbs;

import java.util.List;

import be.technofutur.labo.entities.Response;

public interface IResponseManager {
	
	Response createResponse(final Response response);

	List<Response> findAll();

	List<Response> findByContent(final String content);

	Response saveResponse(final Response response);

	void deleteResponse(final Response response);
}
