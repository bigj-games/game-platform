/**
 * Created by arthan on 14.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/dom-attr",
    "dojo/on",
    "dojo/topic",
    "dojo/keys",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "bigj/util/logger",
    "bigj/topics",
    "dojo/text!./html/CommandInput.html"
], function (
    declare,
    domConstruct,
    domAttr,
    on,
    topic,
    keys,
    _WidgetBase,
    _TemplatedMixin,
    logger,
    topics,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        
        templateString: template,

        constructor: function () {
            this.setUpSubscriptions();
        },

        setUpSubscriptions: function () {
            topic.subscribe(topics.TERMINAL_BLOCK, (payload) => {
                domAttr.set(this.textInput, "readonly", true);
            });
            topic.subscribe(topics.TERMINAL_UNBLOCK, (payload) => {
                domAttr.remove(this.textInput, "readonly");
            });
        },

        postCreate: function () {
            this.keyupHandler = on(this.textInput, "keyup", (e) => {
                if (e.keyCode == keys.ENTER &&
                    this.textInput.value /* Not empty input */
                ) {
                    let inputValue = this.textInput.value;
                    topic.publish(topics.TERMINAL_INPUT, {value: inputValue});
                    this.textInput.value = null;
                }
            });
        },

        destroy: function () {
            this.inherited(arguments);
            this.keyupHandler && this.keyupHandler.remove();
        }


    });
});