package be.techno.repository;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import be.techno.Personne;

public class PersonneRepositoryJdbc extends JdbcDaoSupport implements PersonneRepository{

	@Override
	public List<Personne> findAll() {
		String sql = "select * from personne";
		return getJdbcTemplate().query(sql, new PersonneRowMapper());
	}

	@Override
	public Personne findById(int id) {
		String sql = "select * from personne where id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new PersonneRowMapper());
	}

	@Override
	public List<Personne> findByNom(String nom) {
		String sql = "select * from personne where nom = ?";
		
		return getJdbcTemplate().query(sql, new Object[]{nom}, new PersonneRowMapper());
	}

	@Override
	public void createPersonne(Personne p) {
		String sql = "insert into personne (nom) values (?)";
		getJdbcTemplate().update(sql, p.getNom());		
	}

	@Override
	public void updatePersonne(Personne p) {
		String sql = "update personne set nom = ? where id = ?";
		getJdbcTemplate().update(sql, p.getNom(), p.getId());		
	}

	@Override
	public void deletePersonne(Personne p) {
		String sql = "delete from personne where id = ?";
		getJdbcTemplate().update(sql, p.getId());	
		
	}

	@Override
	public String getNomById(int id) {
		String sql = "select nom from personne where id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{id}, String.class );		
	}

}
