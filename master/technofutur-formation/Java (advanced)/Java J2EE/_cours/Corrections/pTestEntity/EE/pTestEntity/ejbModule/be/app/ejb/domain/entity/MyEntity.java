package be.app.ejb.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id
	private int id;
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	
	
}
