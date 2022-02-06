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

public class UserDAO implements DAOInterface<User> {
	private List<User> users;
	private Connection connection;

	public UserDAO() throws SQLException {
		String url = "jdbc:postgresql://localhost/mini-social?user=postgres&password=069131467dasa";
		connection = DriverManager.getConnection(url);

	}

	@Override
	public List<User> getAll() throws SQLException {
		users = new ArrayList<User>();
		String sql = "SELECT id, nickname, email, password FROM public.users;";
		Statement stmt = connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		while (result.next()) {

			users.add(new User(result.getInt("id"), result.getString("nickname"), result.getString("email"),
					result.getString("password")));
		}
		return users;
	}

	@Override
	public void put(User entity) throws SQLException {
		// which should insert the NEW! user's data into the DB
		String insert = "INSERT INTO public.users(\r\n" + "	id, nickname, email, password)\r\n" + "	VALUES ("
				+ entity.getId() + ", '" + entity.getNickname() + "', '" + entity.getEmail() + "', '"
				+ entity.getPassword() + "');";

		Statement stmt = connection.createStatement();
		stmt.executeUpdate(insert);

	}

	@Override
	public User get(int id) throws SQLException {
		String sql = "SELECT id, nickname, email, password\r\n 	FROM public.users\r\n	WHERE id=" + id + ";";
		Statement stmt = connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		User user = null;
		if (result.next()) {
			user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
		}

		return user;
	}

	@Override
	public void update(User entity) throws SQLException {
		String sql = "UPDATE public.users\r\n" + "	SET nickname='" + entity.getNickname() + "', email='"
				+ entity.getEmail() + "', password='" + entity.getPassword() + "'\r\n" + "	WHERE id = "
				+ entity.getId() + ";";
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql);

	}

	@Override
	public void remove(int id) throws SQLException {
		String sql = "DELETE FROM public.users\r\n 	WHERE id= " + id + ";";
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql);

	}

}
