package org.bigj.blackjack.web.controller;

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
        model.addAttribute("username", "Test User");
        return "index";
    }
}
