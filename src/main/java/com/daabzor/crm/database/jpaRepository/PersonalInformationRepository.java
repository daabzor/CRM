package com.daabzor.crm.database.jpaRepository;

import com.daabzor.crm.database.model.PersonalInformation;

public interface PersonalInformationRepository {

	void addPersonalInformation(PersonalInformation personalInformation);
	
	void updatePersonalInformation(PersonalInformation personalInformation);
	
}
