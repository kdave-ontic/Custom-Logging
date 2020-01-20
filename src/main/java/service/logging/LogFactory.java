package service.logging;

public class LogFactory {
    public static Log createLog(Class<?> loggerClass) {
        return new MyLog(loggerClass);
    }
}
