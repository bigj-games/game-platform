/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojo/on",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "bigj/util/logger",
    "bigj/constants",
    "dojo/text!./html/PageHeader.html"
], function(
    declare,
    on,
    _WidgetBase,
    _TemplatedMixin,
    logger,
    constants,
    template
) {
    return declare([_WidgetBase, _TemplatedMixin], {
        templateString: template,
        
        postCreate: function () {
            this.logout.href = constants.get().context + "/logout";
        }
    });
});
