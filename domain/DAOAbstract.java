package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOAbstract<T> {
	private Connection connection;

	public DAOAbstract(String string) throws SQLException {
		String url = "jdbc:postgresql://localhost/mini-social?user=postgres&password=qazwsx";
		setConnection(DriverManager.getConnection(url));
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
