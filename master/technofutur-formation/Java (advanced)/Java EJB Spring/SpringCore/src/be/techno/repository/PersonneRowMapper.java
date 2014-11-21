package be.techno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import be.techno.Personne;

public class PersonneRowMapper implements RowMapper<Personne> {

	@Override
	public Personne mapRow(ResultSet rs, int arg1) throws SQLException {
		Personne p = new Personne();
		p.setId(rs.getInt("id"));
		p.setNom(rs.getString("nom"));
		
		return p;
	}

	 

}
