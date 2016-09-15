/**
 * Created by ashamsiev on 15.09.2016.
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
            var value = payload.value;
            
            //Send request to the server here
            
            topic.publish(topics.TERMINAL_OUTPUT, {value: value});
        }
    });
});