package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arthan on 08.09.2016. Project game-platform
 */

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "User") String name) {
        return messageService.getMessage(name);
    }
}
