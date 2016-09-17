package org.bigj.blackjack.domain.exception;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */
public class IllegalCommandException extends RuntimeException {
    public IllegalCommandException(String message) {
        super(message);
    }
}
