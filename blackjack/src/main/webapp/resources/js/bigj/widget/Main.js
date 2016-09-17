/**
 * Created by arthan on 14.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dijit/_WidgetBase",
    "bigj/widget/GameTerminal",
    "bigj/widget/PageHeader"
], function (
    declare,
    domConstruct,
    _WidgetBase,
    GameTerminal,
    PageHeader
) {
    return declare([_WidgetBase], {
        
        buildRendering: function () {
            this.domNode = domConstruct.create("div", {});
            new PageHeader().placeAt(this.domNode);
            new GameTerminal().placeAt(this.domNode);
        },
        
        postCreate: function () {
            
        }
    });
});