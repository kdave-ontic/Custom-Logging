package service.logging;

public class LogDriver {
    public static void main(String[] args) {
        Logger logger = new Logger(LogDriver.class);
        logger.info("hi!");
    }
}
