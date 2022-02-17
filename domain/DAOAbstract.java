package domain;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoIdFieldException;

public abstract class DAOAbstract<T> implements DAOInterface<T> {
	private Connection connection;
	private Class entityClazz;
	private String from_user_id;
	private String url = "jdbc:postgresql://localhost/mini-social?user=postgres&password=qazwsx";

	public Connection getConnection() {
		return connection;
	}

	public String getTableName() {
		return entityClazz.getName().replace("domain.", "").toLowerCase() + "s";
	}

	public DAOAbstract() throws SQLException, NoIdFieldException {
		// 1. determine T
		ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClazz = (Class) t.getActualTypeArguments()[0];

		// HW:
		if (entityClazz.getDeclaredFields()[0].isAnnotationPresent(Id.class)) {
			from_user_id = entityClazz.getDeclaredFields()[0].getName();
		} else {
			throw new NoIdFieldException();
		}

		// 2. Initiate connection
		connection = DriverManager.getConnection(url);
	}

	@Override
	public List<T> getAll() throws SQLException {
		List<T> t = new ArrayList<T>();
//		String sql = "SELECT id, nickname, email, password FROM public." + string + ";";
//		Statement stmt = getConnection().createStatement();
//		ResultSet result = stmt.executeQuery(sql);
//		while (result.next()) {
//
//			t.add(new User(result.getInt("id"), result.getString("nickname"), result.getString("email"),
//					result.getString("password")));
//		}
		return t;
	}

	@Override
	public void put(T entity) throws SQLException {
		Field fields[] = entityClazz.getDeclaredFields();
		String columns = "(";
		for (Field field : fields) {
			columns += field.getName() + ",";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += ")";

		String values = "VALUES (";
		for (Field field : fields) {

			try {
				Object value = field.get(entity);
				if (field.getType().getName().equals("int")) {
					values += value + ",";
				} else if (field.getType().getName().equals("java.lang.String")) {
					values += "'" + value + "',";
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		values = values.substring(0, values.length() - 1);
		values += ") ";
//					 which should insert the NEW! user's data into the DB
		String insert = "INSERT INTO public." + getTableName() + "\r\n" + columns + "\r\n" + values;

		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(insert);

	}

	public T get(int id, String from_user_id) throws SQLException {
		List<T> t = new ArrayList<T>();
//		String sql = "SELECT *\r\n 	FROM public." + string + "\r\n	WHERE " + from_user_id + "=" + id + ";";
//		Statement stmt = getConnection().createStatement();
//		ResultSet result = stmt.executeQuery(sql);
//		
//		if (result.next()) {
//			user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
//		}
//
		return (T) t;
	}

	@Override
	public void update(T entity) throws SQLException {
		Field fields[] = entityClazz.getDeclaredFields();
		
		String set = "SET ";
		for (Field field : fields) {

			try {
				Object value = field.get(entity);
				if (field.getType().getName().equals("int")) {
					set +=field.getName() + "="+ value + ",";
				} else if (field.getType().getName().equals("java.lang.String")) {
					set += field.getName() + "="+"'" + value + "',";
				}
				
			
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	set = set.substring(0, set.length() - 1);
		
		set = set.replaceAll(from_user_id, "");
		
		 StringBuffer originalString =new StringBuffer(set);
		 originalString.replace(4, 7, " ");
		try {
			
			Object id = fields[0].get(entity);
			String sql = "UPDATE public." + getTableName() + "\r\n" +originalString+ "\r\n" + "	WHERE " + from_user_id + "=" + id + " ;";
		    Statement stmt = getConnection().createStatement();
	      	stmt.executeUpdate(sql);
	      
	      	
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(int id) throws SQLException {
		String sql = "DELETE FROM public." + getTableName() + " \r\n 	WHERE " + from_user_id + "=" + id + " ;";

		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);
	}

}
