package com.example;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerMagazine {

    private static final Logger log;

    static {
        // Configure Log4j
        try {
            DOMConfigurator.configure("log4j.xml");
//            DOMConfigurator.configure(LoggerMagazine.class.getClassLoader().getResource("log4j.xml"));
            log = Logger.getLogger(LoggerMagazine.class);
        } catch (Exception e) {
            // Handle exceptions during configuration
            throw new RuntimeException("Failed to configure Log4j", e);
        }
    }

    public static void log(String type, String messages) {
        switch (type) {
            case "trace":
                log.trace(messages);
                break;
            case "debug":
                log.debug(messages);
                break;
            case "info":
                log.info(messages);
                break;
            case "warn":
                log.warn(messages);
                break;
            case "error":
                log.error(messages);
                break;
            case "fatal":
                log.fatal(messages);
                break;
            default:
                log.error("Unknown log type: " + type);
                break;
        }
    }

    public static void logTrace(String messages) {
        log.trace(messages);
    }

    public static void logDebug(String messages) {
        log.debug(messages);
    }

    public static void logInfo(String messages) {
        log.info(messages);
    }

    public static void logWarn(String messages) {
        log.warn(messages);
    }

    public static void logError(String messages) {
        log.error(messages);
    }

    public static void logFatal(String messages) {
        log.fatal(messages);
    }
}
