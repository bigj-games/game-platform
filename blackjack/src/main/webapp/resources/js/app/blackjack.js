/**
 * Created by arthan on 13.09.2016.
 */

require([
    "dojo/parser",
    "bigj/util/logger",
    "bigj/serviceRegistry",
    "bigj/service/CommandTerminalService",
    "dojo/domReady!"
], function (
    parser,
    logger,
    ServiceRegistry,
    CommandTerminalService
) {
    // set global variable
    if (window.Bigj == null) {
        window.Bigj = {}
    }
    logger.log("Blackjack applicaton started!");
    
    let serviceRegistry = new ServiceRegistry({
        globalVar: "Bigj"
    });
    serviceRegistry.register(CommandTerminalService);
});