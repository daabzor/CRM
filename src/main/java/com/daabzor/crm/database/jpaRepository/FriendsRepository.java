package com.daabzor.crm.database.jpaRepository;

import java.util.List;

import com.daabzor.crm.database.model.Friends;

public interface FriendsRepository {

	void addFriend(Friends friend);
	
	void deleteFriend(Long id);
	
	void updateFriend(Friends friend);
	
	Friends getFriend(Friends friend);
	
	Friends getFriendById(Long id);
	
	void deleteFriendById(Long id);
	
	List<Friends> getAllUserFriendsByUserId(Long id);
	
}
