package be.techno.app.domain.dao;

public interface DAO<T,K> {
	public T create(T s);
	public T read(K id);
	public T update(T s);
	public void delete(T s);
}
