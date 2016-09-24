/**
 * Created by arthan on 24.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dijit/_WidgetBase"
], function (declare,
             _WidgetBase) {
    let constants;
    Object.freeze(constants);
    return {
        get: () => {
            if (!constants) {
                constants = {
                    context: Bigj.CONTEXT_PATH
                };
            }
            return constants;
        }
    };
});

         
             
 
 