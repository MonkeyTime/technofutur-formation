package be.technofutur.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id
	private int Id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
