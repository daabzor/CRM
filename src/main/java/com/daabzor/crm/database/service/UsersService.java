package com.daabzor.crm.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daabzor.crm.database.jpaRepository.PersonalInformationRepository;
import com.daabzor.crm.database.jpaRepository.UsersRepository;
import com.daabzor.crm.database.model.Friends;
import com.daabzor.crm.database.model.PersonalInformation;
import com.daabzor.crm.database.model.Users;

@Service
public class UsersService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private PersonalInformationRepository personalInformationRepository;

	public boolean checkIfUserExists(Users user) {
		if (userRepository.checkIfUserExists(user.getUserName())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUserPassword(Users user) {
		Users userFromDataBase = userRepository.getUserByUserName(user.getUserName());
		if (userFromDataBase.getUserPassword().equals(user.getUserPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public Users getUser(Users user) {
		Users userFromDataBase = userRepository.getUserByUserName(user.getUserName());
		return userFromDataBase;
	}

	
	
	
	
	public void addUser(Users user) {
		userRepository.addUser(user);
	}

	public void addPersonalInformation(PersonalInformation personalinformation) {
		personalInformationRepository.addPersonalInformation(personalinformation);
	}

	
	public void update(Users user) {
		userRepository.updateUser(user);
	}

	public List<Friends> getAllUserFriends(Users user) {
		List<Friends> friend = userRepository.getUserById(user.getId()).getFriends();
		return friend;
	}

	public void addUserFriend(Users user, Friends friend) {
		userRepository.addUserFriend(user.getId(), friend);
	}
}
