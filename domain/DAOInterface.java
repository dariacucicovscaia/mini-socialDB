package domain;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
	List<T> getAll() throws SQLException;
	void put(T entity) throws SQLException;
	T get(int id) throws SQLException;
	void update(T entity) throws SQLException;
	void remove( int id) throws SQLException;
	
}
