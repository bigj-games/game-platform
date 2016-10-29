package org.bigj.blackjack.web.controller;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.bigj.blackjack.service.GameService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arthan on 27.10.2016. | Project game-platform
 */
public class GameControllerTest {

    @Tested
    private GameController gameController;
    @Injectable
    private GameService gameService;

    @Test
    public void should_invoke_gameService_play_method() throws Exception {
        final String TEST_COMMAND = "test_command";

        new Expectations() {{gameService.play(TEST_COMMAND);}};

        gameController.postPlayerCommand(TEST_COMMAND);
    }
}