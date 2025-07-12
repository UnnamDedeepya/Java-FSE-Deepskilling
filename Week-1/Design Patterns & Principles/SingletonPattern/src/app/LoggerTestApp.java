package app;

import logger.Logger;

public class LoggerTestApp {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.log("Application started");

        Logger log2 = Logger.getInstance();
        log2.log("Database connection opened");

        System.out.println("\nChecking if both loggers are same: " + (log1 == log2));
    }
}