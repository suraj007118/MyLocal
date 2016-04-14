package com.morningstar.Framework;

import org.apache.log4j.Logger;

/**
 * Created by Sanit Thale on 3/21/2016 11:48 AM.
 */
public class FrameworkServices {

    Logger log = Logger.getLogger(FrameworkServices.class);

    public void logMessage(String message, Logger logger) {
        logger.info(message);
        System.out.print(message);
    }

    public void logErrorMessage(String message, Logger logger) {
        logger.error(message);
    }
}
