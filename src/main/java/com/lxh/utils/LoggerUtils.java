package com.lxh.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    private static Logger logger = LoggerFactory.getLogger(LoggerUtils.class);


    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logError(String msg,String e) {
        logger.error(msg, e);
    }
}
