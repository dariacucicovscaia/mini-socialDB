package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserDAO {
	private List<User> users;
	private ResultSet result;
	private User u = new User();


	public UserDAO(String URL, String SQL) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		Statement stmt = conn.createStatement();
		result = stmt.executeQuery(SQL);

	}

	public List<User> getUsers() throws SQLException {
		users = new ArrayList<User>();

		while (result.next()) {
			u.setId(result.getInt("id"));
			u.setNickname(result.getString("nickname"));
			u.setEmail(result.getString("email"));
			u.setPassword(result.getString("password"));

			users.add(new User(u.getId(), u.getNickname(), u.getEmail(), u.getPassword()));
		}

		return users;

	}

}
