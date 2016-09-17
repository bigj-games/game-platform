    /**
    * Created by ashamsiev on 15.09.2016. | Project game-platform
    */

define([
    "dojo/_base/declare",
    "dojo/topic",
    "bigj/topics",
    "bigj/util/logger"
], function (
    declare,
    topic,
    topics,
    logger
) {
    return declare([], {
        
        constructor: function () {
            topic.subscribe(topics.TERMINAL_INPUT, this.onCommandInput.bind(this));
        },

        onCommandInput: function (payload) {
            var command = payload.value;
            
            if (command == "clean") {
                topic.publish(topics.TERMINAL_CLEAN, {});
            } else {
                
                //Send request to the server here

                topic.publish(topics.TERMINAL_PRINT, {command: command, response: "Unknown command"});
            }
        }
    });
});