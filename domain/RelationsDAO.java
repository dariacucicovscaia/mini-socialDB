package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RelationsDAO extends DAOAbstract<Relations> implements DAOInterface<Relations>{
	private List<Relations> relations;
	

	public RelationsDAO() throws SQLException {
		super("relations");
	}

	@Override
	public List<Relations> getAll() throws SQLException {
		relations = new ArrayList<Relations>();
		String sql = "SELECT from_user_id, to_user_id, type_id, status_id\r\n" + "	FROM public.relations;";
		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		while (result.next()) {

			relations.add(new Relations(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
		}
		return relations;
	}

	@Override
	public void put(Relations entity) throws SQLException {
		String sql = "INSERT INTO public.relations(\r\n" + "	from_user_id, to_user_id, type_id, status_id)\r\n"
				+ "	VALUES (" + entity.getFrom_user_id() + "," + entity.getTo_user_id() + ", " + entity.getType_id()
				+ "," + entity.getStatus_id() + ");";

		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);
	}

	@Override
	public Relations get(int id) throws SQLException {
		//id == from_user_id 
		String sql = "SELECT from_user_id, to_user_id, type_id, status_id\r\n"
				+ "	FROM public.relations\r\n WHERE from_user_id=" + id + ";";

		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		Relations relations = null;
		if (result.next()) {
			relations = new Relations(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4));
		}

		return relations;
	}

	@Override
	public void update(Relations entity) throws SQLException {
		String sql = "UPDATE public.relations\r\n" + "	SET type_id=" + entity.getType_id() + ", status_id="
				+ entity.getStatus_id() + "\r\n" + "	WHERE from_user_id=" + entity.getFrom_user_id()
				+ " AND to_user_id=" + entity.getTo_user_id() + " ;";
		
		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);

	}

	@Override
	public void remove(int id) throws SQLException {
		String sql = "DELETE FROM public.relations\r\n 	WHERE from_user_id=" + id + " ;";
		
		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);
	}

}
