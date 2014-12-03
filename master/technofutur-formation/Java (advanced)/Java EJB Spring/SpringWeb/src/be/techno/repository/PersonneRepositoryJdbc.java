package be.techno.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import be.techno.Personne;

@Repository("personneRepo")
public class PersonneRepositoryJdbc implements PersonneRepository{

	@Resource(name="template")
	private JdbcTemplate template;
	
	@Override
	public List<Personne> findAll() {
		String sql = "select * from personne";
		return template.query(sql, new PersonneRowMapper());
	}

	@Override
	public Personne findById(int id) {
		String sql = "select * from personne where id = ?";
		
		return template.queryForObject(sql, new Object[]{id}, new PersonneRowMapper());
	}

	@Override
	public List<Personne> findByNom(String nom) {
		String sql = "select * from personne where nom = ?";
		
		return template.query(sql, new Object[]{nom}, new PersonneRowMapper());
	}

	@Override
	public void createPersonne(Personne p) {
		String sql = "insert into personne (nom) values (?)";
		template.update(sql, p.getNom());		
	}

	@Override
	public void updatePersonne(Personne p) {
		String sql = "update personne set nom = ? where id = ?";
		template.update(sql, p.getNom(), p.getId());		
	}

	@Override
	public void deletePersonne(Personne p) {
		String sql = "delete from personne where id = ?";
		template.update(sql, p.getId());	
		
	}

	@Override
	public String getNomById(int id) {
		String sql = "select nom from personne where id = ?";
		
		return template.queryForObject(sql, new Object[]{id}, String.class );		
	}

}
