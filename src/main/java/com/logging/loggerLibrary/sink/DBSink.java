package com.logging.loggerLibrary.sink;

import com.logging.loggerLibrary.dao.LoggerDao;
import com.logging.loggerLibrary.dao.LoggerDaoImpl;
import com.logging.loggerLibrary.model.Message;

public class DBSink implements Sink {

    @Override
    public void writeInSink(Message message, String dbUrl) {

        LoggerDao loggerDao = new LoggerDaoImpl();
        loggerDao.insert(message);
    }


}
