/**
 * Created by arthan on 14.09.2016.
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/topic",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "bigj/topics",
    "bigj/util/logger",
    "dojo/text!./html/CommandOutput.html"
], function (
    declare,
    domConstruct,
    topic,
    _WidgetBase,
    _TemplatedMixin,
    topics,
    logger,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {

        MAX_LINES: 10,
        
        templateString: template,

        constructor: function () {
            this.commands = [];
            topic.subscribe(topics.TERMINAL_OUTPUT, this.onTerminalOutput.bind(this))
        },

        postCreate: function () {
            
        },

        onTerminalOutput: function (payload) {
            value = payload.value;
            if (this.commands.length == this.MAX_LINES) {
                this.commands.shift();
            }
            this.commands.push(value);

            this.renderCommands(this.commands);
        },

        renderCommands: function (commands) {
            domConstruct.empty(this.domNode);
            for (var c of commands) {
                domConstruct.create("div", {
                    innerHTML: `#> ${c}`
                }, this.domNode);
            }
        }
    });
});