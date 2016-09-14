/**
 * Created by arthan on 14.09.2016.
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dijit/_WidgetBase",
    "bigj/widget/CommandOutput",
    "bigj/widget/CommandInput"
], function (
    declare,
    domConstruct,
    _WidgetBase,
    CommandOutput,
    CommandInput
) {
    return declare([_WidgetBase], {
        
        buildRendering: function () {
            this.domNode = domConstruct.create("div", {
                innerHTML: "BlackJack Application"
            });
        },
        
        postCreate: function () {
            new CommandOutput().placeAt(this.domNode);
            new CommandInput().placeAt(this.domNode);
        }
    });
});