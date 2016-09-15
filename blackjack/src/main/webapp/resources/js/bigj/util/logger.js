/**
 * Created by ashamsiev on 15.09.2016.
 */
define([
    
], function (
    
) {
    return {
        log: (...msg) => console.log(...msg),
        info: (...msg) => console.info(...msg),
        warn: (...msg) => console.warn(...msg),
        error: (...msg) => console.error(...msg)
    };
});