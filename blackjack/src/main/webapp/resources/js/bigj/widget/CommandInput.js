/**
 * Created by arthan on 14.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
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

        postCreate: function () {
            on(this.textInput, "keyup", (e) => {
                if (e.keyCode == keys.ENTER && this.textInput.value /* Not empty input */) {
                    let inputValue = this.textInput.value;
                    topic.publish(topics.TERMINAL_INPUT, {value: inputValue});
                    this.textInput.value = null;
                }
            });
        }


    });
});