package org.bigj.blackjack.service;

import org.bigj.blackjack.domain.exception.IllegalCommandException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

@Service
public class GameService {

    final private static String[] allowedCommands = {"start", "stop", "hitme", "help"};
    final private static String defaultTemplate = "Command {0} received";
    final private static String helpMessage =
            "Allowed terminal commands:\n" +
            "start - starts game\n" +
            "stop - stops game\n" +
            "hitme - one more card\n" +
            "help - display this message";

    public String play(String command) {
        if (!isLegalCommand(command)) {
            throw new IllegalCommandException(command);
        }

        String response;
        switch (command) {
            case "help":
                response = helpMessage;
                break;
            default:
                response = MessageFormat.format(defaultTemplate, command);
                break;
        }

        return response;
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
