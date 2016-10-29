package org.bigj.blackjack.web.controller;

import org.bigj.blackjack.domain.dto.GameResponse;
import org.bigj.blackjack.domain.exception.IllegalCommandException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.MessageFormat;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    final private static String unknownCommandTemplate = "{0}: unknown command";

    @ExceptionHandler(IllegalCommandException.class)
    public GameResponse handleGameException(IllegalCommandException ex) {
        String message = MessageFormat.format(unknownCommandTemplate, ex.getMessage());
        return new GameResponse(message, "error");
    }
}
