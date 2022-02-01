package main;

import java.sql.SQLException;
import domain.User;
import domain.UserDAO;

public class CLIApp {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost/mini-social?user=postgres&password=069131467dasa";
		String sql = "SELECT id, nickname, email, password FROM public.users;";
		UserDAO userList = new UserDAO(url, sql);
		for (User userlist : userList.getUsers()) {
			System.out.println(userlist.getNickname() + " " + userlist.getEmail());
		}

	}

}
