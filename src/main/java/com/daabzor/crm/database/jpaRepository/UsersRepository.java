package com.daabzor.crm.database.jpaRepository;


import java.util.List;

import com.daabzor.crm.database.model.Friends;
import com.daabzor.crm.database.model.Users;

public interface UsersRepository {

	//Return true if user exist in database, false otherwise
	boolean checkIfUserExists(String userName);

	//Return user found by user name
	Users getUserByUserName(String userName);
		
	//Add user to database
	void addUser(Users user);
	
	//Delete user from data base
	void deleteUser(Users user);
	
	//Return user found by user id
	Users getUserById(Long id);

	//Return list of users
	List<Users> getUsersList();
	
	//Update user with new data
	void updateUser(Users user);

	//Add user friend
	void addUserFriend(Long id, Friends friend);
	
}
