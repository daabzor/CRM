package com.daabzor.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.daabzor.crm.database.model.PersonalInformation;
import com.daabzor.crm.database.model.Users;
import com.daabzor.crm.database.service.PersonalInformationService;
import com.daabzor.crm.database.service.UsersService;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UsersService userService;
	@Autowired
	PersonalInformationService personalInformationService;

	@RequestMapping(method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("user", new Users());
		return "login";
	}

	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	public String logIn(@ModelAttribute("user") @Valid Users user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		} else {
			if (!userService.checkIfUserExists(user)) {
				model.addAttribute("errorUser", "User does not exist!");
				return "login";
			}
			if (!userService.checkUserPassword(user)) {
				model.addAttribute("errorPassword", "Password is incorrect");
				return "login";
			}
			user = userService.getUser(user);

			model.addAttribute("user", user);
			model.addAttribute("personalInfo", user.getpersonalInformation());
			return "welcome";
		}
	}

	@RequestMapping(value = "/personalInfo", method = RequestMethod.POST)
	public String updatePersonalInformation(@ModelAttribute("personalInfo") @Valid PersonalInformation personalInfo,
			BindingResult result, Model model, @ModelAttribute("user") Users user) {
		if (result.hasErrors()) {
			return "welcome";
		} else {
			personalInfo.setId(user.getpersonalInformation().getId());
			personalInformationService.updatePersonalInformation(personalInfo);
			return "welcome";
		}
	}

}
