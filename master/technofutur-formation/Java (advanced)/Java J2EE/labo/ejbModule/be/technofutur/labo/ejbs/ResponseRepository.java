package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Response;

public class ResponseRepository implements IResponseRepository {

	private List<Response> responses;
	
	public ResponseRepository() {
		
		this.responses = new ArrayList<Response>();
	}
	
	@Override
	public List<Response> findAll() {

		return this.responses;
	}

	@Override
	public List<Response> findByContent(String content) {
		
		List<Response> resp = new ArrayList<Response>();
		
		for(Response response : this.responses) {
			
			if(response.getContent() == content) {
				
				resp.add(response);
			}
		}
		
		return resp;
	}

	@Override
	public Response saveResponse(Response response) {

		this.responses.add(response);
		
		return response;
	}

	@Override
	public void deleteResponse(Response response) {
		
		this.responses.remove(response);
	}

}
