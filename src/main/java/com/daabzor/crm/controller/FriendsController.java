package com.daabzor.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.daabzor.crm.database.model.Friends;
import com.daabzor.crm.database.model.Users;
import com.daabzor.crm.database.service.FriendsService;
import com.daabzor.crm.database.service.UsersService;

@Controller
@RequestMapping(value = "/add-friends")
@SessionAttributes("user")
public class FriendsController {

	@Autowired
	FriendsService friendsService;

	@Autowired
	UsersService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String showFriendsPage(Model model, @ModelAttribute("user") Users user) {
		model.addAttribute("friend", new Friends());
		model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
		return "friends";
	}

	@RequestMapping("/edit/{friends.friendId}")
	public String editFriend(@PathVariable("friends.friendId") Long id, Model model,
			@ModelAttribute("user") Users user) {
		model.addAttribute("friend", friendsService.getFriend(id));
		model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
		return "friends";
	}

	@RequestMapping("/delete/{friends.friendId}")
	public String deleteFriend(@PathVariable("friends.friendId") Long id, Model model,
			@ModelAttribute("user") Users user) {
		friendsService.deleteFriendById(id);
		model.addAttribute("friend", new Friends());
		model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
		return "friends";
	}

	@RequestMapping("/clear")
	public String clearTable(Model model, @ModelAttribute("user") Users user) {
		model.addAttribute("friend", new Friends());
		model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
		return "friends";
	}

	@RequestMapping(value = "/editFriend", method = RequestMethod.POST)
	public String logIn(@ModelAttribute("friend") @Valid Friends friend, BindingResult result, Model model,
			@ModelAttribute("user") Users user) {
		if (result.hasErrors()) {
			return "friends";
		} else if (friend.getFriendId() == null) {
			userService.addUserFriend(user, friend);
			model.addAttribute("friend", new Friends());
			model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
			return "friends";
		} else {
			friendsService.updateFriend(friend);
			model.addAttribute("friend", new Friends());
			model.addAttribute("friendsList", friendsService.getAllUserFriendsByUserId(user.getId()));
			return "friends";
		}
	}

}
