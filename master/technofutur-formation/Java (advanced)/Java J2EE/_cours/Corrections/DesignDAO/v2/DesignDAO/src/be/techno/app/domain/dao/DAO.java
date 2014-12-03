package be.techno.app.domain.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T,K> {
	public T create(T s) throws SQLException;
	public T read(K id) throws SQLException;
	public T update(T s) throws SQLException;
	public void delete(T s) throws SQLException;
	
	public List<T> findAll() throws SQLException;
	
}
