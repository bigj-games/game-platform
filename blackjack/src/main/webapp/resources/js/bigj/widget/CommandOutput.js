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
            this.lines = [];
            this.setUpSubscriptions();
        },

        setUpSubscriptions: function () {
            topic.subscribe(topics.TERMINAL_PRINT, this.onTerminalPrint.bind(this));
            topic.subscribe(topics.TERMINAL_CLEAN, this.cleanTerminal.bind(this));
        },

        onTerminalPrint: function (payload) {
            var command = payload.command;
            this.addOutput(command);
            this.addOutput(payload.response.value, payload.response.status);
            this.renderLines();
        },

        addOutput: function (command, type = "info") {
            var output = command.value || command;
            for (var line of output.split("\n")) {
                if (this.lines.length == this.MAX_LINES) {
                    this.lines.shift();
                }
                this.lines.push({value: line, status: type});
            }
        },

        renderLines: function () {
            domConstruct.empty(this.domNode);
            for (var c of this.lines) {
                domConstruct.create("div", {
                    "class": c.status == "error" ? "error-text" : "",
                    innerHTML: c.value
                }, this.domNode);
            }
        },

        cleanTerminal: function () {
            this.lines.length = 0;
            this.renderLines();
        }
    });
});