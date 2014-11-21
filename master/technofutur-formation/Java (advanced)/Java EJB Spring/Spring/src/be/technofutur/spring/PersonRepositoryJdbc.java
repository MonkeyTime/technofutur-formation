package be.technofutur.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonRepositoryJdbc extends JdbcDaoSupport implements IPersonRepository {
	
	@Override
	public List<Person> findAll() {
		
		String sql = "SELECT * FROM personne";
		
		List<Person> results = getJdbcTemplate().query(sql, new PersonRepositoryJdbc.PersonRowMaper());
		
		return results;
	}

	@Override
	public Person findById(int id) {

		String sql = "SELECT * FROM personne WHERE id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{id}, Person.class);
	}

	@Override
	public List<Person> findByName(String name) {
		
		String sql = "SELECT * FROM personne WHERE nom = ?";
		
		List<Person> results = getJdbcTemplate().query(sql, new Object[]{name}, new PersonRepositoryJdbc.PersonRowMaper());
		
		return results;
	}

	@Override
	public void createPerson(Person p) {
		
		String sql = "INSERT INTO personne (nom) VALUES (?)";
		
		try {
			
			getJdbcTemplate().update(sql, new Object[]{p.getNom()});
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updatePerson(Person p) {

		String sql = "UPDATE personne SET nom = ? WHERE id = ?";
		
		try {
			
			getJdbcTemplate().update(sql, new Object[]{p.getNom(), p.getId()});
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deletePerson(Person p) {
		
		String sql = "DELETE FROM personne WHERE id = ?";
		
		try {
			
			getJdbcTemplate().update(sql, new Object[]{p.getId()});
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String getNameById(int id) {
		
		String sql = "SELECT nom FROM personne WHERE id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{id}, String.class);
	}
	
	/**
	 * PersonRowMaper
	 * 
	 * @author forma1311
	 *
	 */
	public class PersonRowMaper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Person user = new Person();
			
			user.setId(rs.getString("id"));
			user.setNom(rs.getString("nom"));
			
			return user;
		}
		
	}

}
