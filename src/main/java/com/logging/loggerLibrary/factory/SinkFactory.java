package com.logging.loggerLibrary.factory;

import com.logging.loggerLibrary.sink.ConsoleSink;
import com.logging.loggerLibrary.sink.DBSink;
import com.logging.loggerLibrary.sink.FileSink;
import com.logging.loggerLibrary.sink.Sink;

public class SinkFactory {

    public static Sink getSink(String name) {
        switch (name) {
            case "FILE":
                return new FileSink();
            case "CONSOLE":
                return new ConsoleSink();
            case "DB":
                return new DBSink();
            default:
                return new ConsoleSink();
        }
    }
}
