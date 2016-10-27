package com.daabzor.crm.database.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String userName;

	@NotEmpty
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z]+[0-9]+")
	private String userPassword;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean enabled;

	@OneToOne
	@JoinColumn(name = "personalInformation_id")
	private PersonalInformation personalInformation;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Friends> friends;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public PersonalInformation getpersonalInformation() {
		return personalInformation;
	}

	public void setpersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	public List<Friends> getFriends() {
		return friends;
	}

	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}

}
