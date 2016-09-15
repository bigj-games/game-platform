/**
 * Created by arthan on 14.09.2016.
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/on",
    "dojo/topic",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "bigj/util/logger",
    "bigj/topics",
    "dojo/text!./html/CommandInput.html"
], function (
    declare,
    domConstruct,
    on,
    topic,
    _WidgetBase,
    _TemplatedMixin,
    logger,
    topics,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        
        templateString: template,

        postCreate: function () {
            on(this.textInput, "keyup", (e) => {
                if (e.keyCode == 13 /* Enter */) {
                    let inputValue = this.textInput.value;
                    topic.publish(topics.TERMINAL_INPUT, {value: inputValue});
                }
            });
        }


    });
});