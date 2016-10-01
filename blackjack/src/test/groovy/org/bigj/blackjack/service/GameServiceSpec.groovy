package org.bigj.blackjack.service

import org.bigj.blackjack.config.BlackjackConfiguration
import org.bigj.blackjack.config.BlackjackSecurityConfig
import org.bigj.blackjack.config.BlackjackWebConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

/**
 * Created by arthan on 01.10.2016. | Project game-platform
 */

@ContextConfiguration(
        classes = [
                BlackjackConfiguration.class,
                BlackjackSecurityConfig.class,
                BlackjackWebConfig.class
        ]
)
@WebAppConfiguration
class GameServiceSpec extends Specification {

    @Autowired
    GameService gameService
    private String expectedHelpMessage

    void setup() {
        expectedHelpMessage =
'''Allowed terminal commands:
start - starts game
stop - stops game
hitme - one more card
help - display this message'''
    }

    def "should_return_help_message"() {
        when:
        def helpMessage = gameService.play("help")
        then:
        helpMessage == expectedHelpMessage
    }
}
