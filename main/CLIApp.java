package main;

import java.sql.SQLException;
import java.util.List;

import domain.Relation;
import domain.RelationDAO;
import domain.User;
import domain.UserDAO;
import exception.NoIdFieldException;

public class CLIApp {

	public static void main(String[] args) throws SQLException, NoIdFieldException {
		
		
		    new RelationDAO();
		    UserDAO userList = new UserDAO();
			//userList.remove(4);
		    	//userList.put(new User(7, "user7", "user7@example.com", "123"));
		    userList.update(new User(7, "user7", "user7@example.com", "1457"));
		
		
		
		
		
//		UserDAO userList = new UserDAO();
//		RelationDAO relationsList = new RelationDAO();
//
//		for (Relations relationlist : relationsList.getAll()) {
//			System.out.println(relationslist.getFrom_user_id());
//		}
//		System.out.println();
//
//		System.out.println(relationsList.get(3).getStatus_id());
	
	//	relationsList.update(new Relations(1, 2, 2, 2));
//			relationsList.remove(1);

/////////////////////////////////////////////////////////////////////////////////
//		for (User userlist : userList.getAll()) {
//			System.out.println(userlist.getNickname() + " " + userlist.getEmail());
//		}
//		System.out.println();
//		
//		 System.out.println(userList.get(1).getNickname());
//		 userList.put(new User(7, "user7", "user7@example.com", "123"));
//		 userList.update(new User(2, "user2", "user2@example.com", "546"));
//		 userList.remove(2);

	}

}
