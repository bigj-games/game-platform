package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.entity.User;
import org.bigj.blackjack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by arthan on 02.10.2016. | Project game-platform
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // В этом методе используются два разных ответить на запрос
    @PostMapping(value = "/register")
    String register(@RequestParam Map<String, String> request, ModelMap modelMap) {

        String username = request.get("username");
        String password = request.get("password");
        String repeatedPassword = request.get("repeatedPassword");

        if (!password.equals(repeatedPassword)) {
            modelMap.put("passwordNotRepeated", true);
            return "registration";
        }

        User user = userService.byUsername(username);
        if (user != null) {
            return "redirect:/registration?exists";
        } else {
            userService.createUser(new User(username, password));
            modelMap.put("newUserCreated", true);
            return "login";
        }
    }
}
