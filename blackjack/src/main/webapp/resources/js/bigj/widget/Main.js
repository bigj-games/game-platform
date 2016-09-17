/**
 * Created by arthan on 14.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dijit/_WidgetBase",
    "bigj/widget/GameTerminal"
], function (
    declare,
    domConstruct,
    _WidgetBase,
    GameTerminal
) {
    return declare([_WidgetBase], {
        
        buildRendering: function () {
            this.domNode = domConstruct.create("div", {
                innerHTML: "BlackJack Application"
            });
            new GameTerminal().placeAt(this.domNode);
        },
        
        postCreate: function () {
            
        }
    });
});