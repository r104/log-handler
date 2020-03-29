package com.logging.loggerLibrary.module;

import com.logging.loggerLibrary.enums.Level;
import com.logging.loggerLibrary.factory.SinkFactory;
import com.logging.loggerLibrary.model.Message;
import com.logging.loggerLibrary.sink.FileSink;
import com.logging.loggerLibrary.sink.Sink;
import org.joda.time.DateTime;


public class LoggerImpl implements LoggerLib {

    private Level logLevel;
    private String infoSink;
    private String errorSink;
    private String fatalSink;
    private String debugSink;
    private String filePath;
    private String dbUrl;

    public LoggerImpl(Level logLevel, String infoSink, String errorSink, String fatalSink, String debugSink,
                      String filePath, String dbUrl) {

        this.logLevel = logLevel;
        this.infoSink = infoSink;
        this.errorSink = errorSink;
        this.fatalSink = fatalSink;
        this.debugSink = debugSink;
        this.filePath = filePath;
        this.dbUrl = dbUrl;
    }

    public void debug(String content, String namespace) {

        Message message = new Message(content, Level.DEBUG, namespace, DateTime.now());
        Sink sink = SinkFactory.getSink(debugSink);
        writeInSink(sink, message, filePath, dbUrl);
    }

    @Override
    public void info(String content, String namespace) {

        if (logLevel.equals(Level.DEBUG)) {
            return;
        }
        Message message = new Message(content, Level.INFO, namespace, DateTime.now());
        Sink sink = SinkFactory.getSink(infoSink);
        try {
            writeInSink(sink, message, filePath, dbUrl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void error(String content, String namespace) {

        if (logLevel.equals(Level.DEBUG) || logLevel.equals(Level.INFO)) {
            return;
        }
        Message message = new Message(content, Level.ERROR, namespace, DateTime.now());
        Sink sink = SinkFactory.getSink(errorSink);
        try {
            writeInSink(sink, message, filePath, dbUrl);
        } catch (Exception e) {
            throw e;
        }
    }

    public void fatal(String content, String namespace) {

        if (logLevel.equals(Level.DEBUG) || logLevel.equals(Level.INFO) || logLevel.equals(Level.ERROR)) {
            return;
        }
        Message message = new Message(content, Level.FATAL, namespace, DateTime.now());
        Sink sink = SinkFactory.getSink(fatalSink);
        try {
            writeInSink(sink, message, filePath, dbUrl);
        } catch (Exception e) {
            throw e;
        }
    }

    private void writeInSink(Sink sink, Message message, String filePath, String dbUrl) {

        if (sink instanceof FileSink) {
            sink.writeInSink(message, filePath);
        } else {
            sink.writeInSink(message, dbUrl);
        }
    }
}