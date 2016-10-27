package com.daabzor.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.daabzor.crm.database.model.PersonalInformation;
import com.daabzor.crm.database.model.Users;
import com.daabzor.crm.database.service.PersonalInformationService;
import com.daabzor.crm.database.service.StringVerification;
import com.daabzor.crm.database.service.UsersService;

@Controller
@RequestMapping("/create-account")
@SessionAttributes("user")
public class CreateAccountController {

	@Autowired
	UsersService userService;

	@Autowired
	PersonalInformationService personalInformationService;

	@Autowired
	StringVerification stringVerification;

	@RequestMapping(method = RequestMethod.GET)
	public String showCreateAccountPage(Model model) {
		model.addAttribute("user", new Users());
		return "create-account";
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("user") @Valid Users user, BindingResult result,
			@RequestParam("confirmedPassword") String confirmedPassword, Model model) {
		if (userService.checkIfUserExists(user)) {
			model.addAttribute("errorLoginVerification", "User exist!");
			return "create-account";
		} else if (result.hasErrors()) {
			return "create-account";
		} else {
			String stringCreateAccountVerification = stringVerification
					.stringCreateAccountVerification(user.getUserName(), user.getUserPassword(), confirmedPassword);
			if (stringCreateAccountVerification != null) {
				model.addAttribute("errorLoginVerification", stringCreateAccountVerification);
				return "create-account";
			} else {
				model.addAttribute("loginAvailability", "Login is avalible.");
				model.addAttribute("personalInfo", new PersonalInformation());
				return "add-personal-information";
			}
		}
	}

	@RequestMapping(value = "/add-personal-info", method = RequestMethod.POST)
	public String addPersonalInformation(@ModelAttribute("personalInfo") @Valid PersonalInformation personalInfo,
			BindingResult result, Model model, @ModelAttribute("user") Users user) {
		if (result.hasErrors()) {
			return "add-personal-information";
		} else {
			user.setpersonalInformation(personalInfo);
			personalInformationService.addPersonalInformation(personalInfo);
			userService.addUser(user);
			model.addAttribute("createAccountInfo", "Success - Your account has been created!");
			return "add-personal-information";
		}
	}

}
