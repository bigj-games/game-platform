/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dojo/text!./html/PageHeader.html"
], function(
    declare,
    _WidgetBase,
    _TemplatedMixin,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        templateString: template
        
    });
});
