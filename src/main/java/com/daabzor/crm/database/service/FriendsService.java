package com.daabzor.crm.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daabzor.crm.database.jpaRepository.FriendsRepository;
import com.daabzor.crm.database.model.Friends;

@Service
public class FriendsService {

	@Autowired
	FriendsRepository friendsRepository;
	
	public void addFriend(Friends friend) {
		friendsRepository.addFriend(friend);
	}
	
	public Friends getFriend(Long id){
		return friendsRepository.getFriendById(id);
	}
	
	public void deleteFriendById(Long id) {
		friendsRepository.deleteFriendById(id);
	}
	
	public List<Friends> getAllUserFriendsByUserId(Long id) {
		return friendsRepository.getAllUserFriendsByUserId(id);
	}
	
	public void updateFriend(Friends friend) {
		friendsRepository.updateFriend(friend);
	}
}
