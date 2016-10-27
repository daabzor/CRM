package com.daabzor.crm.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daabzor.crm.database.jpaRepository.PersonalInformationRepository;
import com.daabzor.crm.database.model.PersonalInformation;

@Service
public class PersonalInformationService {
	
	@Autowired
	private PersonalInformationRepository personalInformationRepository;

	public void updatePersonalInformation(PersonalInformation personalInformation) {
		personalInformationRepository.updatePersonalInformation(personalInformation);
	}
	
	public void addPersonalInformation(PersonalInformation personalInformation) {
		personalInformationRepository.addPersonalInformation(personalInformation);
	}
}
