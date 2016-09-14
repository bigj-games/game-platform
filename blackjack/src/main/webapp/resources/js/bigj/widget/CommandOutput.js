/**
 * Created by arthan on 14.09.2016.
 */

define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dojo/text!./html/CommandOutput.html"
], function (
    declare,
    domConstruct,
    _WidgetBase,
    _TemplatedMixin,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        
        templateString: template,

        postCreate: function () {
            
        }
    });
});