package service.logging;

public class Logger {

    private Log log;

    public Logger(Class<?> loggerClass) {
        log = LogFactory.createLog(loggerClass);
    }

    public void error(String message, Object... params) {
        error(message, null, params);
    }

    public void error(String message, Exception cause, Object... params) {
        log.error(Message.msg(cause, message, params));
    }

    public void warn(String message, Object... params) {
        log.warn(Message.msg(message, params));
    }

    public void info(String message, Object... params) {
        log.info(Message.msg(message, params));
    }

    public void debug(String message, Object... params) {
        log.debug(Message.msg(message, params));
    }

    public void trace(String message, Object... params) {
        log.trace(Message.msg(message, params));
    }
}
