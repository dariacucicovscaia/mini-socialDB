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
		
		
		    RelationDAO relationsList = new RelationDAO();
		    UserDAO userList = new UserDAO();
		    
		    
		    for (User userlist : userList.getAll()) {
				System.out.println(userlist.getNickname());
			}

		    for (Relation relationlist : relationsList.getAll()) {
				System.out.println(relationlist.getFrom_user_id());
			}
		   // System.out.println(relationsList.get(3).getStatus_id());
		  

	}

}
