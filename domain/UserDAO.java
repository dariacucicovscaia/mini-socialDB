package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAOAbstract<User> implements DAOInterface<User> {
	private List<User> users;

	public UserDAO() throws SQLException {
		
		super("users");
	}

	@Override
	public List<User> getAll() throws SQLException {
		users = new ArrayList<User>();
		String sql = "SELECT id, nickname, email, password FROM public.users;";
		Statement stmt = getConnection().createStatement();
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

		Statement stmt =  getConnection().createStatement();
		stmt.executeUpdate(insert);

	}

	@Override
	public User get(int id) throws SQLException {
		String sql = "SELECT id, nickname, email, password\r\n 	FROM public.users\r\n	WHERE id=" + id + ";";
		Statement stmt =  getConnection().createStatement();
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
		Statement stmt =  getConnection().createStatement();
		stmt.executeUpdate(sql);

	}

	@Override
	public void remove(int id) throws SQLException {
		String sql = "DELETE FROM public.users\r\n 	WHERE id= " + id + ";";
		Statement stmt =  getConnection().createStatement();
		stmt.executeUpdate(sql);

	}

}
