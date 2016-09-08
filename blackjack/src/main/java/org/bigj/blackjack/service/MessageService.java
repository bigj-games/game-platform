package org.bigj.blackjack.service;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Created by arthan on 08.09.2016. Project game-platform
 */

@Component
public class MessageService {

    private static final String messageTemplate = "Greetings, {0}";

    public String getMessage(String name) {
        return MessageFormat.format(messageTemplate, name);
    }
}
