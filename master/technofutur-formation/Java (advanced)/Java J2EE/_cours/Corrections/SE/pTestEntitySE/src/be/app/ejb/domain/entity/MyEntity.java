package be.app.ejb.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="entity_id", nullable=false, unique=true)
	private int id;
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	
	@Column(name="value", nullable=false)
	private String value;
	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }
	
	@Override
	public String toString() {
		return id + " " + value;
	}
	
}

