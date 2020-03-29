package com.logging.loggerLibrary.sink;

import com.logging.loggerLibrary.model.Message;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileSink implements Sink {

    @Override
    public void writeInSink(Message message, String filePath) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath), "utf-8"))) {
            writer.write(message.getTimestamp() + "  [" + message.getLevel() + "] " + message.getNamespace() +
                    " -  " + message.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}