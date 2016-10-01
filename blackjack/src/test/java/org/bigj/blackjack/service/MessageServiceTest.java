package org.bigj.blackjack.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by arthan on 01.10.2016. | Project game-platform
 */
public class MessageServiceTest {

    @Test
    public void should_get_right_greeting_message() throws Exception {
        MessageService messageService = new MessageService();
        assertEquals("Wrong greeting message", messageService.getMessage("user"), "Greetings, user");
    }
}