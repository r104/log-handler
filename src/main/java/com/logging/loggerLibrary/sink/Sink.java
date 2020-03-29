package com.logging.loggerLibrary.sink;

import com.logging.loggerLibrary.model.Message;


public interface Sink {

    void writeInSink(Message message, String connStr);

}
