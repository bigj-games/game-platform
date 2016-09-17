package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.GameResponse;
import org.bigj.blackjack.domain.exception.IllegalCommandException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(IllegalCommandException.class)
    public GameResponse handleGameException(IllegalCommandException ex) {
        return new GameResponse(ex.getMessage(), "error");
    }
}
