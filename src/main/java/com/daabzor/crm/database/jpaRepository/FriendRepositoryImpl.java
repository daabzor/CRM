package com.daabzor.crm.database.jpaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daabzor.crm.database.model.Friends;

@Repository
public class FriendRepositoryImpl implements FriendsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addFriend(Friends friend) {
		entityManager.persist(friend);
	}

	@Override
	@Transactional
	public void deleteFriend(Long id) {
		Friends friend = entityManager.find(Friends.class, id);
		entityManager.remove(friend);
	}

	@Override
	@Transactional
	public void updateFriend(Friends friend) {
		entityManager.merge(friend);
	}

	@Override
	@Transactional
	public Friends getFriend(Friends friend) {
		return entityManager.find(Friends.class, friend.getFriendId());
	}

	@Override
	@Transactional
	public Friends getFriendById(Long id) {
		return entityManager.find(Friends.class, id);
	}

	@Override
	@Transactional
	public void deleteFriendById(Long id) {
		Friends friend = entityManager.find(Friends.class, id);

		if (friend != null) {
			entityManager.remove(friend);
		}
	}

	@Override
	public List<Friends> getAllUserFriendsByUserId(Long id) {
		String jpql = "select e from Friends e where user_id = '" + id + "'";
		TypedQuery<Friends> query = entityManager.createQuery(jpql, Friends.class);
		List<Friends> friendList = query.getResultList();
		return friendList;
	}

}
