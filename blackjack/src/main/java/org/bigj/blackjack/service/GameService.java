package org.bigj.blackjack.service;

import org.bigj.blackjack.domain.exception.IllegalCommandException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

@Service
public class GameService {

    final private static String[] allowedCommands = {"start", "stop", "hitme"};
    final private static String defaultTemplate = "Command {0} received";
    final private static String unknownCommandTemplate = "{0}: unknown command";

    public String play(String command) {

        if (!isLegalCommand(command)) {
            throw new IllegalCommandException(MessageFormat.format(unknownCommandTemplate, command));
        }
        return MessageFormat.format(defaultTemplate, command);
    }

    private boolean isLegalCommand(String command) {
        for (String allowedCommand : allowedCommands) {
            if (allowedCommand.equals(command)) {
                return true;
            }
        }
        return false;
    }
}
