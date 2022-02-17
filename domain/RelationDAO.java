package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoIdFieldException;

public class RelationDAO extends DAOAbstract<Relation> { 

	public RelationDAO() throws SQLException, NoIdFieldException {
		super();
	}

	@Override
	public List<Relation> getAll() throws SQLException {
		List<Relation> relations = new ArrayList<Relation>();
		String sql = "SELECT from_user_id, to_user_id, type_id, status_id\r\n" + "	FROM public.relations ;";
		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		while (result.next()) {

			relations.add(new Relation(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
		}
		return relations;
	}

	@Override
	public void put(Relation entity) throws SQLException {
		String sql = "INSERT INTO public.relations (\r\n" + "	from_user_id, to_user_id, type_id, status_id)\r\n"
				+ "	VALUES (" + entity.getFrom_user_id() + "," + entity.getTo_user_id() + ", " + entity.getType_id()
				+ "," + entity.getStatus_id() + ");";

		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);
	}

	@Override
	public Relation get(int id) throws SQLException {
		// id == from_user_id
		String sql = "SELECT from_user_id, to_user_id, type_id, status_id\r\n" + "	FROM public.relations \r\n WHERE from_user_id=" + id + ";";

		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		Relation relations = null;
		if (result.next()) {
			relations = new Relation(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4));
		}

		return relations;
	}

//	@Override
//	public void update(Relation entity) throws SQLException {
//		String sql = "UPDATE public.relations \r\n" + "	SET type_id=" + entity.getType_id() + ", status_id="
//				+ entity.getStatus_id() + "\r\n" + "	WHERE from_user_id=" + entity.getFrom_user_id()
//				+ " AND to_user_id=" + entity.getTo_user_id() + " ;";
//
//		Statement stmt = getConnection().createStatement();
//		stmt.executeUpdate(sql);
//
//	}
//
//	@Override
//	public void remove(int id) throws SQLException {
//		super.remove( id );
//	}
	
}