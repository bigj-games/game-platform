package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by arthan on 09.09.2016. Project game-platform
 */

@Controller
public class PageController {

    @GetMapping("/")
    public String showWelcome(ModelMap model) {
        User user = new User();
        user.setUsername("Marco Polo");

        model.addAttribute("username", "Test User");
        model.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/login")
	public String showLogin (ModelMap model) {
		return "login";
	}

    @GetMapping("/registration")
    public String showRegistration (ModelMap model) {
        return "registration";
    }

}
