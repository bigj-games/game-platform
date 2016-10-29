package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.dto.GameResponse;
import org.bigj.blackjack.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping(value = "/command", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GameResponse postPlayerCommand(@RequestParam(name = "command") String command) {
        return new GameResponse(gameService.play(command));
    }
}
