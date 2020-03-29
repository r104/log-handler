package com.logging.loggerLibrary.sink;

import com.logging.loggerLibrary.model.Message;

import java.io.*;

public class FileSink implements Sink {

    @Override
    public void writeInSink(Message message, String filePath) {

        try
        {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(message.getTimestamp() + "  [" + message.getLevel() + "] " + message.getNamespace() +
                    " -  " + message.getContent() + "\n");
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}