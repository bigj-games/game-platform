/**
 * Created by arthan on 13.09.2016. | Project game-platform
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
    Bigj.CONTEXT_PATH = window.java_app_bj_context;
    logger.log("Blackjack applicaton started!");
    
    let serviceRegistry = new ServiceRegistry({
        globalVar: "Bigj"
    });
    serviceRegistry.register(CommandTerminalService);
});