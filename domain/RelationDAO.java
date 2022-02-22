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

	
}