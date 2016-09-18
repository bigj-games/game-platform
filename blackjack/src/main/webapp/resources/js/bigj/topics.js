/**
 * Created by ashamsiev on 15.09.2016. | Project game-platform
 */

define([
    
], function (
    
) {
    let topics = {
        TERMINAL_INPUT: "BLACK_JACK_GAME_TERMINAL_INPUT",
        TERMINAL_PRINT: "BLACK_JACK_GAME_TERMINAL_OUTPUT",
        TERMINAL_CLEAN: "BLACK_JACK_GAME_TERMINAL_CLEAN",
        TERMINAL_BLOCK: "BLACK_JACK_GAME_TERMINAL_BLOCK",
        TERMINAL_UNBLOCK: "BLACK_JACK_GAME_TERMINAL_UNBLOCK"
    };
    Object.freeze(topics);
    
    return topics;  
});