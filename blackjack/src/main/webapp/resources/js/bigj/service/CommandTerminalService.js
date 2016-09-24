    /**
    * Created by ashamsiev on 15.09.2016. | Project game-platform
    */

define([
    "dojo/_base/declare",
    "dojo/topic",
    "dojo/request",
    "bigj/topics",
    "bigj/constants",
    "bigj/util/logger"
], function (
    declare,
    topic,
    request,
    topics,
    constants,
    logger
) {
    return declare([], {
        
        constructor: function () {
            topic.subscribe(topics.TERMINAL_INPUT, this.onCommandInput.bind(this));
        },

        onCommandInput: function (payload) {
            var command = payload.value;
            
            if (command == "clean") {
                topic.publish(topics.TERMINAL_CLEAN);
            } else {
                topic.publish(topics.TERMINAL_BLOCK);
                request.post(constants.get().context + "/game/command", {
                    data: {
                        command: command
                    },
                    timeout: 5000,
                    handleAs: "json"
                }).then(res => {
                    topic.publish(topics.TERMINAL_UNBLOCK);
                    topic.publish(topics.TERMINAL_PRINT, {
                        command: command, 
                        response: {
                            value: res.response,
                            status: res.status
                        }
                    });
                }, res => {
                    topic.publish(topics.TERMINAL_UNBLOCK);
                    logger.error(res);
                });
            }
        }
    });
});