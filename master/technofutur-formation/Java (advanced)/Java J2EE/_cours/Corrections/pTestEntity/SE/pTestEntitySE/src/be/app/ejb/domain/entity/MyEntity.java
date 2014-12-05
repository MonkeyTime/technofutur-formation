package be.app.ejb.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id                                                           /* obligatoire pour l'id */
	@GeneratedValue(strategy=GenerationType.AUTO)                 /* Auto generation d'id */
	@Column(name="entity_id", nullable=false, unique=true)        /* @Column necessaire Si la variable != nom table en db */ 
	private int id;
	@Column(name="value", nullable=false)
	private String value;
	                                                               /* elle doit avoir un constructeur par défaut. */
	
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	public String getValue() { return value; }                        // vu le constructeur par defaut, il faut getter/setter 
	public void setValue(String value) { this.value = value; }
	
	@Override
	public String toString() {
		return id + " " + value;
	}
	
}

