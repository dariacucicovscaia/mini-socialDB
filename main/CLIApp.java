package main;

import java.sql.SQLException;
import java.util.List;

import domain.Relations;
import domain.RelationsDAO;
import domain.User;
import domain.UserDAO;

public class CLIApp {

	public static void main(String[] args) throws SQLException {
		UserDAO userList = new UserDAO();
		RelationsDAO relationsList = new RelationsDAO();

		for (Relations relationslist : relationsList.getAll()) {
			System.out.println(relationslist.getTo_user_id());
		}
		System.out.println();

		System.out.println(relationsList.get(3).getStatus_id());
		//relationsList.put(new Relations(3, 2, 1, 1));
		//relationsList.update(new Relations(3, 2, 1, 2));
		//relationsList.remove(1);

/////////////////////////////////////////////////////////////////////////////////
		for (User userlist : userList.getAll()) {
			System.out.println(userlist.getNickname() + " " + userlist.getEmail());
		}
		System.out.println();
		
		 System.out.println(userList.get(1).getNickname());
//		 userList.put(new User(2, "user2", "user2@example.com", "123"));
//		 userList.update(new User(2, "user2", "user2@example.com", "546"));
//		 userList.remove(2);

	}

}
