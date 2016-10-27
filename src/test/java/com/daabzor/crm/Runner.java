package com.daabzor.crm;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daabzor.crm.database.jpaRepository.FriendRepositoryImpl;
import com.daabzor.crm.database.jpaRepository.FriendsRepository;
import com.daabzor.crm.database.model.Friends;
import com.daabzor.crm.database.model.PersonalInformation;
import com.daabzor.crm.database.model.Users;
import com.daabzor.crm.database.service.FriendsService;
import com.daabzor.crm.database.service.UsersService;

public class Runner {
	
	public static void main(String[] args) throws SQLException, ParseException {		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
	
	}

}
