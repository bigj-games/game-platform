/**
 * Created by ashamsiev on 15.09.2016. | Project game-platform
 */

define([
    "dojo/_base/declare",
    "dojox/uuid/generateRandomUuid",
    "bigj/util/logger"
], function (
    declare,
    uuid,
    logger
) {
    let ServiceRegistry = declare([], {
        constructor: function (config) {
            if (config.globalVar == null) {
                logger.error("Global variable should be set for service registry.");
            }
            
            this.global = config.globalVar;
        },

        register: function (ServiceConstructor) {
            if (window[this.global] == null) {
                logger.error("Global variable", this.global, "is not initialized.");
            }
            if (window[this.global].services == null) {
                window[this.global].services = {};
            }

            window[this.global].services[uuid()] = new ServiceConstructor();
        }
    });
    
    return ServiceRegistry;
});