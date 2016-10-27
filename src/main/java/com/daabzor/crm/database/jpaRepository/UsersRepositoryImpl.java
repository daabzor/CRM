package com.daabzor.crm.database.jpaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daabzor.crm.database.model.Friends;
import com.daabzor.crm.database.model.Users;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean checkIfUserExists(String userName) {
		String jpql = "select count(e) from Users e where e.userName = '" + userName + "'";
		Query query = entityManager.createQuery(jpql, Long.class);
		Long count = (Long) query.getSingleResult();

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public Users getUserByUserName(String userName) {
		String jpql = "select e from Users e where e.userName = '" + userName + "'";
		TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
		Users user = (Users) query.getSingleResult();
		return user;
	}

	@Transactional
	public void addUser(Users user) {
		entityManager.persist(user);
	}

	@Transactional
	public void deleteUser(Users user) {
		entityManager.remove(user);
	}

	@Transactional
	public List<Users> getUsersList() {
		String jpql = "select e from Users";
		TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
		List<Users> users = query.getResultList();
		return users;
	}

	@Transactional
	public void updateUser(Users user) {
		entityManager.merge(user);
	}

	@Transactional
	public Users getUserById(Long id) {
		Users user = entityManager.find(Users.class, id);
		return user;
	}

	@Transactional
	public void addUserFriend(Long id, Friends friend) {
		Users userfromDB = entityManager.find(Users.class, id);
		List<Friends> friends = userfromDB.getFriends();
		friends.add(friend);
		entityManager.persist(friend);
		entityManager.merge(userfromDB);
	}
	
}
