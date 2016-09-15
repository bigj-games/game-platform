package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by arthan on 09.09.2016. Project game-platform
 */

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcome(ModelMap model) {
        User user = new User();
        user.setName("Marco Polo");

        model.addAttribute("username", "Test User");
        model.addAttribute("user", user);

        return "index";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin (ModelMap model) {
		return "login";
	}

}
