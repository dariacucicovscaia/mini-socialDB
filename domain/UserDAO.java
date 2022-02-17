package domain;

import java.sql.SQLException;
import java.util.List;

import exception.NoIdFieldException;

public class UserDAO extends DAOAbstract<User> {
	private List<User> users;

	public UserDAO() throws SQLException, NoIdFieldException {
		super();
	}

	@Override
	public List<User> getAll() throws SQLException {
		return users;

	}

	@Override
	public User get(int id) throws SQLException {
		return null;

	}



}