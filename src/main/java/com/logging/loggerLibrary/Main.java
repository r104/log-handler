package com.logging.loggerLibrary;

import com.logging.loggerLibrary.enums.Level;
import com.logging.loggerLibrary.module.LoggerImpl;
import com.logging.loggerLibrary.module.LoggerLib;

public class Main {


    public static void main(String[] args) {

//        String logLevel = System.getenv("log_level");
//        String infoSink = System.getenv("log_info_sink");
//        String errorSink = System.getenv("log_error_sink");
//        String fatalSink = System.getenv("log_fatal_sink");
//        String debugSink = System.getenv("log_debug_sink");
//        String filePath = System.getenv("file_path");
//        String dbUrl = System.getenv("db_url");
//        String dbPassword = System.getenv("db_password");

        String logLevel = Level.INFO.toString();
        String infoSink = "DB";
        String errorSink = "FILE";
        String fatalSink = "FILE";
        String debugSink = "FILE";
        String filePath = "testFile.txt";
        String dbUrl = System.getenv("db_url");

        LoggerLib logger = new LoggerImpl(Level.valueOf(logLevel), infoSink, errorSink, fatalSink, debugSink,
                filePath, dbUrl);

        logger.info("message", Main.class.getName());

        System.out.println("message written");
    }
}
