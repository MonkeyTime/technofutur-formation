package be.techno.servlet.repository;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import be.techno.servlet.repository.PersonneRowMapper;
import be.techno.servlet.Personne;
import be.techno.servlet.repository.PersonneRepository;

public class PersonneRepositoryJdbc extends JdbcDaoSupport implements PersonneRepository {

	List<Personne> list;
	
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
	public Personne getPersonneByName(String name) {
		String sql = "select * from personne where nom = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{name}, Personne.class);
	}
	
	@Override
	public Personne getPersonneById(int id) {
		String sql = "select * from personne where id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{id}, Personne.class);
	}

	@Override
	public List<Personne> findAll() {
		String sql = "select * from personne";
		
		return getJdbcTemplate().query(sql, new PersonneRowMapper());
	}
}
