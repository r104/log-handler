package com.logging.loggerLibrary.sink;

import com.logging.loggerLibrary.model.Message;

public class ConsoleSink implements Sink {

    @Override
    public void writeInSink(Message message, String filePath) {

        System.out.println(message.getTimestamp() + "  [" + message.getLevel() + "] " + message.getNamespace() +
                " -  " + message.getContent());
    }


}
