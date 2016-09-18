/**
 * Created by ashamsiev on 15.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/dom-style",
    "dojo/topic",
    "dijit/_WidgetBase",
    "bigj/topics",
    "bigj/widget/CommandOutput",
    "bigj/widget/CommandInput"
], function (
    declare,
    domConstruct,
    domStyle,
    topic,
    _WidgetBase,
    topics,
    CommandOutput,
    CommandInput
) {
    return declare([_WidgetBase], {

        constructor: function () {
            this.setUpSubscriptions();
        },

        setUpSubscriptions: function () {
            topic.subscribe(topics.TERMINAL_BLOCK, (payload) => {
                domStyle.set(this.overlay, "display", "block");
            });
            topic.subscribe(topics.TERMINAL_UNBLOCK, (payload) => {
                domStyle.set(this.overlay, "display", "none");
            });
        },

        buildRendering: function () {
            this.domNode = domConstruct.create("div", {
                "class": "game-terminal"
            });
            new CommandOutput().placeAt(this.domNode);
            new CommandInput().placeAt(this.domNode);
            this.overlay = domConstruct.create("div", {
                "class": "terminal-overlay",
                "style": "display: none"
            }, this.domNode);
            domConstruct.create("img", {
                src: "/blackjack/resources/image/loader.gif",
                "class": "overlay-image"
            }, this.overlay);
        },

         postCreate: function () {
             
         }
    });
});