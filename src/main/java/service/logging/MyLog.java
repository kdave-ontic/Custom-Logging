package service.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLog implements Log {

    private static final Logger LOGGER = Logger.getLogger(MyLog.class.getName());

    private Logger myLogger;

    public MyLog(Class<?> loggerClass) {
        myLogger = Logger.getLogger(loggerClass.getName());
    }

    @Override
    public void error(Message message) {
        if (myLogger.isLoggable(Level.SEVERE)) {
            myLogger.log(Level.SEVERE, message.toJson());
        }
    }

    @Override
    public void warn(Message message) {
        if (myLogger.isLoggable(Level.WARNING)) {
            myLogger.log(Level.WARNING, message.toJson());
        }
    }

    @Override
    public void info(Message message) {
        if (myLogger.isLoggable(Level.INFO)) {
            myLogger.log(Level.INFO, message.toJson());
        }
    }

    @Override
    public void debug(Message message) {
        if (myLogger.isLoggable(Level.FINE)) {
            myLogger.log(Level.FINE, message.getFormattedMessage(), message.getCause());
        }
    }

    @Override
    public void trace(Message message) {
        if (myLogger.isLoggable(Level.FINER)) {
            myLogger.log(Level.FINER, message.getFormattedMessage(), message.getCause());
        }
    }
}
