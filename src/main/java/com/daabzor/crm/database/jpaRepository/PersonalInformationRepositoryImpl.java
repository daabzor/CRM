package com.daabzor.crm.database.jpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daabzor.crm.database.model.PersonalInformation;

@Repository
public class PersonalInformationRepositoryImpl implements PersonalInformationRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addPersonalInformation(PersonalInformation personalInformation) {
		entityManager.persist(personalInformation);
	}
	
	@Transactional
	public void updatePersonalInformation(PersonalInformation personalInformation) {
		Long id = personalInformation.getId();
		PersonalInformation person = entityManager.find(PersonalInformation.class, id);
		person = personalInformation;
		entityManager.merge(person);
	}
	
}
