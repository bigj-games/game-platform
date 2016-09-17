/**
 * Created by arthan on 14.09.2016. | Project game-platform
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
            this.setUpSubscriptions();
        },

        setUpSubscriptions: function () {
            topic.subscribe(topics.TERMINAL_PRINT, this.onTerminalPrint.bind(this));
            topic.subscribe(topics.TERMINAL_CLEAN, this.cleanTerminal.bind(this));
        },

        onTerminalPrint: function (payload) {
            var command = payload.command;
            this.addLine(command);
            this.addLine(payload.response);
            this.renderCommands();
        },

        addLine: function (command) {
            if (this.commands.length == this.MAX_LINES) {
                this.commands.shift();
            }
            this.commands.push(command);
        },

        renderCommands: function () {
            domConstruct.empty(this.domNode);
            for (var c of this.commands) {
                domConstruct.create("div", {
                    innerHTML: c
                }, this.domNode);
            }
        },

        cleanTerminal: function () {
            this.commands.length = 0;
            this.renderCommands();
        }
    });
});