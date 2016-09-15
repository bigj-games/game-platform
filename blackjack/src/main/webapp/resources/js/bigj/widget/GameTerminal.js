/**
 * Created by ashamsiev on 15.09.2016.
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/topic",
    "dijit/_WidgetBase",
    "bigj/widget/CommandOutput",
    "bigj/widget/CommandInput"
], function (
    declare,
    domConstruct,
    topic,
    _WidgetBase,
    CommandOutput,
    CommandInput
) {
    return declare([_WidgetBase], {

        buildRendering: function () {
            this.domNode = domConstruct.create("div");
            new CommandOutput().placeAt(this.domNode);
            new CommandInput().placeAt(this.domNode);
        },

         postCreate: function () {
             
         }
    });
});