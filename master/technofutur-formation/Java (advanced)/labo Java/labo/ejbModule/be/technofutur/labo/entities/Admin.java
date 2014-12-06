package be.technofutur.labo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="nickname", nullable = false, length = 55)
    private String nickname;
	
	@Column(name="password", nullable = false, length = 196)
    private String password;

	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}

	public String getNickname() {
		
		return this.nickname;
	}

	public void setNickname(String nickname) {
		
		this.nickname = nickname;
	}

	public String getPassword() {
		
		return this.password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

}
