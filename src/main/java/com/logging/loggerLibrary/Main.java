package com.logging.loggerLibrary;

import com.logging.loggerLibrary.enums.Level;
import com.logging.loggerLibrary.module.LoggerImpl;
import com.logging.loggerLibrary.module.LoggerLib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        String infoSink = "FILE";
        String errorSink = "FILE";
        String fatalSink = "FILE";
        String debugSink = "FILE";
        String filePath = "testFile2.txt";
        String dbUrl = System.getenv("db_url");

        LoggerLib log = new LoggerImpl(Level.valueOf(logLevel), infoSink, errorSink, fatalSink, debugSink,
                filePath, dbUrl);
        LoggerLib log1 = new LoggerImpl(Level.valueOf(logLevel), infoSink, errorSink, fatalSink, debugSink,
                filePath, dbUrl);
        LoggerLib log2 = new LoggerImpl(Level.valueOf(logLevel), infoSink, errorSink, fatalSink, debugSink,
                filePath, dbUrl);

        Integer numberOfThreads = 10;
        Runnable task = () -> {
            for(int i = 0; i < 10; i++) {
                log.info("test " + i, "1");
            }
        };
        Runnable task1 = () -> {
            for(int i = 0; i < 10; i++) {
                log1.info("test " + i, "1");
            }
        };
        Runnable task2 = () -> {
            for(int i = 0; i < 10; i++) {
                log1.info("test " + i, "1");
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < numberOfThreads; i++) {
            if(i%3 == 0)
                executor.execute(task);
            else if(i%3 == 1)
                executor.execute(task1);
            else
                executor.execute(task2);
        }

        executor.shutdown();
        //log.info("message", Main.class.getName());

        System.out.println("message written");
    }
}
