package domain;

import java.sql.SQLException;
import java.util.List;

import exception.NoIdFieldException;

public class UserDAO extends DAOAbstract<User> {
	private List<User> users;

	public UserDAO() throws SQLException, NoIdFieldException {
		super();
	}

	




}