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
    "dojo/_base/array",
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
    arrayUtil,
    _WidgetBase,
    _TemplatedMixin,
    logger,
    topics,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        
        templateString: template,

        _currnettPos:0,

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
            arrayOfCommand = [];
            this.keyupHandler = on(this.textInput, "keyup", (e) => {
                if (e.keyCode == keys.ENTER &&
                    this.textInput.value /* Not empty input */
                ) {
                    let inputValue = this.textInput.value;

                    if(arrayOfCommand.length == 10) {
                        arrayOfCommand.shift();
                    }
                    arrayOfCommand.push(inputValue);
                    this._currnettPos = arrayOfCommand.length;
                    topic.publish(topics.TERMINAL_INPUT, {value: inputValue});
                    this.textInput.value = null;
                }
            });
            this.keydownHandler = on(this.textInput, "keydown", (e) => {
                 if (e.keyCode == keys.UP_ARROW) {
                    console.log(this._currnettPos)
                    if ( this._currnettPos >= 0) {
                        if (this._currnettPos != 0) this._currnettPos--;
                        this.textInput.value = arrayOfCommand[this._currnettPos];
                    }
                }
                else if(e.keyCode == keys.DOWN_ARROW){
                    if ( this._currnettPos >= 0 && this._currnettPos < arrayOfCommand.length ) {
                        if ( this._currnettPos != (arrayOfCommand.length - 1)) this._currnettPos++;
                        this.textInput.value = arrayOfCommand[ this._currnettPos];
                    }
                }
            });
        },

        destroy: function () {
            this.inherited(arguments);
            this.keyupHandler && this.keyupHandler.remove();
            this.keydownHandler && this.keydownHandler.remove();
        }


    });
});