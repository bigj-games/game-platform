package org.bigj.blackjack.service

import spock.lang.Specification

/**
 * Created by arthan on 01.10.2016. | Project game-platform
 */


class MessageServiceSpec extends Specification {
    private String test_user
    private String expectedMessage

    void setup() {
        test_user = "test_user"
        expectedMessage = "Greetings, " + test_user
    }

    def should_get_right_greeting_message() {
        given:
        def messageService = new MessageService()
        when:
        def greetingMessage = messageService.getMessage(test_user)
        then:
        greetingMessage == expectedMessage
    }
}
